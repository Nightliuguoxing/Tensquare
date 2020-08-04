package com.tensquare.crawler.pipeline;

import com.tensquare.article.dao.ArticleDao;
import com.tensquare.article.pojo.Article;
import com.tensquare.common.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * @ClassName: ArticleDbPipeline
 * @Author: Samele LGX
 * @CreateTime: 2020-08-03 21:16
 * @Description: 文章爬取入库类
 */
@Component
public class ArticleDbPipeline implements Pipeline {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private IdWorker idWorker;

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    // 频道ID
    private String channelId;

    @Override
    public void process(ResultItems resultItems, Task task) {
        String title = resultItems.get("title");
        String content= resultItems.get("content");
        Article article=new Article();
        article.setId(idWorker.nextId()+"");
        article.setChannelid(channelId);
        article.setTitle(title);
        article.setContent(content);
        articleDao.save(article);
    }
}
