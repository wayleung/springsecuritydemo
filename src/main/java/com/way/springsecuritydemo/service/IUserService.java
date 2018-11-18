package com.way.springsecuritydemo.service;

import com.way.springsecuritydemo.dao.entity.User;

import java.util.List;

/**
 * @Auther: Way Liang
 * @Date: 11/13/2018 23:09
 * @Description:
 */
public interface IUserService {
    Integer insert(User user);



    Integer deleteById( Integer id);

    Integer updateById(User user);

    Integer updateSelective(User user);

    User selectById(Integer id);

    User selectByAccount(String account);

    List<User> selectByConditions(User user);

    List<User> selectAll();
}
