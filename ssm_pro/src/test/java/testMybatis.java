import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 李仔文
 * @version 1.0.0
 * @ClassName testMybatis.java
 * @Description TODO
 * @createTime 2020年08月02日 11:50:00
 */
public class testMybatis {
    @Test
    public void testMybatis01() throws Exception {
        InputStream in = Resources.getResourceAsStream("SqlMapConfigur.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        AccountDao accountDao = session.getMapper(AccountDao.class);
        List<Account> list = accountDao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
        session.close();
        in.close();
    }

    @Test
    public void testMybatis02() throws Exception {
        Account accounts = new Account();
        accounts.setName("唐小琳");
        accounts.setMoney(11000d);
        InputStream in = Resources.getResourceAsStream("SqlMapConfigur.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession(true);
        AccountDao accountDao = session.getMapper(AccountDao.class);
        accountDao.saveAccount(accounts);
        session.close();
        in.close();
    }
}
