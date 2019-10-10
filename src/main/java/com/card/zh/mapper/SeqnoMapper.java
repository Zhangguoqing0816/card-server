package com.card.zh.mapper;

import com.card.zh.entity.Seqno;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SeqnoMapper {

    Seqno querySeqNo(@Param("seqType") String seqType, @Param("genDate") String genDate);

    int updateSeqNo(Seqno seqno);

    int insertSeqNo(Seqno seqno);

}
