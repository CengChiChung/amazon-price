package com.millie.amazonprice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.millie.amazonprice.dao.CategoryDao;
import com.millie.amazonprice.po.CategoryPo;
import com.millie.amazonprice.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryPo> implements CategoryService {
}
