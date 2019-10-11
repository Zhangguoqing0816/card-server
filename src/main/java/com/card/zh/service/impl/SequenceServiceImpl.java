package com.card.zh.service.impl;

import com.card.zh.entity.Sequence;
import com.card.zh.mapper.SeqnoMapper;
import com.card.zh.service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("SequenceService")
public class SequenceServiceImpl implements SequenceService {


    @Autowired
    SeqnoMapper seqnoMapper;

    /**
     * 根据类型获取序列
     *
     * @param idName
     * @return nextval
     */
    @Override
    public long getSequence(String idName) {
        Sequence sequence = seqnoMapper.selectSno(idName);
        Long nextval = null;
        if (sequence == null) {
            sequence = new Sequence(idName, 1L, 2L);
            seqnoMapper.insertSno(sequence);
            nextval = sequence.getNextval();
            return nextval;
        } else {
            //1、获取下一个值
            nextval = sequence.getNextval();
            sequence.setCurrval(nextval);
            sequence.setNextval(nextval + 1);
            sequence.setIdName(idName);
            seqnoMapper.updateSno(sequence);
            return nextval;
        }

    }


}
