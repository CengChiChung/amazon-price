package com.millie.amazonprice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.millie.amazonprice.dao.SizeDao;
import com.millie.amazonprice.po.SizePo;
import com.millie.amazonprice.service.SizeService;
import org.springframework.stereotype.Service;

@Service
public class SizeServiceImpl extends ServiceImpl<SizeDao, SizePo> implements SizeService {
}
