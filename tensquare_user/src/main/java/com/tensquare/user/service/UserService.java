package com.tensquare.user.service;

import com.tensquare.user.pojo.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: UserService
 * @Author: Samele LGX
 * @CreateTime: 2020-07-27 21:54
 * @Description: 用户服务层
 */
public interface UserService {

    /**
     * 查询全部列表
     *
     * @return
     */
    public List<User> findAll();

    /**
     * 分页条件查询
     *
     * @param whereMap
     * @param page
     * @param size
     * @return
     */
    public Page<User> findSearch(Map whereMap, int page, int size);

    /**
     * 条件查询
     *
     * @param whereMap
     * @return
     */
    public List<User> findSearch(Map whereMap);

    /**
     * 根据ID查询实体
     *
     * @param id
     * @return
     */
    public User findById(String id);

    /**
     * 增加
     *
     * @param user
     */
    public void add(User user, String code);

    /**
     * 修改
     *
     * @param user
     */
    public void update(User user);

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(String id);

    /**
     * 发送短信验证码
     *
     * @param mobile
     */
    public void sendSms(String mobile);

    /**
     * 根据手机号和密码查询用户
     *
     * @param mobile
     * @param password
     * @return
     */
    public User findByMobileAndPassword(String mobile, String password);

    /**
     * 更新粉丝数
     *
     * @param userid
     * @param x
     */
    public void incFanscount(String userid,int x);

    /**
     * 更新关注数
     *
     * @param userid
     * @param x
     */
    public void incFollowcount(String userid,int x);
}

