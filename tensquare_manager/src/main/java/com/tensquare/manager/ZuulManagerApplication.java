package com.tensquare.manager;

import com.tensquare.common.util.JwtUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName: ZuulApplication
 * @Author: Samele LGX
 * @CreateTime: 2020-08-01 10:54
 * @Description: 后台网关
 */
@EnableZuulProxy
@SpringBootApplication
public class ZuulManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulManagerApplication.class, args);
    }

    @Bean
    public JwtUtil jwtUtil(){
        return new JwtUtil();
    }
}
