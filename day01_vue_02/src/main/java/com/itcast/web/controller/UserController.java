package com.itcast.web.controller;

import com.itcast.domain.User;
import com.itcast.service.IuserMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 李仔文
 * @version 1.0.0
 * @ClassName UserController.java
 * @Description TODO
 * @createTime 2020年09月05日 11:26:00
 */
@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IuserMapperService userService;

    @RequestMapping("/selectAll")
    public List<User> selectAll(){
        List<User> users = userService.selectAll();
        return  users;
    }

    @RequestMapping("/selectById")
    public User selectById(Integer id){
        User user = userService.selectById(id);
        return  user;
    }

    @RequestMapping("/updateUser")
    public void updateUser(User user){
        userService.updateUser(user);
    }
}
