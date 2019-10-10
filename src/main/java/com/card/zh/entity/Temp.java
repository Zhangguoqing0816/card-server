package com.card.zh.entity;

import com.baomidou.mybatisplus.annotations.TableField;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author zhanggq
 * @since 2019-10-10
 */
public class Temp implements Serializable {

    private static final long serialVersionUID = 1L;

    private String aa;
    private String bb;
    @TableField("zhang_gq")
    private String zhangGq;


    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    public String getBb() {
        return bb;
    }

    public void setBb(String bb) {
        this.bb = bb;
    }

    public String getZhangGq() {
        return zhangGq;
    }

    public void setZhangGq(String zhangGq) {
        this.zhangGq = zhangGq;
    }

    @Override
    public String toString() {
        return "Temp{" +
                ", aa=" + aa +
                ", bb=" + bb +
                ", zhangGq=" + zhangGq +
                "}";
    }
}
