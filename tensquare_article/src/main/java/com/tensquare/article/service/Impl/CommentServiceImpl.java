package com.tensquare.article.service.Impl;

import com.tensquare.article.dao.CommentDao;
import com.tensquare.article.pojo.Comment;
import com.tensquare.article.service.CommentService;
import com.tensquare.common.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: CommentServiceImpl
 * @Author: Samele LGX
 * @CreateTime: 2020-07-26 17:38
 * @Description: 评论业务层实现
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 添加评论
     *
     * @param comment
     */
    @Override
    public void add(Comment comment) {
        comment.set_id(idWorker.nextId() + "");
        commentDao.save(comment);
    }

    /**
     * 根据文章ID查询评论列表
     *
     * @param articleid
     * @return
     */
    @Override
    public List<Comment> findByArticleid(String articleid) {
        return commentDao.findByArticleid(articleid);
    }

    /**
     * 根据ID删除
     *
     * @param id
     */
    @Override
    public void deleteById(String id) {
        commentDao.deleteById(id);
    }
}
