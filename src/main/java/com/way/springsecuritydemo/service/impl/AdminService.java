package com.way.springsecuritydemo.service.impl;

import com.way.springsecuritydemo.dao.entity.Admin;
import com.way.springsecuritydemo.dao.mapper.AdminMapper;
import com.way.springsecuritydemo.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Way Liang
 * @Date: 11/13/2018 23:16
 * @Description:
 */
@Service
public class AdminService implements IAdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public Integer insert(Admin admin) {
        return adminMapper.insert(admin);
    }

    @Override
    public Integer deleteById(Integer id) {
        return adminMapper.deleteById(id);
    }

    @Override
    public Integer updateById(Admin admin) {
        return adminMapper.updateById(admin);
    }

    @Override
    public Integer updateSelective(Admin admin) {
        return adminMapper.updateSelective(admin);
    }

    @Override
    public Admin selectById(Integer id) {
        return adminMapper.selectById(id);
    }

    @Override
    public Admin selectByAccount(String account) {
        return adminMapper.selectByAccount(account);
    }

    @Override
    public List<Admin> selectByConditions(Admin admin) {
        return adminMapper.selectByConditions(admin);
    }

    @Override
    public List<Admin> selectAll() {
        return adminMapper.selectAll();
    }
}
