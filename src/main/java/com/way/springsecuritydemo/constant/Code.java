package com.way.springsecuritydemo.constant;

import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: Way Liang
 * @Date: 11/13/2018 23:48
 * @Description:
 */
@Getter
//@Setter
public enum  Code {


    SUCCESS("S0001","成功！"),
    FAIL("F0001","失败！"),
    ERROR("E0001","出错!"),
    ACCOUNTNOTEXIST("F0002","用户不存在"),
    PASSWORDWRONG("F0003","密码不正确"),
    ACCOUNTNOTEXISTORPASSWORDWRONG("F0002","用户不存在或密码不正确"),

    ;

    private String code;
    private String message;

    Code(String code, String message) {
        this.code = code;
        this.message = message;
    }

    //public static final String SUCCESS  = "A0001";
//public static final String FAIL  = "F0001";
//public static final String ERROR  = "E0001";
}
