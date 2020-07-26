package com.tensquare.article.dao;

import com.tensquare.article.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @ClassName: CommentDao
 * @Author: Samele LGX
 * @CreateTime: 2020-07-26 17:36
 * @Description: 评论数据访问接口
 */
public interface CommentDao extends MongoRepository<Comment, String> {

    /**
     * 根据文章ID查询评论列表
     * @param articleid
     * @return
     */
    public List<Comment> findByArticleid(String articleid);

}
