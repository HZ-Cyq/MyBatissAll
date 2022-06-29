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
 * 测试可以使用sql语句，对存在数据库里里的对象进行增删改查
 * 1、添加myBatis和mySql依赖
 * 2、配置sqlMapConfig.xml，
 * TODO 老师的课程里只进行里查询操作，有时间可以自己添加一些其他操作
 */
public class UseSqlTest {

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