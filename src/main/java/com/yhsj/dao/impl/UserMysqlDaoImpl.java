package com.yhsj.dao.impl;

import com.yhsj.dao.UserMysqlDao;

public class UserMysqlDaoImpl implements UserMysqlDao {
    @Override
    public void getUserInfo() {
        System.out.println("mysql的方式获取数据");
    }
}
