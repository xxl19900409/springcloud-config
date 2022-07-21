package com.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZonedDateTime;

/**
 * @author xiaxl
 * @version v1.0
 * @ClassName GatewayConfig
 * @Descrption 编码方式实现路由
 * @date 2022/7/20 15:32
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_baidu",r->r.path("/guonei").uri("http://news.baidu.com"));
        return routes.build();

    }
}
