package com.tensquare.spit;

import com.tensquare.common.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName: SpitApplication
 * @Author: Samele LGX
 * @CreateTime: 2020-07-26 16:37
 * @Description: 吐槽微服务启动类
 */
@SpringBootApplication
public class SpitApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpitApplication.class, args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,6);
    }
}
