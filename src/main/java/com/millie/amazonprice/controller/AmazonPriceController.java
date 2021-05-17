package com.millie.amazonprice.controller;

import com.millie.amazonprice.dto.CommissionDto;
import com.millie.amazonprice.param.SourceData;
import com.millie.amazonprice.po.CategoryPo;
import com.millie.amazonprice.service.CategoryService;
import com.millie.amazonprice.service.biz.AmazonPriceService;
import com.millie.amazonprice.vo.EnumVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AmazonPriceController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private AmazonPriceService amazonPriceService;

    @GetMapping("getCategoryEnum")
    public List<EnumVo> categoryEnum() {
        List<CategoryPo> categoryPoList = categoryService.list();
        categoryPoList.sort(Comparator.comparing(CategoryPo::getQueue));
        return categoryPoList.stream().map(i -> {
            EnumVo enumVo = new EnumVo();
            enumVo.setCode(i.getCode());
            enumVo.setName(i.getName());
            return enumVo;
        }).collect(Collectors.toList());
    }

    @PostMapping("getPrice")
    public CommissionDto amazonPrice(@RequestBody SourceData sourceData) throws Exception {
        CommissionDto commissionDto = amazonPriceService.getCommission(sourceData);// 佣金。commission（美金单位）
//        SizePo sizePo = amazonPriceService.determineSize(sourceData);  // 尺寸
        return commissionDto;
    }


}
