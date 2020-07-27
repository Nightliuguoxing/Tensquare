package com.tensquare.user.service;

import com.tensquare.user.pojo.Admin;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: AdminService
 * @Author: Samele LGX
 * @CreateTime: 2020-07-27 21:53
 * @Description: 管理员服务层
 */
public interface AdminService {

    /**
     * 查询全部列表
     * @return
     */
    public List<Admin> findAll() ;

    /**
     * 分页条件查询
     * @param whereMap
     * @param page
     * @param size
     * @return
     */
    public Page<Admin> findSearch(Map whereMap, int page, int size) ;

    /**
     * 条件查询
     * @param whereMap
     * @return
     */
    public List<Admin> findSearch(Map whereMap) ;

    /**
     * 根据ID查询实体
     * @param id
     * @return
     */
    public Admin findById(String id) ;

    /**
     * 增加
     * @param admin
     */
    public void add(Admin admin) ;

    /**
     * 修改
     * @param admin
     */
    public void update(Admin admin) ;

    /**
     * 删除
     * @param id
     */
    public void deleteById(String id) ;

}

