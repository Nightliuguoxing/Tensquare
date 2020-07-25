package com.tensquare.qa;

import com.tensquare.common.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName: QaApplication
 * @Author: Samele LGX
 * @CreateTime: 2020-07-25 20:14
 * @Description: 问答微服务启动类
 */
@SpringBootApplication
public class QaApplication {

    public static void main(String[] args) {
        SpringApplication.run(QaApplication.class, args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,3);
    }
}
