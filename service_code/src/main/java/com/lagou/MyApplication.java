package com.lagou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: lihaonan
 * @Date: 2020/5/21
 */
@SpringBootApplication(scanBasePackages = {"com.lagou"})
// 开启注册中心客户端 （通用型注解，比如注册到Eureka、Nacos等）
// 说明：从SpringCloud的Edgware版本开始，不加注解也ok，但是建议大家加上
@EnableDiscoveryClient
@MapperScan(basePackages = "com.lagou.dao")
@EnableFeignClients  // 开启Feign 客户端功能
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

}
