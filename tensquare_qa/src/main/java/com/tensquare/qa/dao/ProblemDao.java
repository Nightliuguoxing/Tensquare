package com.tensquare.qa.dao;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName: ProblemDao
 * @Author: Samele LGX
 * @CreateTime: 2020-07-26 08:25
 * @Description: 问题数据访问接口
 */
public interface ProblemDao extends JpaRepository<Problem,String>, JpaSpecificationExecutor<Problem> {

}
