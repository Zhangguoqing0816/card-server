package com.card.zh.entity;

import com.baomidou.mybatisplus.annotations.TableField;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author zhanggq
 * @since 2019-10-17
 */
public class Introduce implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 简介表
     */
    private String id;
    /**
     * 用户表ID
     */
    @TableField("user_info_id")
    private String userInfoId;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;


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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Introduce{" +
                ", id=" + id +
                ", userInfoId=" + userInfoId +
                ", title=" + title +
                ", content=" + content +
                "}";
    }
}
