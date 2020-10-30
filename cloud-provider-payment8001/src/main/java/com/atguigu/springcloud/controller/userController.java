package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.user;
import com.atguigu.springcloud.service.userService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class userController {

    @Autowired
    private userService userService;

    @GetMapping("/user/create")
    public CommonResult create(@RequestBody user user){
        int i = userService.create(user);
        log.info("插入结果是"+i);
        if (i>0){
            return new CommonResult(200,"插入数据成功",i);
        }else {
            return new CommonResult(444,"插入数据失败",null);
        }
    }

    @GetMapping("/user/getUserById/{id}")
    public CommonResult getUserById(@PathVariable("id")int id){
        user user = userService.getUserById(id);
        log.info("查询结果是"+user);
        if (user!=null){
            return new CommonResult(200,"查询数据成功",user);
        }else {
            return new CommonResult(444,"查询数据失败",null);
        }
    }
}
