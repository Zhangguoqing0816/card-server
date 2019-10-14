package com.card.zh.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 用户信息内容表
 * </p>
 *
 * @author zhanggq
 * @since 2019-10-14
 */
@TableName("user_info_content")
public class UserInfoContent implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    @TableField("user_info_id")
    private String userInfoId;
    @TableField("content_url")
    private String contentUrl;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    @Override
    public String toString() {
        return "UserInfoContent{" +
                ", id=" + id +
                ", userInfoId=" + userInfoId +
                ", contentUrl=" + contentUrl +
                "}";
    }
}
