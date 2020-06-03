package com.lagou.dubbo.api;

import com.lagou.common.RetResult;

/**
 * @Author: lihaonan
 * @Date: 2020/6/2
 */
public interface AuthCodeService {

    RetResult checkToken(String token);

}
