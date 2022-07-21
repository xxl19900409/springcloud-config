package com.payment.config;

/**
 * @author xiaxl
 * @version v1.0
 * @ClassName MybatisConfig
 * @Descrption TODO
 * @date 2022/7/12 16:21
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan("com.payment.**.dao")
@Configuration
public class MybatisConfig {


}
