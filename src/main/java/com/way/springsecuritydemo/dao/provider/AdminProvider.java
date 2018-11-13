package com.way.springsecuritydemo.dao.provider;

import com.way.springsecuritydemo.dao.entity.Admin;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;

/**
 * @Auther: Way Liang
 * @Date: 11/13/2018 17:06
 * @Description:
 */
@Component
public class AdminProvider {

    public final String TABLE_NAME = "admin";
    public final String COLUMNS = "";

    public String updateSelective(Admin admin){
        return new SQL(){
            {
                UPDATE(TABLE_NAME);
                if(StringUtils.isNotBlank(admin.getAccount())){
                    SET("account=#{account}");
                }
                if(StringUtils.isNotBlank(admin.getAuthority())){
                    SET("authority=#{authority}");
                }
                if(StringUtils.isNotBlank(admin.getBirthdate())){
                    SET("birthdate=#{birthdate}");
                }
                if(StringUtils.isNotBlank(admin.getGender())){
                    SET("gender=#{gender}");
                }
                if(StringUtils.isNotBlank(admin.getName())){
                    SET("name=#{name}");
                }
                if(StringUtils.isNotBlank(admin.getPassword())){
                    SET("password=#{password}");
                }
                if(StringUtils.isNotBlank(admin.getRole())){
                    SET("role=#{role}");
                }
                WHERE("id=#{id}");
            }
        }.toString();
    }


    public String selectByConditions(Admin admin){
        return new SQL(){
            {
                SELECT("*");
                FROM(TABLE_NAME);
                String where = "1=1 ";

                if(admin.getId()!=null){
                    where = where +"id=#{id}";
                }

                if(StringUtils.isNotBlank(admin.getAccount())){
                    where = where +"account=#{account}";
                }
                if(StringUtils.isNotBlank(admin.getAuthority())){
                    where = where +"authority=#{authority}";
                }
                if(StringUtils.isNotBlank(admin.getBirthdate())){
                    where = where +"birthdate=#{birthdate}";
                }
                if(StringUtils.isNotBlank(admin.getGender())){
                    where = where +"gender=#{gender}";
                }
                if(StringUtils.isNotBlank(admin.getName())){
                    where = where +"name=#{name}";
                }
                if(StringUtils.isNotBlank(admin.getPassword())){
                    where = where +"password=#{password}";
                }
                if(StringUtils.isNotBlank(admin.getRole())){
                    where = where +"role=#{role}";
                }
                WHERE(where);
            }
        }.toString();
    }
}
