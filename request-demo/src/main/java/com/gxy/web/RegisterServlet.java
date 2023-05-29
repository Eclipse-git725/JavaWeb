package com.gxy.web;

import com.gxy.mapper.UserMapper;
import com.gxy.pojo.User;
import com.gxy.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 2.调用mybatis
        // 2.1 获取SqlSessionFactory对象
        /*String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);*/
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        // 2.2 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 2.3 获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 2.4 调用方法
        User user = mapper.selectByUsername(username);


        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        // 3.判断user是否为null
        if(user != null){
            // 用户名已存在
            writer.write("用户名已存在");
        }else{
            // 调用mapper添加用户
            User user1 = new User();
            user1.setUsername(username);
            user1.setPassword(password);
            mapper.add(user1);
            // 提交事务
            sqlSession.commit();
            writer.write("添加成功");
        }

        // 释放资源
        sqlSession.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
