package com.gxy.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class FastJsonDemo {
    public static void main(String[] args) {
        // 1. 将java对象转为json字符串
        User user = new User();
        user.setId(1);
        user.setUsername("zs");
        user.setPassword("123");

        String jsonString = JSON.toJSONString(user);
        System.out.println(jsonString);

        // 2. 将json字符串转为java对象
        User u = JSON.parseObject(jsonString, User.class);
        System.out.println(u);
    }
}
