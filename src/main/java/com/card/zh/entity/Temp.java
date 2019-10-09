package com.card.zh.entity;

public class Temp {
    private String aa;

    private String bb;

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa == null ? null : aa.trim();
    }

    public String getBb() {
        return bb;
    }

    public void setBb(String bb) {
        this.bb = bb == null ? null : bb.trim();
    }
}