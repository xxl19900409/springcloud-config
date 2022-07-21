package com.gateway.fileter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author xiaxl
 * @version v1.0
 * @ClassName MyGlobFilter
 * @Descrption TODO
 * @date 2022/7/21 15:14
 */
@Slf4j
@Component
public class MyGlobFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("************自定义全局过滤器**************");
        String name=exchange.getRequest().getQueryParams().getFirst("name");
        if(name==null){
            log.info("**********用户为空****************");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    /**
     * @Description: 数字越小 执行顺序越快
     * @Author: xiaxl
     * @Date:
     **/
    @Override
    public int getOrder() {
        return 1;
    }
}
