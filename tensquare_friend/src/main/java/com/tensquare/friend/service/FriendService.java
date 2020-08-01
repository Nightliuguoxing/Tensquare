package com.tensquare.friend.service;

/**
 * @ClassName: FriendService
 * @Author: Samele LGX
 * @CreateTime: 2020-08-01 09:29
 * @Description: 交友业务层
 */
public interface FriendService {

    /**
     * 向喜欢列表中添加记录
     * @param userid
     * @param friendid
     * @return
     */
    public int addFriend(String userid,String friendid);

    /**
     * 向不喜欢列表中添加记录
     * @param userid
     * @param friendid
     */
    public void addNoFriend(String userid,String friendid);

    /**
     * 删除好友
     *
     * @param userid
     * @param friendid
     */
    public void deleteFriend(String userid,String friendid);
}
