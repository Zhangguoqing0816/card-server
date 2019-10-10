package com.card.zh.service.impl;

import com.card.zh.entity.Seqno;
import com.card.zh.mapper.SeqnoMapper;
import com.card.zh.service.SeqnoService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service("SeqnoService")
public class SeqnoServiceImpl implements SeqnoService {


    @Autowired
    SeqnoMapper seqnoMapper;


    /**
     * 保存序列信息并返回结果
     *
     * @param seqType
     * @param genDate
     * @return
     */
    private Seqno saveSeqNo(String seqType, String genDate) {
        Seqno seqno = new Seqno();
        seqno.setCurValue(1L);
        seqno.setGenDate(genDate);
        seqno.setSeqType(seqType);
        this.seqnoMapper.insertSeqNo(seqno);
        return seqno;
    }


    /**
     * 根据类型获取含有日期信息的编号
     *
     * @param seqType 编号类型
     * @return 编号对象可以格式化编号
     */
    @Override
    public Seqno getDateSeqNo(String seqType) {
        String genDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
        Validate.notBlank(seqType, "编号类型不可为空");
        Validate.notBlank(genDate, "日期标志不可为空");
        Seqno seqno = seqnoMapper.querySeqNo(seqType, genDate);
        if (null == seqno) {
            seqno = saveSeqNo(seqType, genDate);
        } else {
            seqno.increment(1);
            this.seqnoMapper.updateSeqNo(seqno);
        }
        return seqno;
    }

    /**
     * 获取不含有日期信息的编码
     * @return
     */
    @Override
    public Seqno getSeqNo(String seqType) {
        Seqno seqno = seqnoMapper.querySeqNo(seqType, " ");
        if (null == seqno) {
            seqno = saveSeqNo(seqType, " ");
        } else {
            seqno.increment(1);
            this.seqnoMapper.updateSeqNo(seqno);
        }
        return seqno;
    }
}
