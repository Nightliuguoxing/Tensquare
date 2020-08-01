package com.tensquare.base.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TestController
 * @Author: Samele LGX
 * @CreateTime: 2020-08-01 14:48
 * @Description: 测试
 */
@RefreshScope
@RestController
public class TestController {

    @Value("${sms.ip}")
    private String ip;

    @GetMapping("/ip")
    public String ip(){
        return ip;
    }

}
