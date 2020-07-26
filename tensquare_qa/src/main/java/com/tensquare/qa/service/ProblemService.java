package com.tensquare.qa.service;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ProblemService
 * @Author: Samele LGX
 * @CreateTime: 2020-07-26 08:26
 * @Description: 问题服务层
 */
public interface ProblemService {

    /**
     * 查询全部列表
     *
     * @return
     */
    public List<Problem> findAll();

    /**
     * 分页条件查询
     *
     * @param whereMap
     * @param page
     * @param size
     * @return
     */
    public Page<Problem> findSearch(Map whereMap, int page, int size);

    /**
     * 条件查询
     *
     * @param whereMap
     * @return
     */
    public List<Problem> findSearch(Map whereMap);

    /**
     * 根据ID查询实体
     *
     * @param id
     * @return
     */
    public Problem findById(String id);

    /**
     * 增加
     *
     * @param problem
     */
    public void add(Problem problem);

    /**
     * 修改
     *
     * @param problem
     */
    public void update(Problem problem);

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(String id);

    /**
     * 根据标签ID查询问题列表
     *
     * @param lableId
     * @param page
     * @param size
     * @return
     */
    public Page<Problem> findNewListByLabelId(String lableId, int page, int size);

    /**
     * 根据标签ID查询热门问题列表
     *
     * @param lableId
     * @param page
     * @param size
     * @return
     */
    public Page<Problem> findHotListByLabelId(String lableId,int page, int size);

}
