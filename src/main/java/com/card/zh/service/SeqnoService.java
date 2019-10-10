package com.card.zh.service;

import com.card.zh.entity.Seqno;

public interface SeqnoService {

    public Seqno getDateSeqNo(String seqType);

    public Seqno getSeqNo(String seqType);


}
