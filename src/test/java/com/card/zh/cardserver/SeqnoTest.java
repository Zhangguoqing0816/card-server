package com.card.zh.cardserver;

import com.card.zh.service.SeqnoService;
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

    @Autowired
    SeqnoService seqnoService;
    private static final Logger Log = LoggerFactory.getLogger(SeqnoTest.class);


    @Test
    public void test() {

        String  seqno = seqnoService.getDateSeqNo("U").getFormatValue(5);
        Log.info(seqno);

    }

}
