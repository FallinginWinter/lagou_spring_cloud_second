package com.lagou.base;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author: lihaonan
 * @Date: 2020/5/26
 */
public class MyKeyResolver implements KeyResolver {

    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        ServerHttpRequest request = exchange.getRequest();
        String hostAddress = request.getRemoteAddress().getAddress().getHostAddress();
        String hostString = request.getRemoteAddress().getHostString();
        System.out.println(hostAddress);
        System.out.println(hostString);
        return Mono.just(hostString);
    }

}
