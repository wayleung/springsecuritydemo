package com.way.springsecuritydemo.controller.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: Way Liang
 * @Date: 11/13/2018 23:27
 * @Description:
 */
@Getter
@Setter
@ToString
public class Result<T> {
    private String code;

    private boolean success;

    private String message;

    private T data;

    public Result(String code, boolean success, String message) {
        this.code = code;
        this.success = success;
        this.message = message;
    }

    public Result(String code, boolean success, String message, T data) {
        this.code = code;
        this.success = success;
        this.message = message;
        this.data = data;
    }
}
