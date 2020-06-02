package com.lagou.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: lihaonan
 * @Date: 2020/5/26
 */
@FeignClient(value = "service-code", fallback = UserTokenFeignImpl.class)
public interface UserTokenFeign {

    @GetMapping("/api/code/check/{token}")
    String checkToken(@PathVariable String token);

}
