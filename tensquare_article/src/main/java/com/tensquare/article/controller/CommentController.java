package com.tensquare.article.controller;

import com.tensquare.article.pojo.Comment;
import com.tensquare.article.service.CommentService;
import com.tensquare.common.entity.Result;
import com.tensquare.common.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: CommentController
 * @Author: Samele LGX
 * @CreateTime: 2020-07-26 17:42
 * @Description: 评论控制层
 */
@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 添加评论
     *
     * @param comment
     * @return
     */
    @PostMapping
    public Result save(@RequestBody Comment comment) {
        commentService.add(comment);
        return new Result(true, StatusCode.OK, "提交成功 ");
    }

    /**
     * 根据文章ID查询评论列表
     *
     * @param articleid
     * @return
     */
    @GetMapping("/article/{articleid}")
    public Result findByArticleid(@PathVariable String articleid) {
        return new Result(true, StatusCode.OK, "查询成功", commentService.findByArticleid(articleid));
    }

    /**
     * 根据ID删除评论
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        commentService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

}
