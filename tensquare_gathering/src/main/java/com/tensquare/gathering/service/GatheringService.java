package com.tensquare.gathering.service;

import com.tensquare.gathering.pojo.Gathering;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: GatheringService
 * @Author: Samele LGX
 * @CreateTime: 2020-07-26 12:33
 * @Description: 活动业务层
 */
public interface GatheringService {

    /**
     * 查询全部列表
     * @return
     */
    public List<Gathering> findAll() ;

    /**
     * 分页条件查询
     * @param whereMap
     * @param page
     * @param size
     * @return
     */
    public Page<Gathering> findSearch(Map whereMap, int page, int size) ;

    /**
     * 条件查询
     * @param whereMap
     * @return
     */
    public List<Gathering> findSearch(Map whereMap) ;

    /**
     * 根据ID查询实体
     * @param id
     * @return
     */
    public Gathering findById(String id) ;

    /**
     * 增加
     * @param gathering
     */
    public void add(Gathering gathering) ;

    /**
     * 修改
     * @param gathering
     */
    public void update(Gathering gathering) ;

    /**
     * 删除
     * @param id
     */
    public void deleteById(String id) ;

}

