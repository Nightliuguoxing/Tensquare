package com.tensquare.recruit.dao;

import com.tensquare.recruit.pojo.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @ClassName: EnterpriseDao
 * @Author: Samele LGX
 * @CreateTime: 2020-07-25 19:31
 * @Description: 企业数据访问接口
 */
public interface EnterpriseDao extends JpaRepository<Enterprise, String>, JpaSpecificationExecutor<Enterprise> {

    /**
     * 根据热门状态获取企业列表
     *
     * @param ishot
     * @return
     */
    public List<Enterprise> findByIshot(String ishot);

}

