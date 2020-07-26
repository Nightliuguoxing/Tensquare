package com.tensquare.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.article.pojo.Channel;

/**
 * @ClassName: ChannelDao
 * @Author: Samele LGX
 * @CreateTime: 2020-07-26 10:42
 * @Description: 频道数据访问接口
 */
public interface ChannelDao extends JpaRepository<Channel,String>,JpaSpecificationExecutor<Channel>{

}
