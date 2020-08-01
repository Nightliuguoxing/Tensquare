package com.tensquare.friend.dao;

import com.tensquare.friend.pojo.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @ClassName: FriendDao
 * @Author: Samele LGX
 * @CreateTime: 2020-08-01 09:25
 * @Description: 交友数据访问接口层
 */
public interface FriendDao extends JpaRepository<Friend, String> {

    /**
     * 根据用户ID与被关注用户ID查询记录个数
     *
     * @param userid
     * @param friendid
     * @return
     */
    @Query("SELECT COUNT(f) FROM Friend f WHERE f.userid=?1 AND f.friendid =?2")
    public int selectCount(String userid, String friendid);

    /**
     * 更新为互相喜欢
     *
     * @param userid
     * @param friendid
     */
    @Modifying
    @Query("UPDATE Friend f SET f.islike=?3 WHERE f.userid=?1 AND f.friendid =?2")
    public void updateLike(String userid, String friendid, String islike);

    /**
     * 删除喜欢
     *
     * @param userid
     * @param friendid
     */
    @Modifying
    @Query("DELETE FROM Friend f WHERE f.userid=?1 AND f.friendid=?2")
    public void deleteFriend(String userid,String friendid);
}
