package com.card.zh.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther:
 * @Description:
 * @Date: 2019/10/17 15:01
 */
@Data
public class StyleRequest {
    @ApiModelProperty("用户保存数据后返回的ID")
    private String userInfoId;
    @ApiModelProperty("界面风格ID")
    private String styleId;
}
