package com.millie.amazonprice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommissionDto {
    private BigDecimal commission;  // 计算出来的佣金（单位：美元）

    private String remark;  // 佣金备注
}
