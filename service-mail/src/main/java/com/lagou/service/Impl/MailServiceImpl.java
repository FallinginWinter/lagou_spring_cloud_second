package com.lagou.service.Impl;

import com.lagou.common.RetResult;
import com.lagou.dubbo.api.MailService;
import com.lagou.service.MailTemplateService;
import com.lagou.vo.MailInfoVo;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * @Author: lihaonan
 * @Date: 2020/6/3
 */
@Service
public class MailServiceImpl implements MailService {

    @Resource
    private MailTemplateService mailTemplateService;

    @Override
    public RetResult sendMail(String code, String email) {
        MailInfoVo mailInfoVo = new MailInfoVo();
        mailInfoVo.setHtmlContent("验证码: " + code);
        mailInfoVo.setTitle("验证码邮件");
        mailInfoVo.setToUsers(new String[]{email});
        mailTemplateService.sendMailByHtml(mailInfoVo);
        return RetResult.SUCCESS;
    }
}
