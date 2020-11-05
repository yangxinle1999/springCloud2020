package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    private static final String path = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/create")
    public CommonResult create(user user){
        return restTemplate.postForObject(path+"/user/create",user,CommonResult.class);
    }

    @GetMapping("/consumer/getUserById/{id}")
    public CommonResult getUserById(@PathVariable("id") int id){
        return restTemplate.getForObject(path+"/user/getUserById/"+id,CommonResult.class);

    }


}
