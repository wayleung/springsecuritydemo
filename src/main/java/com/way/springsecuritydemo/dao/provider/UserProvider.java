package com.way.springsecuritydemo.dao.provider;

import com.way.springsecuritydemo.dao.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;

/**
 * @Auther: Way Liang
 * @Date: 11/13/2018 17:06
 * @Description:
 */
@Component
public class UserProvider{

    public final String TABLE_NAME = "user";
    public final String COLUMNS = "";

    public String updateSelective(User user){
        return new SQL(){
            {
                UPDATE(TABLE_NAME);
                if(StringUtils.isNotBlank(user.getAccount())){
                    SET("account=#{account}");
                }
                if(StringUtils.isNotBlank(user.getAuthority())){
                    SET("authority=#{authority}");
                }
                if(StringUtils.isNotBlank(user.getBirthdate())){
                    SET("birthdate=#{birthdate}");
                }
                if(StringUtils.isNotBlank(user.getGender())){
                    SET("gender=#{gender}");
                }
                if(StringUtils.isNotBlank(user.getName())){
                    SET("name=#{name}");
                }
                if(StringUtils.isNotBlank(user.getPassword())){
                    SET("password=#{password}");
                }
                if(StringUtils.isNotBlank(user.getRole())){
                    SET("role=#{role}");
                }
                WHERE("id=#{id}");
            }
        }.toString();
    }


    public String selectByConditions(User user){
        return new SQL(){
            {
                SELECT("*");
                FROM(TABLE_NAME);
                String where = "1=1 ";

                if(user.getId()!=null){
                    where = where +"id=#{id}";
                }


                if(StringUtils.isNotBlank(user.getAccount())){
                    where = where +"account=#{account}";
                }
                if(StringUtils.isNotBlank(user.getAuthority())){
                    where = where +"authority=#{authority}";
                }
                if(StringUtils.isNotBlank(user.getBirthdate())){
                    where = where +"birthdate=#{birthdate}";
                }
                if(StringUtils.isNotBlank(user.getGender())){
                    where = where +"gender=#{gender}";
                }
                if(StringUtils.isNotBlank(user.getName())){
                    where = where +"name=#{name}";
                }
                if(StringUtils.isNotBlank(user.getPassword())){
                    where = where +"password=#{password}";
                }
                if(StringUtils.isNotBlank(user.getRole())){
                    where = where +"role=#{role}";
                }
                WHERE(where);
            }
        }.toString();
    }
}
