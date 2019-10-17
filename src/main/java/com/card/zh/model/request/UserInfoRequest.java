package com.card.zh.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Auther:
 * @Description:
 * @Date: 2019/10/14 11:32
 */
@Data
public class UserInfoRequest {
    /**
     * 用户名称
     */
    @ApiModelProperty("用户名称")
    private String userName;
    /**
     * 登录账号
     */
//    @ApiModelProperty("登录账号")
//    private String account;
    /**
     * 用户昵称
     */
    @ApiModelProperty("用户昵称")
    private String nickName;
    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private String sex;
    /**
     * 电话号码
     */
    @ApiModelProperty("电话号码")
    private String phone;
    /**
     * 邮箱地址
     */
    @ApiModelProperty("邮箱地址")
    private String email;
    /**
     * 登录密码
     */
    @ApiModelProperty("登录密码")
    private String password;
    /**
     * 微信号码
     */
    @ApiModelProperty("微信号码")
    private String wechatNumber;
    /**
     * 微信二维码
     */
    @ApiModelProperty("微信二维码")
    private String wechatQrCode;

    /**
     * QQ号码
     */
    @ApiModelProperty("QQ号码")
    private String qqNumber;
    /**
     * QQ二维码
     */
    @ApiModelProperty("QQ二维码")
    private String qqQrCode;
    /**
     * 头像url
     */
    @ApiModelProperty("头像url")
    private String headSculpture;
    /**
     * 公司名称
     */
    @ApiModelProperty("公司名称")
    private String companyName;
    /**
     * 公司电话
     */
    @ApiModelProperty("公司电话")
    private String companyPhone;
    /**
     * 传真号码
     */
    @ApiModelProperty("传真号码")
    private String companyFax;
    /**
     * 公司地址
     */
    @ApiModelProperty("公司地址")
    private String companyAddress;
    /**
     * 职位
     */
    @ApiModelProperty("职位")
    private String companyJobName;
    /**
     * 公司网址
     */
    @ApiModelProperty("公司网址")
    private String companyInternetAddress;
    /**
     * 背景音乐地址
     */
    @ApiModelProperty("背景音乐地址")
    private String bgsound;
    /**
     * 公司业务
     */
    @ApiModelProperty("公司业务")
    private String companyBusiness;
    /**
     * 公司供给
     */
    @ApiModelProperty("公司供给")
    private String companySupply;
    /**
     * 公司需求
     */
    @ApiModelProperty("公司需求")
    private String companyDemand;
    /**
     * 公司百度地图坐标
     */
    @ApiModelProperty("公司百度地图坐标")
    private String companyMapPlace;
    /**
     * 银行名称
     */
    @ApiModelProperty("银行名称")
    private String bankName;
    /**
     * 银行开户姓名
     */
    @ApiModelProperty("银行开户姓名")
    private String bankUserName;
    /**
     * 银行账号
     */
    @ApiModelProperty("银行账号")
    private String bankAccount;
    /**
     * 账号状态
     */
    @ApiModelProperty("账号状态")
    private String accountStatus;

    /**
     * 界面风格
     */
    @ApiModelProperty("界面风格")
    private String pageStyle;

    @ApiModelProperty("内容图片上传后反返回的所有ID")
    private List<String> attachIdList;
}
