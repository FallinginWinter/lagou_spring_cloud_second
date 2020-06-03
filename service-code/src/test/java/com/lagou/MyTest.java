package com.lagou;

import com.lagou.dubbo.api.MailService;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: lihaonan
 * @Date: 2020/6/3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyApplication.class)
public class MyTest {

    @Reference
    private MailService mailService;

    @Test
    public void test() {
        System.out.println(mailService.sendMail("123","847198028@qq.com"));
    }

}
