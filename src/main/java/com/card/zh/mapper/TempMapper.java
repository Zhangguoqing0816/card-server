package com.card.zh.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.card.zh.entity.Temp;
import org.springframework.stereotype.Repository;

@Repository
public interface TempMapper extends BaseMapper<Temp> {
    Integer insert(Temp record);

    int insertSelective(Temp record);
}