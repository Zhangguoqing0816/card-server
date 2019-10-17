package com.card.zh.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther:
 * @Description:
 * @Date: 2019/10/17 15:08
 */
@Data
public class IntroduceRequest {
    /**
     * 用户保存数据后返回的ID
     */
    @ApiModelProperty("用户保存数据后返回的ID")
    private String userInfoId;
    /**
     * 标题
     */
    @ApiModelProperty("标题")
    private String title;
    /**
     * 内容
     */
    @ApiModelProperty("内容")
    private String content;
}
