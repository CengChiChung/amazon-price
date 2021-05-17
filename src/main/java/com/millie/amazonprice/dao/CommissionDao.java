package com.millie.amazonprice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.millie.amazonprice.po.CommissionPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommissionDao extends BaseMapper<CommissionPo> {
}
