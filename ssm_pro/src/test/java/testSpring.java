import cn.itcast.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;

import javax.jws.WebParam;

/**
 * @author 李仔文
 * @version 1.0.0
 * @ClassName testSpring.java
 * @Description TODO
 * @createTime 2020年08月02日 10:00:00
 */
public class testSpring {
    @Test
    public void test01(Model model){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        AccountService service = (AccountService) context.getBean("accountService");
        service.findAll(model);
    }
}
