package com.lagou.controller;

import com.lagou.common.RetResult;
import com.lagou.dubbo.api.MailService;
import com.lagou.entity.LagouAuthCode;
import com.lagou.service.LagouAuthCodeService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.SecureRandom;
import java.util.List;

/**
 * @Author: lihaonan
 * @Date: 2020/5/21
 */
@RestController
@RequestMapping("/api/code")
public class AuthController {

    @Reference
    private MailService mailService;

    @Resource
    private LagouAuthCodeService lagouAuthCodeService;

    private static SecureRandom secureRandom = new SecureRandom();

    @RequestMapping("/getCheckCode/{email}")
    public RetResult getCheckCode(@PathVariable String email) {
        if (email == null || "".equals(email)) {
            return new RetResult<>(-1);
        }
        List<LagouAuthCode> lagouAuthCodes = lagouAuthCodeService.queryAll(new LagouAuthCode() {{
            setEmail(email);
        }});
        if (lagouAuthCodes != null && lagouAuthCodes.size() == 1) {
            LagouAuthCode lagouAuthCode = lagouAuthCodes.get(0);
            long date = lagouAuthCode.getExpiretime();
            long currentTimeMillis = System.currentTimeMillis();
            long l = currentTimeMillis - date;
            //判断验证码超时时间 10分钟
            if (l <= 10 * 60 * 1000) {
                mailService.sendMail(lagouAuthCode.getCode(), email);
                return RetResult.SUCCESS;
            } else {
                //取旧验证码
                String code = getCode();
                lagouAuthCode.setCode(code);
                lagouAuthCode.setExpiretime(currentTimeMillis);
                lagouAuthCodeService.update(lagouAuthCode);
                mailService.sendMail(code, email);
                return RetResult.SUCCESS;
            }
        }
        String code = getCode();
        lagouAuthCodeService.insert(new LagouAuthCode() {{
            setEmail(email);
            setCode(code);
            setCreatetime(System.currentTimeMillis());
            setExpiretime(System.currentTimeMillis());
        }});
        mailService.sendMail(code, email);
        return RetResult.SUCCESS;
    }

    private String getCode() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(secureRandom.nextInt(10));
        }
        return stringBuilder.toString();
    }

}
