package com.csm.service;

import com.csm.dao.UserDao;
import com.csm.pojo.User;
import com.csm.pojo.query.UserQuery;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 快乐小柴
 * @Date 2022/10/14 20:45
 * @Version 1.0
 */
@Service//交由spring容器进行管理
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> listUser() {
        return userDao.listUser();
    }

    @Override
    public PageInfo<User> listUserByName(UserQuery userQuery) {
        PageHelper.startPage(userQuery.getPageNumber(), userQuery.getPageSize());
        return new  PageInfo<User>(userDao.listUserByName(userQuery));
    }
}
