package com.tensquare.recruit.service;

import com.tensquare.recruit.pojo.Enterprise;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: EnterpriseService
 * @Author: Samele LGX
 * @CreateTime: 2020-07-25 19:37
 * @Description: 企业服务层
 */
public interface EnterpriseService {

    /**
     * 查询全部列表
     * @return
     */
    public List<Enterprise> findAll();


    /**
     * 分页条件查询
     * @param whereMap
     * @param page
     * @param size
     * @return
     */
    public Page<Enterprise> findSearch(Map whereMap, int page, int size);


    /**
     * 条件查询
     * @param whereMap
     * @return
     */
    public List<Enterprise> findSearch(Map whereMap);

    /**
     * 根据ID查询实体
     * @param id
     * @return
     */
    public Enterprise findById(String id);

    /**
     * 增加
     * @param enterprise
     */
    public void add(Enterprise enterprise);

    /**
     * 修改
     * @param enterprise
     */
    public void update(Enterprise enterprise);

    /**
     * 删除
     * @param id
     */
    public void deleteById(String id);

    /**
     * 根据热门状态获取企业列表
     *
     * @param ishot
     * @return
     */
    public List<Enterprise> findByIshot(String ishot);

}
