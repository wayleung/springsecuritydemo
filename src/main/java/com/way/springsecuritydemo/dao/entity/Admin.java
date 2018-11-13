package com.way.springsecuritydemo.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: Way Liang
 * @Date: 11/11/2018 18:25
 * @Description:
 */
@Getter
@Setter
@ToString
public class Admin {
    private Integer id;

    private String account;

    private String password;

    private String name;

    private String gender;

    private String birthdate;

    private String role;

    private String authority;
}
