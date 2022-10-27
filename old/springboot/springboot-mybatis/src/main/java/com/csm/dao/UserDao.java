package com.csm.dao;

import com.csm.pojo.User;
import com.csm.pojo.query.UserQuery;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @Author 快乐小柴
 * @Date 2022/10/14 16:20
 * @Version 1.0
 */
@Mapper//告诉springboot这是一个mybatis的mapper类
@Repository//将userDao交给spring容器进行管理
public interface UserDao {
    //查询所有的用户
    public List<User> listUser();
    //根据用户名来查询用户，并分页展示
    public List<User> listUserByName(UserQuery userQuery);

}
