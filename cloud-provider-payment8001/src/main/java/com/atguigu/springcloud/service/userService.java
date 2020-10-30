package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.user;
import org.apache.ibatis.annotations.Param;

public interface userService {

    public int create(user user);

    public user getUserById(@Param("id") Integer id);
}
