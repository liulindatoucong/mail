package com.liulin.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {

    private static SqlSessionFactory factory;
    static {
        String mybatisConfigUrl = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(mybatisConfigUrl);
            factory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 获取数据库session
     * @return
     */
    public static SqlSession getSession() {
        return factory.openSession();
    }

}
