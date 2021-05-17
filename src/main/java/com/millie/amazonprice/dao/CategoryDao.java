package com.millie.amazonprice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.millie.amazonprice.po.CategoryPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryDao extends BaseMapper<CategoryPo> {
}
