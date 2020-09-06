package cn.itcast.dao;

import cn.itcast.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.util.List;

/**
 * @author 李仔文
 * @version 1.0.0
 * @ClassName AccountDao.java
 * @Description TODO
 * @createTime 2020年08月02日 09:38:00
 */
@Repository
public interface AccountDao {

    //查询所有账户
    @Select("select * from account")
    public List<Account> findAll();

    //保存账户
    @Insert(value="insert into account (name,money) values (#{name},#{money})")
    public void saveAccount(Account account);
}
