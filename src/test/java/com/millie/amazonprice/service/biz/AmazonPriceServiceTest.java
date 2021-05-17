package com.millie.amazonprice.service.biz;

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

}