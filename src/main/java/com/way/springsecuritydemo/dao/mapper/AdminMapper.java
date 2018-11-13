package com.way.springsecuritydemo.dao.mapper;

import com.way.springsecuritydemo.dao.entity.Admin;
import com.way.springsecuritydemo.dao.provider.AdminProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: Way Liang
 * @Date: 11/13/2018 16:20
 * @Description:
 */
@Mapper
@Repository
public interface AdminMapper {

    @Insert("INSERT INTO `admin`(account, password, name, gender, birthdate, `role`, authority) VALUES(#{account}, #{password}, #{name}, #{gender}, #{birthdate}, #{role}, #{authority});")
    Integer insert(Admin admin);



    @Delete("DELETE FROM `admin` WHERE id=#{id};")
    Integer deleteById(@Param(value = "id") Integer id);

    @Update("UPDATE `admin` SET password=#{password}, name=#{name}, gender=#{gender}, birthdate=#{birthdate}, `role`=#{role}, authority=#{authority} WHERE id=#{id};")
    Integer updateById(Admin admin);

    @InsertProvider(type = AdminProvider.class,method = "updateSelective")
    Integer updateSelective(Admin admin);

    @Select("SELECT * FROM `admin` WHERE id =#{id};")
    Admin selectById(Integer id);

    @SelectProvider(type = AdminProvider.class,method = "selectByConditions")
    List<Admin> selectByConditions(Admin admin);

    @Select("SELECT * FROM `admin`")
    List<Admin> selectAll();



}
