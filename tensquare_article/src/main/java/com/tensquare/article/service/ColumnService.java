package com.tensquare.article.service;

import com.tensquare.article.pojo.Column;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ColumnService
 * @Author: Samele LGX
 * @CreateTime: 2020-07-26 10:56
 * @Description: 专栏业务层
 */
public interface ColumnService {

    /**
     * 查询全部列表
     *
     * @return
     */
    public List<Column> findAll();

    /**
     * 分页条件查询
     *
     * @param whereMap
     * @param page
     * @param size
     * @return
     */
    public Page<Column> findSearch(Map whereMap, int page, int size);

    /**
     * 条件查询
     *
     * @param whereMap
     * @return
     */
    public List<Column> findSearch(Map whereMap);

    /**
     * 根据ID查询实体
     *
     * @param id
     * @return
     */
    public Column findById(String id);

    /**
     * 增加
     *
     * @param column
     */
    public void add(Column column);

    /**
     * 修改
     *
     * @param column
     */
    public void update(Column column);

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(String id);

}
