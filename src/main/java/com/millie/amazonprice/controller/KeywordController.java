package com.millie.amazonprice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class KeywordController {

    @PostMapping("uploadKeywordExcel")
    public void uploadKeywordExcel(@RequestBody MultipartFile multipartFile) {


    }
}
