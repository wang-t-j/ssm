package com.yhsj.factory;

import com.yhsj.dao.UserDao;
import com.yhsj.dao.impl.UserDaoImpl;

public class StaticBeanFactory {
    public static UserDao createUserDao() {
        return new UserDaoImpl();
    }
}
