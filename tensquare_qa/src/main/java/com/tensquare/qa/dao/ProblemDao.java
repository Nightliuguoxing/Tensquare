package com.tensquare.qa.dao;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * @ClassName: ProblemDao
 * @Author: Samele LGX
 * @CreateTime: 2020-07-26 08:25
 * @Description: 问题数据访问接口
 */
public interface ProblemDao extends JpaRepository<Problem, String>, JpaSpecificationExecutor<Problem> {

    /**
     * 根据标签ID查询最新问题列表
     *
     * @param labelId
     * @param pageable
     * @return
     */
    @Query("SELECT p FROM Problem p WHERE id IN( SELECT problemid FROM Pl WHERE labelid=?1 ) ORDER BY replytime DESC")
    public Page<Problem> findNewListByLabelId(String labelId, Pageable pageable);

    /**
     * 根据标签ID查询热门问题列表
     *
     * @param labelId
     * @param pageable
     * @return
     */
    @Query("SELECT p FROM Problem p WHERE id IN( SELECT problemid FROM Pl WHERE labelid=?1 ) ORDER BY reply DESC")
    public Page<Problem> findHotListByLabelId(String labelId, Pageable pageable);

}
