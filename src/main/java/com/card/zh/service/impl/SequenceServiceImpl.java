package com.card.zh.service.impl;

import com.card.zh.comp.config.SpringContextUtils;
import com.card.zh.entity.Sequence;
import com.card.zh.mapper.SequenceMapper;
import com.card.zh.service.SequenceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


@Service("SequenceService")
public class SequenceServiceImpl implements SequenceService {
    private static ThreadLocal<SequenceMapper> threadLocal = new ThreadLocal<SequenceMapper>();

    //创建同步锁对象
    private static Lock lock = new ReentrantLock();
    private SequenceMapper sequenceMapper = getCurrentMapper();

    /**
     * 根据类型获取序列
     *
     * @param idName
     * @return nextval
     */
    private long getSequence(String idName) {
        lock.lock();
        Sequence sequence = sequenceMapper.selectSno(idName);
        Long nextval = null;
        if (sequence == null) {
            sequence = new Sequence(idName, 1L, 2L);
            sequenceMapper.insertSno(sequence);
            nextval = sequence.getNextval();
        } else {
            //1、获取下一个值
            nextval = sequence.getNextval();
            sequence.setCurrval(nextval);
            sequence.setNextval(nextval + 1);
            sequence.setIdName(idName);
            sequenceMapper.updateSno(sequence);

        }
        lock.unlock();
        return nextval;
    }


    /**
     * 在同一个对象中读取序列
     *
     * @return
     */
    private SequenceMapper getCurrentMapper() {
        lock.lock();
        SequenceMapper mapper = threadLocal.get();
        if (mapper == null) {
            mapper = SpringContextUtils.getBean(SequenceMapper.class);
            threadLocal.set(mapper);
        }
        lock.lock();
        return mapper;
    }


    /**
     * 获取字符串类型的序列
     *
     * @param idName 序列类型
     * @param size   可变数值长度
     * @return String类型的不重复序列
     */
    public String getStrSeqno(String idName, Integer size) {
        if (size == null) size = 5;
        String sqNostr = StringUtils.leftPad(String.valueOf(getSequence(idName)), size, '0');
        StringBuffer sb = new StringBuffer();
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        sb.append(idName).append(date).append(sqNostr);
        return sb.toString();
    }

    /**
     * 获取Long类型的序列
     *
     * @param idName 序列类型
     * @param size   可变数值长度
     * @return Long类型的不重复序列
     */
    public Long getNumSeqno(String idName, Integer size) {
        if (size == null) size = 5;
        String sqNostr = StringUtils.leftPad(String.valueOf(getSequence(idName)), size, '0');
        StringBuffer sb = new StringBuffer();
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        sb.append(date).append(sqNostr);
        return Long.valueOf(sb.toString());
    }
}
