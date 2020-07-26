package com.tensquare.gathering;

import com.tensquare.common.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName: GatheringApplication
 * @Author: Samele LGX
 * @CreateTime: 2020-07-26 11:51
 * @Description: 活动微服务启动类
 */
@EnableCaching
@SpringBootApplication
public class GatheringApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatheringApplication.class, args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,5);
    }

}
