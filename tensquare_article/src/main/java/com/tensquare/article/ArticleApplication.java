package com.tensquare.article;

import com.tensquare.common.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName: ArticleApplication
 * @Author: Samele LGX
 * @CreateTime: 2020-07-26 10:25
 * @Description: 文章微服务启动类
 */
@EnableEurekaClient
@SpringBootApplication
public class ArticleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArticleApplication.class, args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,4);
    }
}
