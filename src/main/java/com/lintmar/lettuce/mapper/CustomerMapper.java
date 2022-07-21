package com.lintmar.lettuce.mapper;

import com.lintmar.lettuce.bean.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author LintMar
 * @date 2022/7/21
 **/

@Mapper
public interface CustomerMapper {
    List<Customer> getAll();
}
