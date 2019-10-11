package com.card.zh.cardserver;

import com.card.zh.comp.config.SpringContextUtils;
import com.card.zh.mapper.SeqnoMapper;
import com.card.zh.service.SeqnoService;
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
        SeqnoMapper m2=SpringContextUtils.getBean(SeqnoMapper.class);
//        SeqnoMapper m3= SpringContextUtils.getBean("com.card.zh.mapper.SeqnoMapper",SeqnoMapper.class);
        SeqnoMapper m1= SpringContextUtils.getBean("SeqnoMapper",SeqnoMapper.class);
        System.out.println(m1=m2);
    }


}
