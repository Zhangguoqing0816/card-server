package com.card.zh.util;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * @Auther:
 * @Description:
 * @Date: 2019/10/9 17:06
 */
public class ResultData<T> implements Serializable {

    /**
     * 返回Json格式的字符串
     *
     * @param resultCode 返回状态吗 0：成功 1：失败
     * @param message    返回成功或失败的信息
     * @param data       返回数据
     * @return
     */
    public String assembleJsonInfo(String resultCode, String message, T data) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", resultCode);
        jsonObject.put("message", message);
        jsonObject.put("data", data);
        String jsonString = jsonObject.toJSONString();
        return jsonString;
    }
}
