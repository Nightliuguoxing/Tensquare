package com.tensquare.friend.dao;

import com.tensquare.friend.pojo.NoFriend;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName: NoFriendDao
 * @Author: Samele LGX
 * @CreateTime: 2020-08-01 10:11
 * @Description: 不喜欢数据访问接口
 */
public interface NoFriendDao extends JpaRepository<NoFriend,String> {

}
