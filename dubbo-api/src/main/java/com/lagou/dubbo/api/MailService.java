package com.lagou.dubbo.api;

import com.lagou.common.RetResult;

/**
 * @Author: lihaonan
 * @Date: 2020/6/3
 */
public interface MailService {

    RetResult sendMail(String code, String email);

}
