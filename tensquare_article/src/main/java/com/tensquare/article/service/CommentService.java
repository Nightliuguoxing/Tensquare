package com.tensquare.article.service;

import com.tensquare.article.pojo.Comment;

import java.util.List;

/**
 * @ClassName: CommentService
 * @Author: Samele LGX
 * @CreateTime: 2020-07-26 17:37
 * @Description: 评论业务层
 */
public interface CommentService {

    /**
     * 添加评论
     * @param comment
     */
    public void add(Comment comment);

    /**
     * 根据文章ID查询评论列表
     * @param articleid
     * @return
     */
    public List<Comment> findByArticleid(String articleid);

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(String id);
}
