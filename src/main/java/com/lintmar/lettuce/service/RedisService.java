package com.lintmar.lettuce.service;

import java.util.List;
import java.util.Set;

/**
 * @author LintMar
 * @date 2022/7/21
 **/
public interface RedisService {
    List<String> getList();

    Set<String> getSet();
}
