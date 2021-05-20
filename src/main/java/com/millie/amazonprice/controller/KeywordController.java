package com.millie.amazonprice.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.millie.amazonprice.excel.KeywordEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class KeywordController {

    @PostMapping("upload")
    public void uploadKeywordExcel(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        ImportParams params = new ImportParams();
        params.setHeadRows(1);
        List<KeywordEntity> excel = ExcelImportUtil.importExcel(multipartFile.getInputStream(), KeywordEntity.class, params);
        Map<String, Integer> keywordMap = excel.stream().collect(Collectors.toMap(KeywordEntity::getKeyword, KeywordEntity::getSearchNum, Integer::sum));
        System.out.println("aaaa");
    }
}
