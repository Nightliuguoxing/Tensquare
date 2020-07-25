package com.tensquare.recruit.controller;

import com.tensquare.common.entity.PageResult;
import com.tensquare.common.entity.Result;
import com.tensquare.common.entity.StatusCode;
import com.tensquare.recruit.pojo.Recruit;
import com.tensquare.recruit.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName: RecruitController
 * @Author: Samele LGX
 * @CreateTime: 2020-07-25 19:42
 * @Description: 招聘控制层
 */
@RestController
@CrossOrigin
@RequestMapping("/recruit")
public class RecruitController {

    @Autowired
    private RecruitService recruitService;


    /**
     * 查询全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功",recruitService.findAll());
    }

    /**
     * 根据ID查询
     * @param id ID
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable String id){
        return new Result(true,StatusCode.OK,"查询成功",recruitService.findById(id));
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
        Page<Recruit> pageList = recruitService.findSearch(searchMap, page, size);
        return  new Result(true,StatusCode.OK,"查询成功",  new PageResult<Recruit>(pageList.getTotalElements(), pageList.getContent()) );
    }

    /**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @PostMapping("/search")
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",recruitService.findSearch(searchMap));
    }

    /**
     * 增加
     * @param recruit
     */
    @PostMapping
    public Result add(@RequestBody Recruit recruit  ){
        recruitService.add(recruit);
        return new Result(true,StatusCode.OK,"增加成功");
    }

    /**
     * 修改
     * @param recruit
     */
    @PutMapping("/{id}")
    public Result update(@RequestBody Recruit recruit, @PathVariable String id ){
        recruit.setId(id);
        recruitService.update(recruit);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /**
     * 删除
     * @param id
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id){
        recruitService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /**
     * 查询推荐职位列表(未按创建日期降序排序)
     * @return
     * FIXME: Method Needs To Be Rewritten
     */
    @GetMapping("/search/recommend")
    public Result recommend(){
        return new Result(true, StatusCode.OK, "查询成功", recruitService.findTop12ByStateNotOrderByCreatetimeDesc("0"));
    }

    /**
     * 查询最新职位列表(按创建日期降序排序)
     * @return
     * FIXME: Method Needs To Be Rewritten
     */
    @GetMapping("/search/lastest")
    public Result lastest(){
        return new Result(true, StatusCode.OK, "查询成功", recruitService.findTop4ByStateOrderByCreatetimeDesc("2"));
    }

}

