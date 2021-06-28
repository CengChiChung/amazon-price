package com.millie.amazonprice.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KeywordEntity {

    @Excel(name = "关键词")
    private String keyword;

    @Excel(name = "搜索量")
    private Integer searchNum;

}
