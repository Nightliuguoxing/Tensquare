package com.tensquare.crawler.task;

import com.tensquare.crawler.pipeline.ArticleDbPipeline;
import com.tensquare.crawler.pipeline.ArticleTxtPipeline;
import com.tensquare.crawler.processor.ArticleProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.RedisScheduler;

/**
 * @ClassName: ArticleTask
 * @Author: Samele LGX
 * @CreateTime: 2020-08-03 21:22
 * @Description: 文章爬取任务类
 * FIXME: Need to rewrite method
 */
@Component
public class ArticleTask {

    @Autowired
    private ArticleDbPipeline articleDbPipeline;

    @Autowired
    private ArticleTxtPipeline articleTxtPipeline;

    @Autowired
    private RedisScheduler redisScheduler;

    @Autowired
    private ArticleProcessor articleProcessor;

    /**
     * 爬取ai数据
     */
    @Scheduled(cron = "0 54 21 * * ?")
    public void aiTask() {
        System.out.println("爬取AI文章");
        Spider spider = Spider.create(articleProcessor);
        spider.addUrl("https://blog.csdn.net/nav/ai");
        articleDbPipeline.setChannelId("ai");
        spider.addPipeline(articleDbPipeline);
        spider.setScheduler(redisScheduler);
        spider.start();
    }

    /**
     * 爬取db数据
     */
    @Scheduled(cron="20 17 11 * * ?")
    public void dbTask(){
        System.out.println("爬取DB文章");
        Spider spider = Spider.create(articleProcessor);
        spider.addUrl("https://blog.csdn.net/nav/db");
        spider.setScheduler(redisScheduler);
        spider.start();
    }
    /**
     * 爬取web数据
     */
    @Scheduled(cron="20 27 11 * * ?")
    public void webTask(){
        System.out.println("爬取WEB文章");
        Spider spider = Spider.create(articleProcessor);
        spider.addUrl("https://blog.csdn.net/nav/web");
        spider.setScheduler(redisScheduler);
        spider.start();
    }

}
