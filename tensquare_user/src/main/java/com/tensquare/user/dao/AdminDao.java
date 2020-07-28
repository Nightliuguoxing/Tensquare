package com.tensquare.user.dao;

import com.tensquare.user.pojo.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName: AdminDao
 * @Author: Samele LGX
 * @CreateTime: 2020-07-27 21:45
 * @Description: 管理员数据访问接口
 */
public interface AdminDao extends JpaRepository<Admin,String>, JpaSpecificationExecutor<Admin> {

    /**
     * 管理员登陆密码校验
     * @param loginname
     * @return
     */
    public Admin findByLoginname(String loginname);
}
