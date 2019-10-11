package com.card.zh.cardserver;

import com.card.zh.comp.config.SpringContextUtils;
import com.card.zh.mapper.SequenceMapper;
import com.card.zh.service.SequenceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SeqnoTest {

    private static final Logger Log = LoggerFactory.getLogger(SeqnoTest.class);

    @Autowired
    SequenceService sequenceService;


    @Test
    public void test() {
        Long sqno1 = sequenceService.getNumSeqno("CD", 0);
        String sqno2 = sequenceService.getStrSeqno("CD", 0);
        System.out.println(sqno1);
        System.out.println(sqno2);
    }


}
