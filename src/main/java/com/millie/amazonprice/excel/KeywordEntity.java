package com.millie.amazonprice.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

@Data
public class KeywordEntity {

    @Excel(name = "关键词")
    private String keyword;

    @Excel(name = "搜索量")
    private Integer searchNum;

}
