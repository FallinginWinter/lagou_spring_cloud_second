package com.lagou.controller;

import com.lagou.service.MailTemplateService;
import com.lagou.vo.MailInfoVo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: lihaonan
 * @Date: 2020/5/25
 */
@RequestMapping("/api")
@RestController
public class MailController {

    @Resource
    private MailTemplateService mailTemplateService;

    @RequestMapping("/send/mail/{code}")
    public Object sendMail(@PathVariable String code) {
        MailInfoVo mailInfoVo = new MailInfoVo();
        mailInfoVo.setHtmlContent("验证码: " + code);
        mailInfoVo.setTitle("验证码邮件");
        mailInfoVo.setToUsers(new String[]{"847198028@qq.com"});
        mailTemplateService.sendMailByHtml(mailInfoVo);
        return true;
    }

}
