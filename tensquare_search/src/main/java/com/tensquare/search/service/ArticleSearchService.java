package com.tensquare.search.service;

import com.tensquare.search.pojo.Article;
import org.springframework.data.domain.Page;

/**
 * @ClassName: ArticleSearchService
 * @Author: Samele LGX
 * @CreateTime: 2020-07-27 11:32
 * @Description: 文章搜索业务层
 */
public interface ArticleSearchService {

    /**
     * 增加
     * @param article
     */
    public void add(Article article);

    /**
     * 检索
     * @param keywords
     * @param page
     * @param size
     * @return
     */
    public Page<Article> findByTitleLike(String keywords, int page, int size);

}
