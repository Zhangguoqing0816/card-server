package com.card.zh.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 用户详细信息表
 * </p>
 *
 * @author zhanggq
 * @since 2019-10-14
 */
@TableName("user_info")
@Data
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    /**
     * 用户名称
     */
    @TableField("user_name")
    private String userName;
    /**
     * 登录账号
     */
    //private String account;
    /**
     * 用户昵称
     */
    @TableField("nick_name")
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
    @TableField("wechat_number")
    private String wechatNumber;
    /**
     * 微信二维码
     */
    @TableField("wechat_qr_code")
    private String wechatQrCode;

    /**
     * QQ号码
     */
    @TableField("qq_number")
    private String qqNumber;
    /**
     * QQ二维码
     */
    @TableField("qq_qr_code")
    private String qqQrCode;
    /**
     * 头像url
     */
    @TableField("head_sculpture")
    private String headSculpture;
    /**
     * 公司名称
     */
    @TableField("company_name")
    private String companyName;
    /**
     * 公司电话
     */
    @TableField("company_phone")
    private String companyPhone;
    /**
     * 传真号码
     */
    @TableField("company_fax")
    private String companyFax;
    /**
     * 公司地址
     */
    @TableField("company_address")
    private String companyAddress;
    /**
     * 职位
     */
    @TableField("company_job_name")
    private String companyJobName;
    /**
     * 公司网址
     */
    @TableField("company_internet_address")
    private String companyInternetAddress;
    /**
     * 背景音乐地址
     */
    private String bgsound;

    /**
     * 内容
     */
    private String content;

    /**
     * 公司业务
     */
    @TableField("company_business")
    private String companyBusiness;
    /**
     * 公司供给
     */
    @TableField("company_supply")
    private String companySupply;
    /**
     * 公司需求
     */
    @TableField("company_demand")
    private String companyDemand;
    /**
     * 公司百度地图坐标
     */
    @TableField("company_map_place")
    private String companyMapPlace;
    /**
     * 银行名称
     */
    @TableField("bank_name")
    private String bankName;
    /**
     * 银行开户姓名
     */
    @TableField("bank_user_name")
    private String bankUserName;
    /**
     * 银行账号
     */
    @TableField("bank_account")
    private String bankAccount;
    /**
     * 账号状态
     */
    @TableField("account_status")
    private String accountStatus = "START";

    /**
     * 界面风格
     * AUTO - 默认风格
     */
    @TableField("page_style")
    private String pageStyle = "AUTO";



    @Override
    public String toString() {
        return "UserInfo{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                // ", account='" + account + '\'' +
                ", nickName='" + nickName + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", wechatNumber='" + wechatNumber + '\'' +
                ", wechatQrCode='" + wechatQrCode + '\'' +
                ", qqNumber='" + qqNumber + '\'' +
                ", qqQrCode='" + qqQrCode + '\'' +
                ", headSculpture='" + headSculpture + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyPhone='" + companyPhone + '\'' +
                ", companyFax='" + companyFax + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", companyJobName='" + companyJobName + '\'' +
                ", companyInternetAddress='" + companyInternetAddress + '\'' +
                ", bgsound='" + bgsound + '\'' +
                ", content='" + content + '\'' +
                ", companyBusiness='" + companyBusiness + '\'' +
                ", companySupply='" + companySupply + '\'' +
                ", companyDemand='" + companyDemand + '\'' +
                ", companyMapPlace='" + companyMapPlace + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankUserName='" + bankUserName + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", accountStatus='" + accountStatus + '\'' +
                ", pageStyle='" + pageStyle + '\'' +
                '}';
    }

}
