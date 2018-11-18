package com.way.springsecuritydemo.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: Way Liang
 * @Date: 11/18/2018 15:38
 * @Description:
 */
@Getter
@Setter
@ApiModel(value = "AdminLoginParamVo")
public class AdminLoginParamVo {
    @ApiModelProperty(value = "account",required = true)
    private String account;
    @ApiModelProperty(value = "password",required = true)
    private String password;
    @ApiModelProperty(value = "verificationCode",required = true)
    private String verificationCode;
}
