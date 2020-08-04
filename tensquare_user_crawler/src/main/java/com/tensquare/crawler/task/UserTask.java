package com.tensquare.crawler.task;

import com.tensquare.crawler.pipeline.UserPipeline;
import com.tensquare.crawler.processor.UserProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.RedisScheduler;

/**
 * @ClassName: UserTask
 * @Author: Samele LGX
 * @CreateTime: 2020-08-03 22:27
 * @Description: 用户爬取任务类
 */
@Component
public class UserTask {

    @Autowired
    private RedisScheduler redisScheduler;

    @Autowired
    private UserPipeline userPipeline;

    @Autowired
    private UserProcessor userProcessor;

    /**
     * 爬取用户数据
     */
    @Scheduled(cron="0 56 22 * * ?")
    public void userTask(){
        System.out.println("爬取用户");
        Spider spider = Spider.create(userProcessor);
        spider.addUrl("https://blog.csdn.net");
        spider.addPipeline(userPipeline);
        spider.setScheduler(redisScheduler);
        spider.start();
    }

}
