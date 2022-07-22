package com.lintmar.springboot.mapper;

import com.lintmar.springboot.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author LintMar
 * @date 2022/7/16
 **/
@Mapper
public interface UserMapper {
    @Select("select password from auth_user where username = #{username}")
    String getPasswordByUsername(String username);

    @Insert("insert into auth_user values (#{username}, #{password})")
    int addUser(User user);
}
