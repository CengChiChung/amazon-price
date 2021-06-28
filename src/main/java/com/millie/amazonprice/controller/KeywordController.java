package com.millie.amazonprice.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.millie.amazonprice.excel.KeywordEntity;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class KeywordController {

    @PostMapping("upload")
    public void uploadKeywordExcel(@RequestParam("file") MultipartFile multipartFile, HttpServletResponse response) throws Exception{
        ImportParams params = new ImportParams();
        params.setHeadRows(1);
        List<KeywordEntity> excel = ExcelImportUtil.importExcel(multipartFile.getInputStream(), KeywordEntity.class, params);
        Map<String, Integer> keywordMap = excel.stream().collect(Collectors.toMap(KeywordEntity::getKeyword, KeywordEntity::getSearchNum, Integer::sum));
        List<KeywordEntity> keywordList = new ArrayList<>();
        keywordMap.forEach((key, value) -> {
            KeywordEntity keywordEntity = new KeywordEntity(key, value);
            keywordList.add(keywordEntity);
        });
        keywordList.sort((p1,p2) -> p2.getSearchNum().compareTo(p1.getSearchNum()));
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), KeywordEntity.class, keywordList);
        String fileName = "统计后数据";
        response.setContentType("application/vnd.ms-excel;chartset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + ".xls\"");
        ServletOutputStream out = response.getOutputStream();
        workbook.write(out);
        out.flush();
        out.close();
    }
}
