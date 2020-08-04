package com.tensquare.crawler;

import com.tensquare.common.util.IdWorker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import us.codecraft.webmagic.scheduler.RedisScheduler;

/**
 * @ClassName: UserCrawlerApplication
 * @Author: Samele LGX
 * @CreateTime: 2020-08-03 22:17
 * @Description: 用户爬取微服务
 */
@SpringBootApplication
@EnableScheduling
public class UserCrawlerApplication {

    @Value("${redis.host}")
    private String redis_host;

    public static void main(String[] args) {
        SpringApplication.run(UserCrawlerApplication.class, args);
    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1, 15);
    }

    @Bean
    public RedisScheduler redisScheduler() {
        return new RedisScheduler(redis_host);
    }
}
