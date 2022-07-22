package com.lintmar.springboot.mapper;

import com.lintmar.springboot.bean.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LintMar
 * @date 2022/7/16
 **/
@Mapper
public interface CustomerMapper {
    @Select("select id, name, age from customer")
    List<Customer> getAll();
}
