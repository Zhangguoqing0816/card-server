package com.card.zh.entity;

import com.baomidou.mybatisplus.annotations.TableField;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author zhanggq
 * @since 2019-10-14
 */
public class Attach implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 附件表主键
     */
    private String id;
    /**
     * 附件真实名称
     */
    @TableField("attach_name")
    private String attachName;
    /**
     * 附件地址
     */
    @TableField("attach_url")
    private String attachUrl;
    /**
     * 附件类型
     */
    @TableField("attach_type")
    private String attachType;

    /**
     * 主表关联ID
     */
    @TableField("dominant_id")
    private String dominantId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAttachName() {
        return attachName;
    }

    public void setAttachName(String attachName) {
        this.attachName = attachName;
    }

    public String getAttachUrl() {
        return attachUrl;
    }

    public void setAttachUrl(String attachUrl) {
        this.attachUrl = attachUrl;
    }

    public String getAttachType() {
        return attachType;
    }

    public void setAttachType(String attachType) {
        this.attachType = attachType;
    }

    public String getDominantId() {
        return dominantId;
    }

    public void setDominantId(String dominantId) {
        this.dominantId = dominantId;
    }

    @Override
    public String toString() {
        return "Attach{" +
                "id='" + id + '\'' +
                ", attachName='" + attachName + '\'' +
                ", attachUrl='" + attachUrl + '\'' +
                ", attachType='" + attachType + '\'' +
                ", dominantId='" + dominantId + '\'' +
                '}';
    }
}
