package com.millie.amazonprice.param;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SourceData implements Serializable {

    private static final long serialVersionUID = 1453465313L;

    private BigDecimal salePriceUsd;  // 销售价格，币种：USD

    private String categoryCode;  // 目录编码

    private BigDecimal skuLength;  // 产品的长

    private BigDecimal skuWidth;  // 产品的宽

    private BigDecimal skuHeight;  // 产品的高

    private BigDecimal skuWeight;  // 产品的重量
}
