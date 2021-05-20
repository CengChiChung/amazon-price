package com.millie.amazonprice.controller;

import com.millie.amazonprice.po.CategoryPo;
import com.millie.amazonprice.service.CategoryService;
import com.millie.amazonprice.vo.EnumVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class AmazonPriceControllerTest {

    @Mock
    CategoryService categoryService;

    @InjectMocks
    AmazonPriceController amazonPriceController;

    @Test
    public void testCategoryEnum() {
        CategoryPo cate1 = CategoryPo.builder().id(1L).queue(4).code("NO.4").name("第1名").build();
        CategoryPo cate2 = CategoryPo.builder().id(2L).queue(3).code("NO.3").name("第2名").build();
        CategoryPo cate3 = CategoryPo.builder().id(3L).queue(2).code("NO.2").name("第3名").build();
        CategoryPo cate4 = CategoryPo.builder().id(4L).queue(1).code("NO.1").name("第4名").build();
        List<CategoryPo> list = new ArrayList<>();
        list.add(cate1);
        list.add(cate2);
        list.add(cate3);
        list.add(cate4);
        Mockito.when(categoryService.list()).thenReturn(list);
        List<EnumVo> enumVos = amazonPriceController.categoryEnum();
        System.out.println(enumVos);
        Mockito.verify(categoryService,Mockito.times(1)).list();
    }

}