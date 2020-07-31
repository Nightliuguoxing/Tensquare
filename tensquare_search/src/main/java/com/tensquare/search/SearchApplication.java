package com.tensquare.search;

import com.tensquare.common.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName: SearchApplication
 * @Author: Samele LGX
 * @CreateTime: 2020-07-27 11:27
 * @Description: 搜索微服务启动类
 */
@EnableEurekaClient
@SpringBootApplication
public class SearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class, args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,7);
    }
}
