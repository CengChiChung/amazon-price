package com.millie.amazonprice.service.biz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.millie.amazonprice.base.BooleanStatus;
import com.millie.amazonprice.dto.CommissionDto;
import com.millie.amazonprice.param.SourceData;
import com.millie.amazonprice.po.CommissionPo;
import com.millie.amazonprice.po.SizePo;
import com.millie.amazonprice.service.CommissionService;
import com.millie.amazonprice.service.SizeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AmazonPriceService {

    @Autowired
    private CommissionService commissionService;
    @Autowired
    private SizeService sizeService;

    /**
     * 计算亚马逊佣金费用
     */
    public CommissionDto getCommission(SourceData sourceData) throws Exception {
        BigDecimal salePriceUsd = sourceData.getSalePriceUsd();
        String categoryCode = sourceData.getCategoryCode();
        QueryWrapper<CommissionPo> wrapper = new QueryWrapper<>();
        wrapper.eq(CommissionPo.CATEGORY_CODE, categoryCode);
        List<CommissionPo> commissionPoList = commissionService.list(wrapper);
        if (CollectionUtils.isEmpty(commissionPoList)) {
            throw new Exception("Error");
        }

        // 只查出一条佣金标准，说明可以直接进行计算
        if (commissionPoList.size() == 1) {
            CommissionPo commissionPo = commissionPoList.get(0);
            BigDecimal result = salePriceUsd
                    .multiply(commissionPo.getCommissionPercent())
                    .divide(new BigDecimal(100), 2, RoundingMode.UP);
            result = result.compareTo(commissionPo.getMinCommission()) > 0 ? result : commissionPo.getMinCommission();
            result = result.add(commissionPo.getAddition());
            String remark = String.format("该类目收取%s%%的销售佣金，最低佣金为$%s，交易手续费为$%s。佣金总计：$%s。",
                    commissionPo.getCommissionPercent().toPlainString(),
                    commissionPo.getMinCommission().toPlainString(),
                    commissionPo.getAddition().toPlainString(),
                    result.toPlainString());
            return CommissionDto.builder().commission(result).remark(remark).build();
        }

        // 非分段式收费
        if (BooleanStatus.NO.equals(commissionPoList.get(0).getIsSplitCost())) {
            List<CommissionPo> list = commissionPoList.stream().sorted(Comparator.comparing(CommissionPo::getBegin).reversed()).collect(Collectors.toList());
            CommissionPo commissionPo = list.stream().filter(i -> salePriceUsd.compareTo(i.getBegin()) > 0).findFirst().get();
            BigDecimal result = salePriceUsd
                    .multiply(commissionPo.getCommissionPercent())
                    .divide(new BigDecimal(100), 2, RoundingMode.UP);
            result =  result.compareTo(commissionPo.getMinCommission()) > 0 ? result : commissionPo.getMinCommission();
            result = result.add(commissionPo.getAddition());
            String remark = String.format("该类目不同销售价格收取不同的销售佣金，该商品售价超过$%s，收取%s%%的销售佣金，最低佣金为$%s，交易手续费为$%s。佣金总计：$%s。",
                    commissionPo.getBegin().toPlainString(),
                    commissionPo.getCommissionPercent().toPlainString(),
                    commissionPo.getMinCommission().toPlainString(),
                    commissionPo.getAddition().toPlainString(),
                    result.toPlainString());
            return CommissionDto.builder().commission(result).remark(remark).build();
        }

        // 分段式收费（存在多段）
        List<CommissionPo> list = commissionPoList.stream().sorted(Comparator.comparing(CommissionPo::getBegin)).collect(Collectors.toList());
        BigDecimal result = new BigDecimal(0);
        StringBuilder remarkBuilder = new StringBuilder("该类目分段收费。");
        for (CommissionPo commissionPo : list) {
            if (salePriceUsd.compareTo(commissionPo.getBegin()) > 0) {
                if (salePriceUsd.compareTo(commissionPo.getEnd()) > 0 && commissionPo.getEnd().compareTo(new BigDecimal("-1")) != 0) {
                    BigDecimal temp = commissionPo.getEnd().subtract(commissionPo.getBegin())
                            .multiply(commissionPo.getCommissionPercent())
                            .divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
                    result = temp.add(result);
                    remarkBuilder.append(String.format("$%s-$%s部分，收取%s%%佣金，佣金小计：$%s；",
                            commissionPo.getBegin().toPlainString(),
                            commissionPo.getEnd().toPlainString(),
                            commissionPo.getCommissionPercent().toPlainString(),
                            temp.toPlainString()));
                } else {
                    BigDecimal temp = salePriceUsd.subtract(commissionPo.getBegin())
                            .multiply(commissionPo.getCommissionPercent())
                            .divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
                    result = temp.add(result);
                    remarkBuilder.append(String.format("超过$%s的部分，收取%s%%佣金，佣金小计：$%s；",
                            commissionPo.getBegin(),
                            commissionPo.getCommissionPercent().toPlainString(),
                            temp.toPlainString()
                    ));
                }
            }
        }
        CommissionPo firstCommissionPo = list.get(0);
        result = result.compareTo(firstCommissionPo.getMinCommission()) > 0 ? result : firstCommissionPo.getMinCommission();
        result = result.add(firstCommissionPo.getAddition()).setScale(2,RoundingMode.UP);
        remarkBuilder.append(String.format("最低佣金为$%s，交易手续费为$%s。佣金总计：$%s。",
                firstCommissionPo.getMinCommission().toPlainString(),
                firstCommissionPo.getAddition().toPlainString(),
                result.toPlainString()));
        String remark = remarkBuilder.toString();
        return CommissionDto.builder().commission(result).remark(remark).build();
    }

    /**
     * 确定商品的尺寸标准.
     */
    public SizePo determineSize(SourceData sourceData) throws Exception {
        BigDecimal skuWeight = sourceData.getSkuWeight();
        List<BigDecimal> longList = new ArrayList<>();
        longList.add(sourceData.getSkuLength());
        longList.add(sourceData.getSkuWidth());
        longList.add(sourceData.getSkuHeight());
        longList.sort(BigDecimal::compareTo);
        // 长度+围度：最长边+（最短边+次短边）*2
        BigDecimal girth = longList.get(0).add(longList.get(1)).multiply(new BigDecimal("2")).add(longList.get(2));

        List<SizePo> sizePoList = sizeService.list();
        sizePoList = sizePoList.stream().sorted(Comparator.comparing(SizePo::getQueue)).collect(Collectors.toList());
        for (SizePo sizePo : sizePoList) {
            if ((sizePo.getFirstLong().compareTo(new BigDecimal("-1")) == 0 || longList.get(2).compareTo(sizePo.getFirstLong()) <= 0) &&
                (sizePo.getSecondLong().compareTo(new BigDecimal("-1")) == 0 || longList.get(1).compareTo(sizePo.getSecondLong()) <= 0) &&
                (sizePo.getThirdLong().compareTo(new BigDecimal("-1")) == 0 || longList.get(0).compareTo(sizePo.getThirdLong()) <= 0) &&
                (sizePo.getMaxWeight().compareTo(new BigDecimal("-1")) == 0 || skuWeight.compareTo(sizePo.getMaxWeight()) <= 0) &&
                (sizePo.getGirth().compareTo(new BigDecimal("-1")) == 0 || girth.compareTo(sizePo.getGirth()) <= 0)
            ) {
                return sizePo;
            }
        }
        throw new Exception("Error");
    }


}
