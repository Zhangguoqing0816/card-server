package com.card.zh.controller;

import com.card.zh.service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Auther:
 * @Description:
 * @Date: 2019/10/11 10:40
 */
public class BaseController {
    @Autowired
    SequenceService sequenceService;

    /**
     * 生成主键
     * @param seqType 主键类型
     * @param numSize 尾部数字长度
     * @return
     */
    public String genSeqNo(String seqType, int numSize) {
        return sequenceService.getStrSeqno(seqType,null);
    }
}
