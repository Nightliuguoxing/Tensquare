package com.tensquare.article.service;

import com.tensquare.article.pojo.Channel;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ChannelService
 * @Author: Samele LGX
 * @CreateTime: 2020-07-26 10:53
 * @Description: 频道业务层
 */
public interface ChannelService {

    /**
     * 查询全部列表
     *
     * @return
     */
    public List<Channel> findAll();

    /**
     * 分页条件查询
     *
     * @param whereMap
     * @param page
     * @param size
     * @return
     */
    public Page<Channel> findSearch(Map whereMap, int page, int size);

    /**
     * 条件查询
     *
     * @param whereMap
     * @return
     */
    public List<Channel> findSearch(Map whereMap);

    /**
     * 根据ID查询实体
     *
     * @param id
     * @return
     */
    public Channel findById(String id);

    /**
     * 增加
     *
     * @param channel
     */
    public void add(Channel channel);

    /**
     * 修改
     *
     * @param channel
     */
    public void update(Channel channel);

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(String id);

}
