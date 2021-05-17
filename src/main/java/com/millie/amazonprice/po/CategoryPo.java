package com.millie.amazonprice.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("category")
public class CategoryPo {

    private Long id;  // 主键

    private String code;  // 目录编码

    private String name;  // 目录名称

    private Integer isClothes;  // 是否服装类

    private Integer queue;  // 显示顺序

    public static final String ID = "id";
    public static final String CODE = "code";
    public static final String NAME = "name";
    public static final String IS_CLOTHES = "is_clothes";
    public static final String QUEUE = "queue";
}
