package com.lagou;

import com.lagou.dubbo.api.MailService;
import com.lagou.entity.LagouAuthCode;
import com.lagou.service.LagouAuthCodeService;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @Author: lihaonan
 * @Date: 2020/6/3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyApplication.class)
public class MyTest {

    @Reference
    private MailService mailService;

    @Resource
    private LagouAuthCodeService lagouAuthCodeService;

    @Test
    public void test() {
//        System.out.println(mailService.sendMail("123","847198028@qq.com"));
        System.out.println(lagouAuthCodeService.queryAll(new LagouAuthCode() {{
            setEmail("847198028@qq.com");
        }}));
    }

}
