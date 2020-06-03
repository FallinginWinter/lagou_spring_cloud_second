package com.lagou.filter;

import com.lagou.common.RetResult;
import com.lagou.dubbo.api.AuthCodeService;
import com.lagou.vo.IpCheckVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpCookie;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: lihaonan
 * @Date: 2020/5/20
 */
@Slf4j
@Component
public class CommonFilter implements GlobalFilter, Ordered {

    @Value("${limitMinute}")
    private int limitMinute;

    @Value("${maxCount}")
    private int maxCount;

    @Reference
    private AuthCodeService userTokenFeign;

    // 模拟黑名单（实际可以去数据库或者redis中查询）
    private static List<String> blackList = new ArrayList<>();

    private static final ConcurrentHashMap<String, IpCheckVo> IP_CHECK_MAP = new ConcurrentHashMap<>();

    static {
        // 模拟本机地址
//        blackList.add("0:0:0:0:0:0:0:1");
    }

    /**
     * 过滤器核心方法
     *
     * @param exchange 封装了request和response对象的上下文
     * @param chain    网关过滤器链（包含全局过滤器和单路由过滤器）
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 思路：获取客户端ip，判断是否在黑名单中，在的话就拒绝访问，不在的话就放行
        // 从上下文中取出request和response对象
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        // 从request对象中获取客户端ip
        String clientIp = request.getRemoteAddress().getHostString();
        // 拿着clientIp去黑名单中查询，存在的话就决绝访问
        if (blackList.contains(clientIp)) {
            // 决绝访问，返回状态码
//            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            System.out.println("=====>IP:" + clientIp + " 在黑名单中，将被拒绝访问！");
            String data = "Request be denied!";
            RetResult<String> result = new RetResult<>(-1, data);
            DataBuffer wrap = response.bufferFactory().wrap(result.toString().getBytes());
            return response.writeWith(Mono.just(wrap));
        }

        String uriStr = request.getURI().toString();
        System.out.println(uriStr);
        if (!uriStr.contains("/api/code/getCheckCode/") && !uriStr.contains("/api/user/register")) {
            MultiValueMap<String, HttpCookie> cookies = request.getCookies();
            HttpCookie token = cookies.getFirst("token");
            System.out.println(token);
            String value = token.getValue();
            Object checkToken = userTokenFeign.checkToken(value);
            if ("false".equals(checkToken.toString())) {
                // 决绝访问，返回状态码
//                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                System.out.println("=====>IP:" + clientIp + " 系统异常！");
                String data = "Request be denied!";
                RetResult<String> result = new RetResult<>(-1, data);
                DataBuffer wrap = response.bufferFactory().wrap(result.toString().getBytes());
                return response.writeWith(Mono.just(wrap));
            } else {
                System.out.println("email = " + checkToken);
            }
        }

        //限流
        Mono<Void> wrap1 = checkIpCount(response, clientIp);
        if (wrap1 != null) {
            return wrap1;
        }
        // 合法请求，放行，执行后续的过滤器
        return chain.filter(exchange);
    }

    private Mono<Void> checkIpCount(ServerHttpResponse response, String clientIp) {
        IpCheckVo ipCheckVo = IP_CHECK_MAP.get(clientIp);
        System.out.println(clientIp);
        final long currentTimeMillis = System.currentTimeMillis();
        if (ipCheckVo == null) {
            IP_CHECK_MAP.put(clientIp, new IpCheckVo() {{
                setCount(1);
                setCreatTime(currentTimeMillis);
            }});
        } else {
            //limitMinute分钟超时
            if (currentTimeMillis - ipCheckVo.getCreatTime() >= limitMinute * 60 * 1000) {
                ipCheckVo.setCount(1);
                ipCheckVo.setCreatTime(currentTimeMillis);
            } else {
                int nextCount = ipCheckVo.getCount() + 1;
                if (nextCount > maxCount) {
                    // 决绝访问，返回状态码
                    System.out.println("=====>IP:" + clientIp + " 访问次数过多！");
                    String data = "Request to more!";
                    RetResult<String> result = new RetResult<>(-1, data);
                    DataBuffer wrap = response.bufferFactory().wrap(result.toString().getBytes());
                    return response.writeWith(Mono.just(wrap));
                } else {
                    ipCheckVo.setCount(nextCount);
                }
            }
        }
        return null;
    }


    /**
     * 返回值表示当前过滤器的顺序(优先级)，数值越小，优先级越高
     *
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
