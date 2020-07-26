package com.tensquare.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.article.pojo.Column;

/**
 * @ClassName: ColumnDao
 * @Author: Samele LGX
 * @CreateTime: 2020-07-26 10:43
 * @Description: 专栏数据访问接口
 */
public interface ColumnDao extends JpaRepository<Column,String>,JpaSpecificationExecutor<Column>{

}
