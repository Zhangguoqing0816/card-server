package com.card.zh.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Auther:
 * @Description:
 * @Date: 2019/10/17 15:22
 */
@Data
public class ProductDescriptionRequest {

    /**
     * 用户表id
     */
    @ApiModelProperty("用户保存数据后返回的ID")
    private String userInfoId;
    /**
     * 产品名称
     */
    @ApiModelProperty("产品名称")
    private String proName;
    /**
     * 价格
     */
    @ApiModelProperty("价格")
    private String proPrice;
    /**
     * 序号
     */
    @ApiModelProperty("序号")
    private String proSort;
    /**
     * 订单类型：在线订购/在线咨询
     */
    @ApiModelProperty("订单类型：在线订购/在线咨询")
    private String proOrderType;
    /**
     * 产品主图ID
     */
    @ApiModelProperty("产品图ID")
    private List<String> imgIdList;
    /**
     * 产品详情
     */
    @ApiModelProperty("产品详情")
    private String proContent;
}
