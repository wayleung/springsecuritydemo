package com.way.springsecuritydemo.service.impl;

import com.way.springsecuritydemo.dao.entity.User;
import com.way.springsecuritydemo.dao.mapper.UserMapper;
import com.way.springsecuritydemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Way Liang
 * @Date: 11/13/2018 23:16
 * @Description:
 */
@Service
public class UserService implements IUserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public Integer insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public Integer deleteById(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public Integer updateById(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public Integer updateSelective(User user) {
        return userMapper.updateSelective(user);
    }

    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> selectByConditions(User user) {
        return userMapper.selectByConditions(user);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }
}
