package com.millie.amazonprice.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("commission")
public class CommissionPo {

    private Long id;  // 主键

    private String categoryCode;  // 目录编码

    private Integer section;  // 第n段收费

    private BigDecimal begin;  // 征收起点

    private BigDecimal end;  // 征收终点

    private BigDecimal commissionPercent;  // 销售佣金百分比

    private BigDecimal minCommission;  // 最低销售佣金

    private Integer isSplitCost;  // 是否分段收费

    private BigDecimal addition;  // 附加费用（例如：交易手续费）


    public static final String ID = "id";
    public static final String CATEGORY_CODE = "category_code";
    public static final String SECTION = "section";
    public static final String BEGIN = "begin";
    public static final String END = "end";
    public static final String COMMISSION_PERCENT = "commission_percent";
    public static final String MIN_COMMISSION = "min_commission";
    public static final String IS_SPLIT_COST = "is_split_cost";
    public static final String ADDITION = "addition";
}
