package com.tensquare.article.controller;


import java.util.Map;

import com.tensquare.common.entity.PageResult;
import com.tensquare.common.entity.Result;
import com.tensquare.common.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.tensquare.article.pojo.Column;
import com.tensquare.article.service.ColumnService;


/**
 * @ClassName: ColumnController
 * @Author: Samele LGX
 * @CreateTime: 2020-07-26 11:03
 * @Description: 专栏控制层
 */
@RestController
@CrossOrigin
@RequestMapping("/column")
public class ColumnController {

    @Autowired
    private ColumnService columnService;


    /**
     * 查询全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功",columnService.findAll());
    }

    /**
     * 根据ID查询
     * @param id ID
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable String id){
        return new Result(true,StatusCode.OK,"查询成功",columnService.findById(id));
    }


    /**
     * 多条件分页查询
     * @param searchMap 查询条件封装
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @PostMapping("/search/{page}/{size}")
    public Result findSearch(@RequestBody Map searchMap , @PathVariable int page, @PathVariable int size){
        Page<Column> pageList = columnService.findSearch(searchMap, page, size);
        return  new Result(true,StatusCode.OK,"查询成功",  new PageResult<Column>(pageList.getTotalElements(), pageList.getContent()) );
    }

    /**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @PostMapping("/search")
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",columnService.findSearch(searchMap));
    }

    /**
     * 增加
     * @param column
     */
    @PostMapping
    public Result add(@RequestBody Column column  ){
        columnService.add(column);
        return new Result(true,StatusCode.OK,"增加成功");
    }

    /**
     * 修改
     * @param column
     */
    @PutMapping("/{id}")
    public Result update(@RequestBody Column column, @PathVariable String id ){
        column.setId(id);
        columnService.update(column);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /**
     * 删除
     * @param id
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id){
        columnService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

}

