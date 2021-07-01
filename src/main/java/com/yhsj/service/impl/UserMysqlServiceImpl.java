package com.yhsj.service.impl;

import com.yhsj.dao.UserMysqlDao;
import com.yhsj.service.UserMysqlService;

public class UserMysqlServiceImpl implements UserMysqlService {
    private UserMysqlDao userMysqlDao;
    public UserMysqlServiceImpl(UserMysqlDao userMysqlDao){
        this.userMysqlDao = userMysqlDao;
    }
    @Override
    public void getUserInfo() {
     userMysqlDao.getUserInfo();
    }
}
