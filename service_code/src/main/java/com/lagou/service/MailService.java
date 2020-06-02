package com.lagou.service;

import com.lagou.service.Impl.MailServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: lihaonan
 * @Date: 2020/5/25
 */
@FeignClient(value = "service-mail", fallback = MailServiceImpl.class)
public interface MailService {

    // Feign要做的事情就是，拼装url发起请求
    // 我们调用该方法就是调用本地接口方法，那么实际上做的是远程请求
    @GetMapping("/api/send/mail/{code}")
    void sendMail(@PathVariable String code);

}
