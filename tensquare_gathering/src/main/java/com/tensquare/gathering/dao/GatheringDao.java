package com.tensquare.gathering.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.gathering.pojo.Gathering;

/**
 * @ClassName: GatheringDao
 * @Author: Samele LGX
 * @CreateTime: 2020-07-26 12:33
 * @Description: 活动数据访问接口
 */
public interface GatheringDao extends JpaRepository<Gathering,String>,JpaSpecificationExecutor<Gathering>{

}
