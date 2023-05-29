package com.gxy.mapper;

import com.gxy.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    // 根据用户名和密码查询对象
    @Select("select * from tb_account where username = #{username} and password = #{password}")
    User select(@Param("username") String username, @Param("password") String password);

    // 根据用户名查询对象
    @Select("select * from tb_account where username = #{username}")
    User selectByUsername(String username);

    @Insert("insert into tb_account values (null, #{username}, #{password})")
    void add(User user);

}
