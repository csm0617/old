package com.csm.service;

import com.csm.pojo.User;
import com.csm.pojo.query.UserQuery;
import com.github.pagehelper.PageInfo;
import java.util.List;

/**
 * @Author 快乐小柴
 * @Date 2022/10/14 20:12
 * @Version 1.0
 */
public interface UserService {
    //查询所有的用户
    public List<User> listUser();
    //根据用户名来查询用户，并分页展示
    public PageInfo<User> listUserByName(UserQuery userQuery);
}
