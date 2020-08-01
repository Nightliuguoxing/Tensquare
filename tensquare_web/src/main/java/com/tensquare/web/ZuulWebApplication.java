package com.tensquare.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @ClassName: ZuulApplication
 * @Author: Samele LGX
 * @CreateTime: 2020-08-01 10:54
 * @Description: 前台网关
 */
@EnableZuulProxy
@SpringBootApplication
public class ZuulWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulWebApplication.class, args);
    }
}
