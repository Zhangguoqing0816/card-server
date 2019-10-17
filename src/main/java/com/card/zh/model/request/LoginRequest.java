package com.card.zh.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther:
 * @Description:
 * @Date: 2019/10/11 12:54
 */
@Data
public class LoginRequest {
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("登陆密码")
    private String password;
    @ApiModelProperty("验证码")
    private String authCode;
    @ApiModelProperty("新密码-修改密码使用")
    private String newPassword;

}
