package com.lagou.service.Impl;

import com.lagou.service.MailTemplateService;
import com.lagou.vo.MailInfoVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;

/**
 * @Author: lihaonan
 * @Date: 2020/5/21
 */
@Service
public class MailTemplateServiceImpl implements MailTemplateService {

    @Resource
    private SpringTemplateEngine templateEngine;

    @Resource
    private JavaMailSender javaMailSender;

    @Value("${mail.account}")
    private String mailFromAccount;

    static {
        //不设置此参数会导致过长文件名的附件名称异常
        System.getProperties().setProperty("mail.mime.splitlongparameters", "false");
    }

    /**
     * 以指定模板发送邮件
     *
     * @param mailInfoVo 模板所需信息
     * @return RetResult
     */
    @Override
    public Object sendMailByTemplate(MailInfoVo mailInfoVo) {
        final Context context = new Context(Locale.getDefault());
        if (null != mailInfoVo.getContentMap() && mailInfoVo.getContentMap().size() != 0) {
            context.setVariables(mailInfoVo.getContentMap());
        }
        String templateName = mailInfoVo.getTemplateName();
        if (templateName == null || "".equals(templateName)) {
            return null;
        }
        final String htmlContent = templateEngine.process(templateName, context);
        mailInfoVo.setHtmlContent(htmlContent);
        return sendMail(mailInfoVo);
    }

    /**
     * 以自定义的html内容发送邮件
     *
     * @param mailInfoVo 模板所需信息
     * @return RetResult
     */
    @Override
    public Object sendMailByHtml(MailInfoVo mailInfoVo) {
        final String htmlContent = mailInfoVo.getHtmlContent();
        if (htmlContent == null || "".equals(htmlContent)) {
            return null;
        }
        return sendMail(mailInfoVo);
    }

    private Object sendMail(MailInfoVo mailInfoVo) {
        final String htmlContent = mailInfoVo.getHtmlContent();
        final MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        String[] toUsers;
        try {
            final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            if (checkStrArray(mailInfoVo.getToUsers())) {
                toUsers = mailInfoVo.getToUsers();
            } else {
                return null;
            }
            message.setFrom(mailFromAccount);
            message.setTo(toUsers);
            if (checkStrArray(mailInfoVo.getCarbonCopyUsers())) {
                message.setCc(mailInfoVo.getCarbonCopyUsers());
            }
            if (checkStrArray(mailInfoVo.getBlindCarbonCopyUsers())) {
                message.setBcc(mailInfoVo.getBlindCarbonCopyUsers());
            }

            if (checkList(mailInfoVo.getFilePathList())) {
                for (String filePath : mailInfoVo.getFilePathList()) {
                    String fileName = filePath.substring(filePath.lastIndexOf(File.separator) + 1);
                    message.addAttachment(MimeUtility.encodeText(fileName).replaceAll("\\s", ""), new File(filePath));
                }
            }
            message.setSubject(MimeUtility.encodeText(mailInfoVo.getTitle()).replaceAll("\\s", ""));
            message.setText(htmlContent, true);
            javaMailSender.send(mimeMessage);

        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
        return "";
    }

    private boolean checkStrArray(String[] userStrArray) {
        return null != userStrArray && userStrArray.length != 0 && !StringUtils.isEmpty(userStrArray[0]);
    }

    private boolean checkList(List<String> list) {
        return null != list && list.size() != 0;
    }

    private String[] listToStringArray(List<String> mailList) {
        return mailList.toArray(new String[0]);
    }
}

