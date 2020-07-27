package com.tensquare.search.controller;

import com.tensquare.common.entity.PageResult;
import com.tensquare.common.entity.Result;
import com.tensquare.common.entity.StatusCode;
import com.tensquare.search.pojo.Article;
import com.tensquare.search.service.ArticleSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: ArticleSearchController
 * @Author: Samele LGX
 * @CreateTime: 2020-07-27 11:35
 * @Description: 文章搜索控制层
 */
@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleSearchController {

    @Autowired
    private ArticleSearchService articleSearchService;

    /**
     * 添加文章
     *
     * @param article
     * @return
     */
    @PostMapping
    public Result save(@RequestBody Article article){
        articleSearchService.add(article);
        return new Result(true, StatusCode.OK, "操作成功");
    }

    /**
     * 检索
     *
     * @param keywords
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/search/{keywords}/{page}/{size}")
    public Result findByTitleLike(@PathVariable String keywords, @PathVariable int page, @PathVariable int size){
        Page<Article> articlePage = articleSearchService.findByTitleLike(keywords,page,size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Article>(articlePage.getTotalElements(), articlePage.getContent()));
    }

}
