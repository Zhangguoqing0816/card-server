package com.card.zh.mapper;

import com.card.zh.entity.Sequence;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface SequenceMapper {

    /**
     * 查询序列
     *
     * @param idName
     * @return
     */
    Sequence selectSno(String idName);

    /**
     * 更新序列
     *
     * @param sequence
     * @return
     */
    int updateSno(Sequence sequence );
    /**
     * 添加新的序列
     * @param sequence 序列标志
     * @return
     */
    int insertSno(Sequence sequence);

}
