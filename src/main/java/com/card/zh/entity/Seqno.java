package com.card.zh.entity;

import org.apache.commons.lang3.StringUtils;

public class Seqno {
    private String seqType;
    private String genDate;
    private Long curValue;

    public String getSeqType() {
        return seqType;
    }

    public void setSeqType(String seqType) {
        this.seqType = seqType;
    }

    public String getGenDate() {
        return genDate;
    }

    public void setGenDate(String genDate) {
        this.genDate = genDate;
    }

    /**
     * 获取当前序列值
     *
     * @return
     */
    public Long getCurValue() {
        return curValue;
    }

    public void setCurValue(Long curValue) {
        this.curValue = curValue;
    }

    /**
     * 每次自增的值
     *
     * @param increment
     */
    public void increment(int increment) {
        this.curValue = this.curValue + increment;
    }

    /**
     * 获取格式化后编号如当前编号为1，size设置为3,则输出结果为001
     *
     * @param size
     * @return 返回格式化后的序号
     */
    public String getFormatValue(int size) {
        return this.getSeqType()+this.getGenDate()+StringUtils.leftPad(String.valueOf(this.curValue), size, '0').trim();
    }
}
