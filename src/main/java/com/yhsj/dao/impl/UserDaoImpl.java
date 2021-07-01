package com.yhsj.dao.impl;

import com.yhsj.dao.UserDao;

public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
        System.out.println("UserDaoImpl创建了");
    }

    public UserDaoImpl(int a) {
        System.out.println("UserDaoImpl创建了");
    }
    @Override
    public void getUserInfo() {
        System.out.println("调用默认的方式获取数据");
    }

    public void init() {
        System.out.println("对象创建了");
    }

    public void destroy() {
        System.out.println("对象销毁了");
    }
}
