package com.yhsj.factory;

import com.yhsj.dao.UserDao;
import com.yhsj.dao.impl.UserDaoImpl;

public class DynamicBeanFactory {
    public  UserDao createUserDao() {
        return new UserDaoImpl();
    }
}
