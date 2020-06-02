import com.lagou.MyApplication;
import com.lagou.service.MailTemplateService;
import com.lagou.vo.MailInfoVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @Author: lihaonan
 * @Date: 2020/5/21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyApplication.class)
public class TestClass {

    @Resource
    private MailTemplateService mailTemplateService;

    @Test
    public void test() {
        MailInfoVo mailInfoVo = new MailInfoVo();
        mailInfoVo.setHtmlContent("test");
        mailInfoVo.setTitle("temp");
        mailInfoVo.setToUsers(new String[]{"847198028@qq.com"});
        mailTemplateService.sendMailByHtml(mailInfoVo);
    }

}
