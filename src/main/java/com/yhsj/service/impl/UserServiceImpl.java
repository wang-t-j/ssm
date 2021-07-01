package com.yhsj.service.impl;

import com.yhsj.dao.UserDao;

import com.yhsj.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao ;
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUserInfo() {
        userDao.getUserInfo();
    }
}
