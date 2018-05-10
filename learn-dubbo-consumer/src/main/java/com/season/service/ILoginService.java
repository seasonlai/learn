package com.season.service;

import com.season.domain.Role;
import com.season.domain.User;

import java.util.Map;

/**
 * Created by Administrator on 2018/5/9.
 */
public interface ILoginService {
    //添加用户
    User addUser(Map<String, Object> map);

    //添加角色
    Role addRole(Map<String, Object> map);

    //查询用户通过用户名
    User findByName(String name);
}
