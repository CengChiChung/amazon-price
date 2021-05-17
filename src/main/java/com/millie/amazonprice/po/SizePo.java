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
@TableName("size")
public class SizePo {
    private Long id;  // 主键

    private String code;  // 尺寸编码

    private String name;  // 尺寸名称

    private BigDecimal maxWeight;  // 最大重量

    private BigDecimal firstLong;  // 最长边

    private BigDecimal secondLong;  // 次长边

    private BigDecimal thirdLong;  // 最短边

    private BigDecimal girth;  // 长度+围度

    private Integer queue;  // 顺序

    public static final String ID = "id";
    public static final String CODE = "code";
    public static final String NAME = "name";
    public static final String MAX_WEIGHT = "max_weight";
    public static final String FIRST_LONG = "first_long";
    public static final String SECOND_LONG = "second_long";
    public static final String THIRD_LONG = "third_long";
    public static final String GIRTH = "girth";
    public static final String QUEUE = "queue";
}
