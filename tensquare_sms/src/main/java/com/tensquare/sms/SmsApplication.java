package com.tensquare.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: SmsApplication
 * @Author: Samele LGX
 * @CreateTime: 2020-07-28 08:03
 * @Description: 短信微服务启动类
 */
@SpringBootApplication
public class SmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmsApplication.class, args);
    }
}
