package com.tensquare.search.service.Impl;

import com.tensquare.search.dao.ArticleSearchDao;
import com.tensquare.search.pojo.Article;
import com.tensquare.search.service.ArticleSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @ClassName: ArticleSearchServiceImpl
 * @Author: Samele LGX
 * @CreateTime: 2020-07-27 11:33
 * @Description: 文章搜索业务层实现
 */
@Service
public class ArticleSearchServiceImpl implements ArticleSearchService {

    @Autowired
    private ArticleSearchDao articleSearchDao;

    /**
     * 增加
     *
     * @param article
     */
    @Override
    public void add(Article article) {
        articleSearchDao.save(article);
    }

    /**
     * 检索
     *
     * @param keywords
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<Article> findByTitleLike(String keywords, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page-1, size);
        return articleSearchDao.findByTitleOrContentLike(keywords,keywords, pageRequest);
    }
}
