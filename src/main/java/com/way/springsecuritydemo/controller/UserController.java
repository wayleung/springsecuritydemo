package com.way.springsecuritydemo.controller;

import com.way.springsecuritydemo.constant.Code;
import com.way.springsecuritydemo.controller.vo.Result;
import com.way.springsecuritydemo.dao.entity.User;
import com.way.springsecuritydemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: Way Liang
 * @Date: 11/13/2018 23:22
 * @Description:
 */
@RestController
//@CrossOrigin
@RequestMapping("/test/user")
public class UserController {

    @Autowired
    IUserService userService;



    @PostMapping("/user")
    public Result<Integer> insert(@RequestBody User user){
        Integer changeRows = userService.insert(user);
        return new Result<Integer>(Code.SUCCESS.getCode(),true,Code.SUCCESS.getMessage(),changeRows);
    }

    @DeleteMapping("/user")
    public Result<Integer> deleteById(@PathVariable(value = "id") Integer id){
        Integer changeRows = userService.deleteById(id);
        return new Result<Integer>(Code.SUCCESS.getCode(),true,Code.SUCCESS.getMessage(),changeRows);
    }

    @PutMapping("/user")
    public Result<Integer> updateById(@RequestBody User user){
        Integer changeRows = userService.updateById(user);
        return new Result<Integer>(Code.SUCCESS.getCode(),true,Code.SUCCESS.getMessage(),changeRows);
    }

    @PutMapping("/user/selective")
    public Result<Integer> updateSelective(@RequestBody User user){
        Integer changeRows = userService.updateSelective(user);
        return new Result<Integer>(Code.SUCCESS.getCode(),true,Code.SUCCESS.getMessage(),changeRows);
    }

    @GetMapping("/user/{id}")
//    public Result<User> selectById(@RequestBody UserSelectByIdParam selectByIdParam){
    public Result<User> selectById(@PathVariable(value = "id") Integer id){
        User user = userService.selectById(id);
        return new Result<User>(Code.SUCCESS.getCode(),true,Code.SUCCESS.getMessage(),user);
    }

    @PostMapping("/user/condition")
    public Result<List<User>> selectByConditions(@RequestBody User user){
        List<User> users = userService.selectByConditions(user);
        return new Result<List<User>>(Code.SUCCESS.getCode(),true,Code.SUCCESS.getMessage(),users);
    }

    @GetMapping("/user")
    public Result<List<User>> selectAll(){
        List<User> users = userService.selectAll();
        return new Result<List<User>>(Code.SUCCESS.getCode(),true,Code.SUCCESS.getMessage(),users);
    }
}
