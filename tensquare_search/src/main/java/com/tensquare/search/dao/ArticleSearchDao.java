package com.tensquare.search.dao;

import com.tensquare.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @ClassName: ArticleSearchDao
 * @Author: Samele LGX
 * @CreateTime: 2020-07-27 11:31
 * @Description: 文章搜索数据访问层
 */
public interface ArticleSearchDao extends ElasticsearchRepository<Article,String> {

    /**
     * 检索
     * @param title
     * @param content
     * @param pageable
     * @return
     */
    public Page<Article> findByTitleOrContentLike(String title, String content, Pageable pageable);
}
