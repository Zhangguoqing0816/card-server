package com.card.zh.model.session;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther:
 * @Description:
 * @Date: 2019/10/9 15:29
 */
@Data
public class SessionModel implements Serializable {

    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 性别
     */
    private String sex;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 邮箱地址
     */
    private String email;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 微信号码
     */
    private String wechatNumber;
    /**
     * 微信二维码
     */
    private byte[] wechatQrCode;

    /**
     * QQ号码
     */
    private String qqNumber;
    /**
     * QQ二维码
     */
    @ApiModelProperty("QQ二维码")
    private byte[] qqQrCode;
    /**
     * 头像url
     */
    private String headSculpture;
    /**
     * 公司名称
     */
    private String companyName;
    /**
     * 公司电话
     */
    private String companyPhone;
    /**
     * 传真号码
     */
    private String companyFax;
    /**
     * 公司地址
     */
    private String companyAddress;
    /**
     * 职位
     */
    private String companyJobName;
    /**
     * 公司网址
     */
    private String companyInternetAddress;
    /**
     * 背景音乐地址
     */
    private String bgsound;
    /**
     * 公司业务
     */
    private String companyBusiness;
    /**
     * 公司供给
     */
    private String companySupply;
    /**
     * 公司需求
     */
    private String companyDemand;
    /**
     * 公司百度地图坐标
     */
    private String companyMapPlace;
    /**
     * 银行名称
     */
    private String bankName;
    /**
     * 银行开户姓名
     */
    private String bankUserName;
    /**
     * 银行账号
     */
    private String bankAccount;
    /**
     * 账号状态
     */
    private String accountStatus;

}
