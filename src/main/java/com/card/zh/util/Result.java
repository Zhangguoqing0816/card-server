package com.card.zh.util;

/**
 * @Auther:
 * @Description:
 * @Date: 2019/10/9 17:06
 */
public class Result<T> {
    private String resultCode;
    private String resultMsg;
    private T data;
    public Result(String resultCode, T data) {
        this.resultCode =  resultCode;
        this.data = data;
    }
}
