package com.millie.amazonprice.service.biz;

import com.millie.amazonprice.dto.CommissionDto;
import com.millie.amazonprice.param.SourceData;
import com.millie.amazonprice.po.SizePo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;


@SpringBootTest
class AmazonPriceServiceTest {

    @Autowired
    private AmazonPriceService amazonPriceService;

    @Test
    public void test() throws Exception {
        SourceData build = SourceData.builder()
                .skuHeight(new BigDecimal("152.4"))
                .skuLength(new BigDecimal("76.2"))
                .skuWidth(new BigDecimal("50.8"))
                .skuWeight(new BigDecimal("31751.47"))
                .build();
        SizePo sizePo = amazonPriceService.determineSize(build);
        System.out.println(sizePo.getName());
    }

    @Test
    public void test2() throws Exception {
        SourceData build = SourceData.builder()
                .categoryCode("CG000029")
                .salePriceUsd(new BigDecimal("7.99"))
                .build();
        CommissionDto commission = amazonPriceService.getCommission(build);
        System.out.println(commission);
    }

    /**
     * 3pack,$2.84(3.44)
     * 5pack,$3.61($4.29)
     * 10pack,$5.14($6.00)
     */
    @Test
    public void test3() throws Exception {
        BigDecimal price = new BigDecimal("6.99");
        SourceData build = SourceData.builder()
                .categoryCode("CG000029")
                .salePriceUsd(price)
                .build();
        CommissionDto commission = amazonPriceService.getCommission(build);
        BigDecimal result = price.subtract(commission.getCommission()).subtract(new BigDecimal("2.5"));
        System.out.println(result);
    }

}