package com.tensquare.article.service;

import com.tensquare.article.pojo.Article;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ArticleService
 * @Author: Samele LGX
 * @CreateTime: 2020-07-26 10:43
 * @Description: 文章服务层
 */
public interface ArticleService {

    /**
     * 查询全部列表
     *
     * @return
     */
    public List<Article> findAll();

    /**
     * 分页条件查询
     *
     * @param whereMap
     * @param page
     * @param size
     * @return
     */
    public Page<Article> findSearch(Map whereMap, int page, int size);

    /**
     * 条件查询
     *
     * @param whereMap
     * @return
     */
    public List<Article> findSearch(Map whereMap);

    /**
     * 根据ID查询实体
     *
     * @param id
     * @return
     */
    public Article findById(String id);

    /**
     * 增加
     *
     * @param article
     */
    public void add(Article article);

    /**
     * 修改
     *
     * @param article
     */
    public void update(Article article);

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(String id);

    /**
     * 文章审核
     *
     * @param id
     */
    public void examine(String id);

    /**
     * 点赞
     *
     * @param id
     * @return
     */
    public int updateThumbup(String id);

}
