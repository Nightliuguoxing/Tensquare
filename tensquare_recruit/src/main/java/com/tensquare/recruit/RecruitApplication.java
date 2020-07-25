package com.tensquare.recruit;

import com.tensquare.common.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName: RecruitApplication
 * @Author: Samele LGX
 * @CreateTime: 2020-07-25 16:59
 * @Description: 招聘微服务启动类
 */
@SpringBootApplication
public class RecruitApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecruitApplication.class, args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,2);
    }
}
