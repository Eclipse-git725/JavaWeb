package com.gxy.service;

import com.gxy.mapper.UserMapper;
import com.gxy.pojo.User;
import com.gxy.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    // 登录方法
    public User login(String username, String password){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.select(username, password);
        sqlSession.close();
        return user;
    }

    // 注册方法
    public Boolean register(User user){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 用户名是否存在
        User u = mapper.selectByUsername(user.getUsername());
        if(u == null){
            mapper.add(user);
            sqlSession.commit();
        }
        sqlSession.close();
        return u==null;
    }
}
