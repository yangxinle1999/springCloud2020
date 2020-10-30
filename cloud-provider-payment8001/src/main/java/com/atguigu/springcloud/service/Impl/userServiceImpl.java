package com.atguigu.springcloud.service.Impl;


import com.atguigu.springcloud.dao.userDao;
import com.atguigu.springcloud.entity.user;
import com.atguigu.springcloud.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements userService {

    @Autowired
    private userDao userDao;

    @Override
    public int create(user user) {
        return userDao.create(user);
    }

    @Override
    public user getUserById(Integer id) {
        return userDao.getUserById(id);
    }
}
