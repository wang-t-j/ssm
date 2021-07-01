package com.yhsj.factory;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanFactory {

    // 声明存储对象的容器（map集合）
    private static Map<String, Object> ioc = new HashMap<>();

    // 静态代码块，初始化ioc容器
    static {
        String id = null;
        String className = null;
        Object object = null;
        try {
            // 1.通过类加载器读取 beans.xml
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml");
            // 2.创建dom4j核心解析器对象
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(in);
            // 3.编写xpath表达式
            String xpath = "//bean";
            // 4.获取所有的bean标签对象
            List<Element> list = document.selectNodes(xpath);
            // 5.遍历集合，创建对象实例，设置到ioc容器中
            for (Element element : list) {
                id = element.attributeValue("id");
                className = element.attributeValue("class");
                object = Class.forName(className).newInstance();
                // 设置到map集合
                ioc.put(id, object);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 从ioc容器中获取指定id的对象实例
    public static Object getBean(String id) {
        return ioc.get(id);
    }
}