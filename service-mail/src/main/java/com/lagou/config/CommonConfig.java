package com.lagou.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * @Author: lihaonan
 * @Date: 2020/5/21
 */
@Configuration
public class CommonConfig {

    @Value("${mail.host}")
    private String mailHost;
    @Value("${mail.account}")
    private String mailAccount;
    @Value("${mail.password}")
    private String mailPassword;
    @Value("${mail.port}")
    private int mailPort;


    @Bean(name = "javaMailSender")
    @Primary
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(mailHost);
        javaMailSender.setDefaultEncoding("UTF-8");
        javaMailSender.setUsername(mailAccount);
        javaMailSender.setPassword(mailPassword);
        javaMailSender.setPort(mailPort);
        javaMailSender.setJavaMailProperties(new Properties() {{
            setProperty("mail.smtp.auth", "true");
            setProperty("mail.smtp.timeout", "25000");
            setProperty("mail.smtp.starttls.enable", "true");
            setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            setProperty("mail.transport.protocol", "smtp");
        }});
        return javaMailSender;
    }

}
