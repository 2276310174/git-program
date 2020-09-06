package cn.itcast.service;

import cn.itcast.domain.Account;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

/**
 * @author 李仔文
 * @version 1.0.0
 * @ClassName AccountService.java
 * @Description TODO
 * @createTime 2020年08月02日 09:40:00
 */

public interface AccountService {

    //保存账户信息
    public void saveAccount(Account account);

    //查询所有账户信息
    public List<Account> findAll(Model model);
}
