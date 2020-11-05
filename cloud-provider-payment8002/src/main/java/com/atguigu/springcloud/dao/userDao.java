package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entity.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
@Mapper //@Repository需要在Spring中配置扫描地址，然后生成Dao层的Bean才能被注入到Service层中。
//@Mapper不需要配置扫描地址，通过xml里面的namespace里面的接口地址，生成了Bean后注入到Service层中。
public interface userDao {

    public int create(user user);

    public user getUserById(@Param("id") Integer id);

}
