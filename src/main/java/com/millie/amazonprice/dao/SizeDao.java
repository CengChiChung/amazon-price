package com.millie.amazonprice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.millie.amazonprice.po.SizePo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SizeDao extends BaseMapper<SizePo> {
}
