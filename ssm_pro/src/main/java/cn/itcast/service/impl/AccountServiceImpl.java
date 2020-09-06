package cn.itcast.service.impl;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 李仔文
 * @version 1.0.0
 * @ClassName AccountServiceImpl.java
 * @Description TODO
 * @createTime 2020年08月02日 09:41:00
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public List<Account> findAll(Model model) {
        System.out.println("业务层：查询所有账户信息。。。。。。");
        List<Account> all = accountDao.findAll();
        model.addAttribute("list",all);
        return all;
    }

    public void saveAccount(Account account) {
        System.out.println("保存账户信息。。。。。。");
    }
}
