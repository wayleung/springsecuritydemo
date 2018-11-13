package com.way.springsecuritydemo.controller;

import com.way.springsecuritydemo.constant.Code;
import com.way.springsecuritydemo.controller.vo.Result;
import com.way.springsecuritydemo.dao.entity.Admin;
import com.way.springsecuritydemo.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: Way Liang
 * @Date: 11/13/2018 23:23
 * @Description:
 */
@RestController
//@CrossOrigin
@RequestMapping("/test/admin")
public class AdminController {

    @Autowired
    IAdminService adminService;



    @PostMapping("/admin")
    public Result<Integer> insert(@RequestBody Admin admin){
        Integer changeRows = adminService.insert(admin);
        return new Result<Integer>(Code.SUCCESS.getCode(),true,Code.SUCCESS.getMessage(),changeRows);
    }

    @DeleteMapping("/admin/{id}")
    public Result<Integer> deleteById(@PathVariable(value = "id") Integer id){
        Integer changeRows = adminService.deleteById(id);
        return new Result<Integer>(Code.SUCCESS.getCode(),true,Code.SUCCESS.getMessage(),changeRows);
    }

    @PutMapping("/admin")
    public Result<Integer> updateById(@RequestBody Admin admin){
        Integer changeRows = adminService.updateById(admin);
        return new Result<Integer>(Code.SUCCESS.getCode(),true,Code.SUCCESS.getMessage(),changeRows);
    }

    @PutMapping("/admin/selective")
    public Result<Integer> updateSelective(@RequestBody Admin admin){
        Integer changeRows = adminService.updateSelective(admin);
        return new Result<Integer>(Code.SUCCESS.getCode(),true,Code.SUCCESS.getMessage(),changeRows);
    }

    @GetMapping("/admin/{id}")
//    public Result<Admin> selectById(@RequestBody AdminSelectByIdParam selectByIdParam){
    public Result<Admin> selectById(@PathVariable(value = "id") Integer id){
        Admin admin = adminService.selectById(id);
        return new Result<Admin>(Code.SUCCESS.getCode(),true,Code.SUCCESS.getMessage(),admin);
    }

    @PostMapping("/admin/condition")
    public Result<List<Admin>> selectByConditions(@RequestBody Admin admin){
        List<Admin> admins = adminService.selectByConditions(admin);
        return new Result<List<Admin>>(Code.SUCCESS.getCode(),true,Code.SUCCESS.getMessage(),admins);
    }

    @GetMapping("/admin")
    public Result<List<Admin>> selectAll(){
        List<Admin> admins = adminService.selectAll();
        return new Result<List<Admin>>(Code.SUCCESS.getCode(),true,Code.SUCCESS.getMessage(),admins);
    }
}