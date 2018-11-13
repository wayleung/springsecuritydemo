package com.way.springsecuritydemo.dao.mapper;

import com.way.springsecuritydemo.dao.entity.User;
import com.way.springsecuritydemo.dao.provider.UserProvider;
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
public interface UserMapper {

    @Insert("INSERT INTO `user`(account, password, name, gender, birthdate, `role`, authority) VALUES(#{account}, #{password}, #{name}, #{gender}, #{birthdate}, #{role}, #{authority});")
    Integer insert(User user);



    @Delete("DELETE FROM `user` WHERE id=#{id};")
    Integer deleteById(@Param(value = "id") Integer id);

    @Update("UPDATE `user` SET password=#{password}, name=#{name}, gender=#{gender}, birthdate=#{birthdate}, `role`=#{role}, authority=#{authority} WHERE id=#{id};")
    Integer updateById(User user);

    @InsertProvider(type = UserProvider.class,method = "updateSelective")
    Integer updateSelective(User user);

    @Select("SELECT * FROM `user` WHERE id =#{id};")
    User selectById(Integer id);

    @SelectProvider(type = UserProvider.class,method = "selectByConditions")
    List<User> selectByConditions(User user);

    @Select("SELECT * FROM `user`")
    List<User> selectAll();



}
