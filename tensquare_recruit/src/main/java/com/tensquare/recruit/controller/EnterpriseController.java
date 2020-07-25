package com.tensquare.recruit.controller;

import com.tensquare.common.entity.PageResult;
import com.tensquare.common.entity.Result;
import com.tensquare.common.entity.StatusCode;
import com.tensquare.recruit.pojo.Enterprise;
import com.tensquare.recruit.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName: EnterpriseController
 * @Author: Samele LGX
 * @CreateTime: 2020-07-25 19:43
 * @Description: 企业控制层
 */
@RestController
@CrossOrigin
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    /**
     * 查询全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功",enterpriseService.findAll());
    }

    /**
     * 根据ID查询
     * @param id ID
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable String id){
        return new Result(true,StatusCode.OK,"查询成功",enterpriseService.findById(id));
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
        Page<Enterprise> pageList = enterpriseService.findSearch(searchMap, page, size);
        return  new Result(true,StatusCode.OK,"查询成功",  new PageResult<Enterprise>(pageList.getTotalElements(), pageList.getContent()) );
    }

    /**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @PostMapping("/search")
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",enterpriseService.findSearch(searchMap));
    }

    /**
     * 增加
     * @param enterprise
     */
    @PostMapping
    public Result add(@RequestBody Enterprise enterprise  ){
        enterpriseService.add(enterprise);
        return new Result(true,StatusCode.OK,"增加成功");
    }

    /**
     * 修改
     * @param enterprise
     */
    @PutMapping("/{id}")
    public Result update(@RequestBody Enterprise enterprise, @PathVariable String id ){
        enterprise.setId(id);
        enterpriseService.update(enterprise);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /**
     * 删除
     * @param id
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id){
        enterpriseService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /**
     * 查询热门企业
     * @return
     */
    @GetMapping("/search/hotlist")
    public Result hotlist(){
        return new Result(true, StatusCode.OK, "查询成功", enterpriseService.findByIshot("1"));
    }

}

