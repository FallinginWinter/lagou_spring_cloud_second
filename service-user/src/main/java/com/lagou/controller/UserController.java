package com.lagou.controller;

import com.alibaba.fastjson.JSONObject;
import com.lagou.entity.LagouAuthCode;
import com.lagou.entity.LagouToken;
import com.lagou.entity.LagouUser;
import com.lagou.service.LagouAuthCodeService;
import com.lagou.service.LagouTokenService;
import com.lagou.service.LagouUserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @Author: lihaonan
 * @Date: 2020/5/20
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private LagouTokenService lagouTokenService;

    @Resource
    private LagouAuthCodeService lagouAuthCodeService;

    @Resource
    private LagouUserService lagouUserService;

    @RequestMapping("/login/{email}/{password}")
    public Object login(@PathVariable String email, @PathVariable String password) {
        List<LagouUser> lagouUsers = lagouUserService.queryAll(new LagouUser() {{
            setEmail(email);
            setPassword(password);
        }});
        if (lagouUsers == null || lagouUsers.size() != 1) {
            return false;
        } else {
            return email;
        }
    }

    @RequestMapping("/register/{email}/{password}/{code}")
    public Object register(@PathVariable String email, @PathVariable String password, @PathVariable String code) {
        List<LagouAuthCode> lagouAuthCodes = lagouAuthCodeService.queryAll(new LagouAuthCode() {{
            setEmail(email);
        }});
        if (lagouAuthCodes == null || lagouAuthCodes.size() != 1) {
            return false;
        }
        LagouAuthCode lagouAuthCode = lagouAuthCodes.get(0);
        if (code.equals(lagouAuthCode.getCode())) {
            LagouUser lagouUser = new LagouUser() {{
                setEmail(email);
                setPassword(password);
            }};
            List<LagouUser> lagouUsers = lagouUserService.queryAll(lagouUser);
            if (lagouUsers != null && lagouUsers.size() == 1) {
                List<LagouToken> lagouTokens = lagouTokenService.queryAll(new LagouToken() {{
                    setEmail(email);
                }});
                if (lagouTokens==null || lagouTokens.size()!=1) {
                    return false;
                } else {
                    return lagouTokens.get(0).getToken();
                }
            }
            String token = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
            lagouTokenService.insert(new LagouToken() {{
                setEmail(email);
                setToken(token);
            }});
            lagouUserService.insert(lagouUser);
            return token;
        } else {
            return false;
        }
    }

    @RequestMapping("/isRegistered/{email}")
    public Object isRegistered(@RequestBody JSONObject jsonObject, @PathVariable String email) {

        return "success";
    }

}
