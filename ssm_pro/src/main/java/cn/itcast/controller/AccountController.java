package cn.itcast.controller;

import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resources;

/**
 * @author 李仔文
 * @version 1.0.0
 * @ClassName AccountController.java
 * @Description TODO
 * @createTime 2020年08月02日 09:53:00
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层：查询所有账户。。。");
        accountService.findAll(model);
        return "list";
    }
}
