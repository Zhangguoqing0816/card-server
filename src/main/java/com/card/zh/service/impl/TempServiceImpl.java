package com.card.zh.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.card.zh.entity.Temp;
import com.card.zh.mapper.TempMapper;
import com.card.zh.service.ITempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Auther:
 * @Description:
 * @Date: 2019/10/9 16:16
 */
@Service
public class TempServiceImpl  extends ServiceImpl<TempMapper, Temp> implements ITempService {

    @Autowired
    private TempMapper tempMapper;

    @Override
    public Temp queryBy(String aa) {
        return tempMapper.queryBy(aa);
    }
}
