package com.msb.test;

import com.msb.pojo.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 引入log4j2日志模块
 * 1、引入maven依赖
 * 2、在resources里添加配置文件log4j2.xml
 * TODO log4j2具体的配置有时间可以去自行了解一下
 */
public class UseLog4j2Test {

    private SqlSession sqlSession;

    @Before
    public void init() {
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        InputStream resource = null;
        try {
            resource = Resources.getResourceAsStream("sqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory factory = ssfb.build(resource);
        sqlSession = factory.openSession();
    }

    @Test
    public void testFindAll() {
        // 调用SQL语句
        List<Dept> list = sqlSession.selectList("findAll");
        for (Dept dept : list) {
            System.out.println(dept);
        }
    }

    @After
    public void release() {
        // 关闭SQLSession
        sqlSession.close();
    }
}
