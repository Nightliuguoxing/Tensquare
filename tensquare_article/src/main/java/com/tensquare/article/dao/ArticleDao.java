package com.tensquare.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.article.pojo.Article;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @ClassName: ArticleDao
 * @Author: Samele LGX
 * @CreateTime: 2020-07-26 10:41
 * @Description: 文章数据访问接口
 */
public interface ArticleDao extends JpaRepository<Article, String>, JpaSpecificationExecutor<Article> {

    /**
     * 审核
     *
     * @param id
     */
    @Modifying
    @Query("UPDATE Article SET state='1' WHERE id=?1")
    public void examine(String id);

    /**
     * 点赞
     *
     * @param id
     * @return
     */
    @Modifying
    @Query("UPDATE Article a SET thumbup = thumbup + 1 WHERE id=?1")
    public int updateThumbup(String id);

}

