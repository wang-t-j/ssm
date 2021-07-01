package com.yhsj.test;

import com.yhsj.dao.UserDao;
import com.yhsj.dao.UserMysqlDao;
import com.yhsj.dao.impl.UserDaoImpl;
import com.yhsj.dao.impl.UserMysqlDaoImpl;
import com.yhsj.factory.BeanFactory;

import com.yhsj.service.impl.UserMysqlServiceImpl;

import com.yhsj.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {


    @Test
    public void testFactroyBean() {

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = classPathXmlApplicationContext.getBean(UserDao.class);
        userDao.getUserInfo();
    }

    @Test
    public void testScope() {

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = classPathXmlApplicationContext.getBean(UserDao.class);
        UserDao userDao2 = classPathXmlApplicationContext.getBean(UserDao.class);

        System.out.println(userDao1);
        System.out.println(userDao2);

        classPathXmlApplicationContext.close();
    }

    @Test
    public void testIoC() {
       /* UserDao userDao = new UserDaoImpl();*/
        UserDaoImpl userDao = (UserDaoImpl) BeanFactory.getBean("userDaoImpl");
        UserServiceImpl userService = new UserServiceImpl(userDao);
        userService.getUserInfo();

        UserMysqlDaoImpl userMysqlDaoImpl = (UserMysqlDaoImpl) BeanFactory.getBean("userMysqlDaoImpl");
        UserMysqlServiceImpl userMysqlService = new UserMysqlServiceImpl(userMysqlDaoImpl);
        userMysqlService.getUserInfo();

    }

    @Test
    public void testQuick() {
        // 读取applicationContext.xml配置文件
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取UserDao

        /*这种方式需要强转，每次获取bean都要手动强转
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        */

        /*
              第二种:getBean(Class<T> requiredType)
              通过指定类型获取对象的实例，不需要强转
              注意：如果同一个接口类型下有多个对象实例，会报错的
        UserDao userDao = applicationContext.getBean(UserDao.class);
        */

        /*
            第三种：getBean(String name, Class<T> requiredType);
        */
        UserMysqlDao userMysqlDao = applicationContext.getBean("userMysqlDao", UserMysqlDao.class);
        // 调用方法
        userMysqlDao.getUserInfo();
    }
}
