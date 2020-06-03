package com.lagou.service.Impl;

import com.lagou.common.RetResult;
import com.lagou.dubbo.api.AuthCodeService;
import com.lagou.entity.LagouToken;
import com.lagou.service.LagouTokenService;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: lihaonan
 * @Date: 2020/6/3
 */
@Service
public class AuthCodeServiceImpl implements AuthCodeService {

    @Resource
    private LagouTokenService lagouTokenService;

    @Override
    public RetResult checkToken(String token) {
        List<LagouToken> lagouTokens = lagouTokenService.queryAll(new LagouToken() {{
            setToken(token);
        }});
        if (lagouTokens==null || lagouTokens.size()!=1) {
            return new RetResult<>(-1);
        } else {
            String email = lagouTokens.get(0).getEmail();
            System.out.println(email);
            return new RetResult<>(email);
        }
    }
}
