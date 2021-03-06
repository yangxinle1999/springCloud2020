package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.user;
import com.atguigu.springcloud.service.userService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@Slf4j
public class userController {

    @Autowired
    private userService userService;

    @Value("${server.port}")
    private String port;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/user/create")
    public CommonResult create(@RequestBody user user){
        int i = userService.create(user);
        log.info("插入结果是"+i);
        if (i>0){
            return new CommonResult(200,"插入数据成功"+port,i);
        }else {
            return new CommonResult(444,"插入数据失败",null);
        }
    }

    @GetMapping("/user/getUserById/{id}")
    public CommonResult getUserById(@PathVariable("id")int id){
        user user = userService.getUserById(id);
        log.info("查询结果是"+user);
        if (user!=null){
            return new CommonResult(200,"查询数据成功"+port,user);
        }else {
            return new CommonResult(444,"查询数据失败",null);
        }
    }


    //服务发现
    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();//获取所有的服务接口名
        for (String service : services){
            System.out.println("element"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance : instances){  //获取每个服务接口下面的实例信息
            System.out.println(serviceInstance.getHost()+"/"+serviceInstance.getPort());
        }
        return this.discoveryClient;
    }
}
