package com.card.zh.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.card.zh.entity.Temp;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zhanggq
 * @since 2019-10-10
 */
@Repository
public interface TempMapper extends BaseMapper<Temp> {

    Temp queryBy(String aa);
}
