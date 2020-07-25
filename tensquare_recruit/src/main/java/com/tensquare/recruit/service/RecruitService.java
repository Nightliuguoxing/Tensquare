package com.tensquare.recruit.service;

import com.tensquare.recruit.pojo.Recruit;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: RecruitService
 * @Author: Samele LGX
 * @CreateTime: 2020-07-25 19:32
 * @Description: 招聘服务层
 */
public interface RecruitService {

    /**
     * 查询全部列表
     *
     * @return
     */
    public List<Recruit> findAll();


    /**
     * 分页条件查询
     *
     * @param whereMap
     * @param page
     * @param size
     * @return
     */
    public Page<Recruit> findSearch(Map whereMap, int page, int size);


    /**
     * 条件查询
     *
     * @param whereMap
     * @return
     */
    public List<Recruit> findSearch(Map whereMap);

    /**
     * 根据ID查询实体
     *
     * @param id
     * @return
     */
    public Recruit findById(String id);

    /**
     * 增加
     *
     * @param recruit
     */
    public void add(Recruit recruit);

    /**
     * 修改
     *
     * @param recruit
     */
    public void update(Recruit recruit);

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(String id);

    /**
     * 查询最新职位列表(按创建日期降序排序)
     *
     * @param state
     * @return
     */
    public List<Recruit> findTop4ByStateOrderByCreatetimeDesc(String state);

    /**
     * 查询推荐职位列表(未按创建日期降序排序)
     *
     * @param state
     * @return
     */
    public List<Recruit> findTop12ByStateNotOrderByCreatetimeDesc(String state);


}

