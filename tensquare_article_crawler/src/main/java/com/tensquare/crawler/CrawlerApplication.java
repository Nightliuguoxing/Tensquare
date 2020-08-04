package com.tensquare.crawler;

import com.tensquare.common.util.IdWorker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import us.codecraft.webmagic.scheduler.RedisScheduler;

/**
 * @ClassName: CrawlerApplication
 * @Author: Samele LGX
 * @CreateTime: 2020-08-03 21:01
 * @Description: 文章爬取微服务
 */
@SpringBootApplication
@EnableScheduling
public class CrawlerApplication {

    @Value("${redis.host}")
    private String redis_host;

    public static void main(String[] args) {
        SpringApplication.run(CrawlerApplication.class, args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,14);
    }

    @Bean
    public RedisScheduler redisScheduler(){
        return new RedisScheduler(redis_host);
    }
}
