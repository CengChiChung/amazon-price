package com.millie.amazonprice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.millie.amazonprice.dao.CommissionDao;
import com.millie.amazonprice.po.CommissionPo;
import com.millie.amazonprice.service.CommissionService;
import org.springframework.stereotype.Service;

@Service
public class CommissionServiceImpl extends ServiceImpl<CommissionDao, CommissionPo> implements CommissionService {
}
