package com.gxy;

import com.gxy.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*MyBatis快速入门*/
public class MyBatisDemo {
    public static void main(String[] args) throws IOException {
        // 1. 加载mybatis核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取SqlSesiion对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 执行sql
        List<User> users = sqlSession.selectList("com.gxy.mapper.UserMapper.selectAll");
        System.out.println(users);

        // 4.释放资源
        sqlSession.close();
    }
}
