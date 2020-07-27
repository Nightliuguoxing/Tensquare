package com.tensquare.user.dao;

import com.tensquare.user.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName: UserDao
 * @Author: Samele LGX
 * @CreateTime: 2020-07-27 21:44
 * @Description: 用户数据访问接口
 */
public interface UserDao extends JpaRepository<User,String>, JpaSpecificationExecutor<User> {

}
