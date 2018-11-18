package com.way.springsecuritydemo.service;

import com.way.springsecuritydemo.dao.entity.Admin;

import java.util.List;

/**
 * @Auther: Way Liang
 * @Date: 11/13/2018 23:12
 * @Description:
 */
public interface IAdminService {

    Integer insert(Admin admin);

    Integer deleteById(Integer id);

    Integer updateById(Admin admin);

    Integer updateSelective(Admin admin);

    Admin selectById(Integer id);

    Admin selectByAccount(String account);

    List<Admin> selectByConditions(Admin admin);

    List<Admin> selectAll();
}
