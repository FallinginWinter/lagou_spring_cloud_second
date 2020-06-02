package com.lagou.controller;

import com.lagou.entity.LagouAuthCode;
import com.lagou.entity.LagouToken;
import com.lagou.service.LagouAuthCodeService;
import com.lagou.service.LagouTokenService;
import com.lagou.service.MailService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.SecureRandom;
import java.sql.Date;
import java.util.List;

/**
 * @Author: lihaonan
 * @Date: 2020/5/21
 */
@RestController
@RequestMapping("/api/code")
public class AuthController {

    @Resource
    private MailService mailService;

    @Resource
    private LagouTokenService lagouTokenService;

    @Resource
    private LagouAuthCodeService lagouAuthCodeService;

    private static SecureRandom secureRandom = new SecureRandom();

    @RequestMapping("/check/{token}")
    public Object checkUser(@PathVariable String token) {
        List<LagouToken> lagouTokens = lagouTokenService.queryAll(new LagouToken() {{
            setToken(token);
        }});
        if (lagouTokens==null || lagouTokens.size()!=1) {
            return false;
        } else {
            String email = lagouTokens.get(0).getEmail();
            System.out.println(email);
            return email;
        }
    }

    @RequestMapping("/getCheckCode/{email}")
    public Object getCheckCode(@PathVariable String email) {
        if (email == null || "".equals(email)) {
            return false;
        }
        List<LagouAuthCode> lagouAuthCodes = lagouAuthCodeService.queryAll(new LagouAuthCode() {{
            setEmail(email);
        }});
        if (lagouAuthCodes != null && lagouAuthCodes.size() == 1) {
            LagouAuthCode lagouAuthCode = lagouAuthCodes.get(0);
            java.util.Date date = lagouAuthCode.getExpiretime();
            long currentTimeMillis = System.currentTimeMillis();
            long l = currentTimeMillis - date.getTime();
            if (l <= 10 * 60 * 1000) {
                mailService.sendMail(lagouAuthCode.getCode());
                return true;
            } else {
                String code = getCode();
                lagouAuthCode.setCode(code);
                lagouAuthCode.setExpiretime(new Date(currentTimeMillis));
                lagouAuthCodeService.update(lagouAuthCode);
                mailService.sendMail(code);
                return true;
            }
        }
        String code = getCode();
        lagouAuthCodeService.insert(new LagouAuthCode() {{
            setEmail(email);
            setCode(code);
            setCreatetime(new Date(System.currentTimeMillis()));
            setExpiretime(new Date(System.currentTimeMillis()));
        }});
        mailService.sendMail(code);
        return true;
    }

    private String getCode() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(secureRandom.nextInt(10));
        }
        return stringBuilder.toString();
    }

}
