package com.card.zh.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author zhanggq
 * @since 2019-10-17
 */
@TableName("product_description")
public class ProductDescription implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 产品说明表
     */
    private String id;
    /**
     * 用户表id
     */
    @TableField("user_info_id")
    private String userInfoId;
    /**
     * 产品名称
     */
    @TableField("pro_name")
    private String proName;
    /**
     * 价格
     */
    @TableField("pro_price")
    private String proPrice;
    /**
     * 序号
     */
    @TableField("pro_sort")
    private String proSort;
    /**
     * 订单类型：在线订购/在线咨询
     */
    @TableField("pro_order_type")
    private String proOrderType;
    /**
     * 产品主图ID
     */
    @TableField("pro_img")
    private String proImg;
    /**
     * 产品详情
     */
    @TableField("pro_content")
    private String proContent;


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

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProPrice() {
        return proPrice;
    }

    public void setProPrice(String proPrice) {
        this.proPrice = proPrice;
    }

    public String getProSort() {
        return proSort;
    }

    public void setProSort(String proSort) {
        this.proSort = proSort;
    }

    public String getProOrderType() {
        return proOrderType;
    }

    public void setProOrderType(String proOrderType) {
        this.proOrderType = proOrderType;
    }

    public String getProImg() {
        return proImg;
    }

    public void setProImg(String proImg) {
        this.proImg = proImg;
    }

    public String getProContent() {
        return proContent;
    }

    public void setProContent(String proContent) {
        this.proContent = proContent;
    }

    @Override
    public String toString() {
        return "ProductDescription{" +
                ", id=" + id +
                ", userInfoId=" + userInfoId +
                ", proName=" + proName +
                ", proPrice=" + proPrice +
                ", proSort=" + proSort +
                ", proOrderType=" + proOrderType +
                ", proImg=" + proImg +
                ", proContent=" + proContent +
                "}";
    }
}
