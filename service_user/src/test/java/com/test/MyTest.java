package com.test;



import com.lagou.MyApplication;
import com.lagou.entity.LagouAuthCode;
import com.lagou.service.LagouAuthCodeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


/**
 * @Author: lihaonan
 * @Date: 2020/5/25
 */
@SpringJUnitConfig(classes = MyApplication.class)
@RunWith(value = SpringJUnit4ClassRunner.class)
public class MyTest {

    @Resource
    private LagouAuthCodeService lagouAuthCodeService;

    @Test
    public void test() {
        LagouAuthCode lagouAuthCode = lagouAuthCodeService.queryById(1);
        System.out.println(lagouAuthCode);
    }


}
