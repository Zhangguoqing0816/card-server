package com.card.zh.model.session;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther:
 * @Description:
 * @Date: 2019/10/9 15:29
 */
@Data
public class SessionModel implements Serializable {

    private String userName;

    private String nickName;

    private String sex;

    private String phone;

    private String account;

    private String password;

    private String accountStatus;

    private String email;

    private String headSculpture;

    private String qqNumber;

    private String wechatNumber;

    private byte[] qqQrCode;

    private byte[] wechatQrCode;

}
