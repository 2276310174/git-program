package com.itcast.test;

import com.itcast.domain.User;
import com.itcast.service.IuserMapperService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 李仔文
 * @version 1.0.0
 * @ClassName IuserMapperTest.java
 * @Description TODO
 * @createTime 2020年09月05日 10:54:00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class IuserMapperTest {
    @Autowired
    private IuserMapperService userService;

    @Test
    public void testSelectAll(){
        List<User> users = userService.selectAll();
        System.out.println(users);

    }

    @Test
    public void testSelectById(){
        User users = userService.selectById(1);
        System.out.println(users);
    }

    @Test
    public void testUpdateUser(){
        User users = userService.selectById(1);
        System.out.println(users);
        System.out.println("修改前");
        users.setAge(55);
        userService.updateUser(users);
        User user = userService.selectById(1);
        System.out.println("修改后");
        System.out.println(user);
    }
}
