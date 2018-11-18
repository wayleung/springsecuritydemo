package com.way.springsecuritydemo.controller;

import com.way.springsecuritydemo.constant.Code;
import com.way.springsecuritydemo.controller.vo.AdminLoginParamVo;
import com.way.springsecuritydemo.controller.vo.Result;
import com.way.springsecuritydemo.dao.entity.Admin;
import com.way.springsecuritydemo.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "AdminController")
public class AdminController {

    @Autowired
    IAdminService adminService;


    @PostMapping("/admin/login")
    @ApiOperation(value = "login")
    public Result<Admin> login(@RequestBody AdminLoginParamVo adminParamVo){
        String account = adminParamVo.getAccount();
        Admin adminFound = adminService.selectByAccount(account);
        if(adminFound==null){
            return new Result<Admin>(Code.ACCOUNTNOTEXIST.getCode(),false,Code.ACCOUNTNOTEXIST.getMessage());
        }else{
            String passwordFound = adminFound.getPassword();
            if(!passwordFound.equals(adminParamVo.getPassword())){
                return new Result<Admin>(Code.PASSWORDWRONG.getCode(),false,Code.PASSWORDWRONG.getMessage());
            }else {
                return new Result<Admin>(Code.SUCCESS.getCode(),true,Code.SUCCESS.getMessage(),adminFound);
            }
        }

    }



    @PostMapping("/admin")
    @ApiOperation(value = "insert")
    public Result<Integer> insert(@RequestBody Admin admin){
        Integer changeRows = adminService.insert(admin);
        return new Result<Integer>(Code.SUCCESS.getCode(),true,Code.SUCCESS.getMessage(),changeRows);
    }

    @DeleteMapping("/admin/{id}")
    @ApiOperation(value = "deleteById")
    public Result<Integer> deleteById(@PathVariable(value = "id") Integer id){
        Integer changeRows = adminService.deleteById(id);
        return new Result<Integer>(Code.SUCCESS.getCode(),true,Code.SUCCESS.getMessage(),changeRows);
    }

    @PutMapping("/admin")
    @ApiOperation(value = "updateById")
    public Result<Integer> updateById(@RequestBody Admin admin){
        Integer changeRows = adminService.updateById(admin);
        return new Result<Integer>(Code.SUCCESS.getCode(),true,Code.SUCCESS.getMessage(),changeRows);
    }

    @PutMapping("/admin/selective")
    @ApiOperation(value = "updateSelective")
    public Result<Integer> updateSelective(@RequestBody Admin admin){
        Integer changeRows = adminService.updateSelective(admin);
        return new Result<Integer>(Code.SUCCESS.getCode(),true,Code.SUCCESS.getMessage(),changeRows);
    }

    @GetMapping("/admin/{id}")
    @ApiOperation(value = "selectById")
//    public Result<Admin> selectById(@RequestBody AdminSelectByIdParam selectByIdParam){
    public Result<Admin> selectById(@PathVariable(value = "id") Integer id){
        Admin admin = adminService.selectById(id);
        return new Result<Admin>(Code.SUCCESS.getCode(),true,Code.SUCCESS.getMessage(),admin);
    }

    @PostMapping("/admin/condition")
    @ApiOperation(value = "selectByConditions")
    public Result<List<Admin>> selectByConditions(@RequestBody Admin admin){
        List<Admin> admins = adminService.selectByConditions(admin);
        return new Result<List<Admin>>(Code.SUCCESS.getCode(),true,Code.SUCCESS.getMessage(),admins);
    }

    @GetMapping("/admin")
    @ApiOperation(value = "selectAll")
    public Result<List<Admin>> selectAll(){
        List<Admin> admins = adminService.selectAll();
        return new Result<List<Admin>>(Code.SUCCESS.getCode(),true,Code.SUCCESS.getMessage(),admins);
    }


}
