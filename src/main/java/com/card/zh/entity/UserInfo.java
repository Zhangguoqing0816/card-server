package com.card.zh.entity;

import com.baomidou.mybatisplus.annotations.TableField;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private String id;
    /**
     * 用户名称
     */
    @TableField("user_name")
    private String userName;
    /**
     * 用户昵称
     */
    @TableField("nick_name")
    private String nickName;

    private String sex;

    private String phone;

    private String account;

    private String password;
    /**
     * 账号状态
     */
    @TableField("account_status")
    private String accountStatus;

    private String email;
    /**
     * 头像url
     */
    @TableField("head_sculpture")
    private String headSculpture;
    /**
     * QQ号码
     */
    @TableField("qq_number")
    private String qqNumber;
    /**
     * 微信号码
     */
    @TableField("wechat_number")
    private String wechatNumber;

    /**
     * 微信号码
     */
    @TableField("wechat_number")
    private byte[] qqQrCode;
    /**
     * 微信二维码
     */
    @TableField("wechat_qr_code")
    private byte[] wechatQrCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus == null ? null : accountStatus.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getHeadSculpture() {
        return headSculpture;
    }

    public void setHeadSculpture(String headSculpture) {
        this.headSculpture = headSculpture == null ? null : headSculpture.trim();
    }

    public String getQqNumber() {
        return qqNumber;
    }

    public void setQqNumber(String qqNumber) {
        this.qqNumber = qqNumber == null ? null : qqNumber.trim();
    }

    public String getWechatNumber() {
        return wechatNumber;
    }

    public void setWechatNumber(String wechatNumber) {
        this.wechatNumber = wechatNumber == null ? null : wechatNumber.trim();
    }

    public byte[] getQqQrCode() {
        return qqQrCode;
    }

    public void setQqQrCode(byte[] qqQrCode) {
        this.qqQrCode = qqQrCode;
    }

    public byte[] getWechatQrCode() {
        return wechatQrCode;
    }

    public void setWechatQrCode(byte[] wechatQrCode) {
        this.wechatQrCode = wechatQrCode;
    }
}