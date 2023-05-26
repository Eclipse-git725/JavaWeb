package com.gxy;

import com.gxy.mapper.UserMapper;
import com.gxy.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*MyBatis代理开发*/
public class MyBatisDemo2 {
    public static void main(String[] args) throws IOException {
        // 1. 加载mybatis核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取SqlSesiion对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 执行sql
        //List<User> users = sqlSession.selectList("test.selectAll");
        // 3.1 获取UserMapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();
        System.out.println(users);

        // 4.释放资源
        sqlSession.close();
    }
}
