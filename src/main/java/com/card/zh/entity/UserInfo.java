package com.card.zh.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Arrays;

/**
 * <p>
 * 用户详细信息表
 * </p>
 *
 * @author zhanggq
 * @since 2019-10-14
 */
@TableName("user_info")
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
    private String account;
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
    private byte[] wechatQrCode;

    /**
     * QQ号码
     */
    @TableField("qq_number")
    private String qqNumber;
    /**
     * QQ二维码
     */
    @TableField("qq_qr_code")
    private byte[] qqQrCode;
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
    private String accountStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWechatNumber() {
        return wechatNumber;
    }

    public void setWechatNumber(String wechatNumber) {
        this.wechatNumber = wechatNumber;
    }

    public void setWechatQrCode(byte[] wechatQrCode) {
        this.wechatQrCode = wechatQrCode;
    }

    public void setQqQrCode(byte[] qqQrCode) {
        this.qqQrCode = qqQrCode;
    }

    public String getQqNumber() {
        return qqNumber;
    }

    public void setQqNumber(String qqNumber) {
        this.qqNumber = qqNumber;
    }

    public byte[] getWechatQrCode() {
        return wechatQrCode;
    }

    public byte[] getQqQrCode() {
        return qqQrCode;
    }

    public String getHeadSculpture() {
        return headSculpture;
    }

    public void setHeadSculpture(String headSculpture) {
        this.headSculpture = headSculpture;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyFax() {
        return companyFax;
    }

    public void setCompanyFax(String companyFax) {
        this.companyFax = companyFax;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyJobName() {
        return companyJobName;
    }

    public void setCompanyJobName(String companyJobName) {
        this.companyJobName = companyJobName;
    }

    public String getCompanyInternetAddress() {
        return companyInternetAddress;
    }

    public void setCompanyInternetAddress(String companyInternetAddress) {
        this.companyInternetAddress = companyInternetAddress;
    }

    public String getBgsound() {
        return bgsound;
    }

    public void setBgsound(String bgsound) {
        this.bgsound = bgsound;
    }

    public String getCompanyBusiness() {
        return companyBusiness;
    }

    public void setCompanyBusiness(String companyBusiness) {
        this.companyBusiness = companyBusiness;
    }

    public String getCompanySupply() {
        return companySupply;
    }

    public void setCompanySupply(String companySupply) {
        this.companySupply = companySupply;
    }

    public String getCompanyDemand() {
        return companyDemand;
    }

    public void setCompanyDemand(String companyDemand) {
        this.companyDemand = companyDemand;
    }

    public String getCompanyMapPlace() {
        return companyMapPlace;
    }

    public void setCompanyMapPlace(String companyMapPlace) {
        this.companyMapPlace = companyMapPlace;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankUserName() {
        return bankUserName;
    }

    public void setBankUserName(String bankUserName) {
        this.bankUserName = bankUserName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", account='" + account + '\'' +
                ", nickName='" + nickName + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", wechatNumber='" + wechatNumber + '\'' +
                ", wechatQrCode=" + Arrays.toString(wechatQrCode) +
                ", qqNumber='" + qqNumber + '\'' +
                ", qqQrCode=" + Arrays.toString(qqQrCode) +
                ", headSculpture='" + headSculpture + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyPhone='" + companyPhone + '\'' +
                ", companyFax='" + companyFax + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", companyJobName='" + companyJobName + '\'' +
                ", companyInternetAddress='" + companyInternetAddress + '\'' +
                ", bgsound='" + bgsound + '\'' +
                ", companyBusiness='" + companyBusiness + '\'' +
                ", companySupply='" + companySupply + '\'' +
                ", companyDemand='" + companyDemand + '\'' +
                ", companyMapPlace='" + companyMapPlace + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankUserName='" + bankUserName + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", accountStatus='" + accountStatus + '\'' +
                '}';
    }
}
