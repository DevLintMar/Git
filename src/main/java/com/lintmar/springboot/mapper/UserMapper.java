package com.lintmar.springboot.mapper;

import com.lintmar.springboot.bean.AuthUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author LintMar
 * @date 2022/7/16
 **/
@Mapper
public interface UserMapper {
    @Select("select username, password, roles from auth_user")
    List<AuthUser> getAll();

    @Select("select username, password, roles from auth_user where username = #{username}")
    AuthUser getUser(String username);

    @Insert("insert into auth_user values (#{username}, #{password}, #{roles})")
    int addUser(AuthUser authUser);

    @Delete("delete from auth_user where username = #{username}")
    int deleteUser(String username);
}
