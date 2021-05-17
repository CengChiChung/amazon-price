package com.millie.amazonprice.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnumVo implements Serializable {

    private static final long serialVersionUID = 456345861L;

    private String code;  // 枚举编码

    private String name;  // 枚举名称
}
