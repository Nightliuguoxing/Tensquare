package com.tensquare.user.dao;

import com.tensquare.user.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @ClassName: UserDao
 * @Author: Samele LGX
 * @CreateTime: 2020-07-27 21:44
 * @Description: 用户数据访问接口
 */
public interface UserDao extends JpaRepository<User,String>, JpaSpecificationExecutor<User> {

    /**
     * 根据手机号查询用户
     * @param mobile
     * @return
     */
    public User findByMobile(String mobile);

    /**
     * 更新粉丝数
     * @param userid 用户ID
     * @param x 粉丝数
     */
    @Modifying
    @Query("UPDATE User u SET u.fanscount=u.fanscount+?2 WHERE u.id=?1")
    public void incFanscount(String userid,int x);

    /**
     * 更新关注数
     *
     * @param userid 用户ID
     * @param x 粉丝数
     */
    @Modifying
    @Query("UPDATE User u SET u.followcount=u.followcount+?2 WHERE u.id=?1")
    public void incFollowcount(String userid,int x);

}
