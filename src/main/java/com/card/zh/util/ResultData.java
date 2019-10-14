package com.card.zh.util;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther:
 * @Description:
 * @Date: 2019/10/9 17:06
 */
@Data
public class ResultData implements Serializable {

    @ApiModelProperty("操作成功失败表示，0=成功，1=失败")
    private int resultCode;
    @ApiModelProperty("返回提示信息")
    private String message;
    @ApiModelProperty("返回对象数据")
    private Object data;

    /**
     *  成功 resultCode =0； 失败 resultCode = 1
     * @return
     */
    public static ResultData success() {
        ResultData result = new ResultData();
        result.setResultCode(0);
        result.setMessage("操作成功");
        result.setData(null);
        return result;
    }

    /**
     *  成功 resultCode =0； 失败 resultCode = 1
     * @return
     */
    public static ResultData success(String message) {
        ResultData result = new ResultData();
        result.setResultCode(0);
        result.setMessage(message);
        result.setData(null);
        return result;
    }

    /**
     * 成功 resultCode =0； 失败 resultCode = 1
     *
     * @return
     */
    public static ResultData success(Object data) {
        ResultData result = new ResultData();
        result.setResultCode(0);
        result.setMessage("操作成功");
        result.setData(data);
        return result;
    }

    /**
     * 成功 resultCode =0； 失败 resultCode = 1
     *
     * @return
     */
    public static ResultData success(String message, Object data) {
        ResultData result = new ResultData();
        result.setResultCode(0);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    /**
     * 成功 resultCode =0； 失败 resultCode = 1
     *
     * @return
     */
    public static ResultData error() {
        ResultData result = new ResultData();
        result.setResultCode(1);
        result.setMessage("操作失败");
        result.setData(null);
        return result;
    }

    /**
     * 成功 resultCode =0； 失败 resultCode = 1
     *
     * @return
     */
    public static ResultData error(String message) {
        ResultData result = new ResultData();
        result.setResultCode(1);
        result.setMessage(message);
        result.setData(null);
        return result;
    }



}
