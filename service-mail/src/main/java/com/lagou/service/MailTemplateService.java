package com.lagou.service;

import com.lagou.vo.MailInfoVo;

/**
 * @Author: lihaonan
 * @Date: 2020/5/21
 */
public interface MailTemplateService {

    Object sendMailByTemplate(MailInfoVo mailInfoVo);

    Object sendMailByHtml(MailInfoVo mailInfoVo);
}
