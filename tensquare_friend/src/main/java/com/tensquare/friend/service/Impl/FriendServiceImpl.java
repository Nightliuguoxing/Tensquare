package com.tensquare.friend.service.Impl;

import com.tensquare.friend.dao.FriendDao;
import com.tensquare.friend.dao.NoFriendDao;
import com.tensquare.friend.pojo.Friend;
import com.tensquare.friend.pojo.NoFriend;
import com.tensquare.friend.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: FriendServiceImpl
 * @Author: Samele LGX
 * @CreateTime: 2020-08-01 09:31
 * @Description: 交友服务层实现
 */
@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    private FriendDao friendDao;

    @Autowired
    private NoFriendDao noFriendDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addFriend(String userid, String friendid) {
        //判断如果用户已经添加了这个好友，则不进行任何操作,返回0
        if (friendDao.selectCount(userid, friendid) > 0) {
            return 0;
        }
        // 向喜欢表中添加记录
        Friend friend = new Friend();
        friend.setUserid(userid);
        friend.setFriendid(friendid);
        friend.setIslike("0");
        friendDao.save(friend);
        // 判断对方是否喜欢你，如果喜欢，将islike设置为1
        if (friendDao.selectCount(friendid, userid) > 0) {
            friendDao.updateLike(userid, friendid, "1");
            friendDao.updateLike(friendid, userid, "1");
        }
        return 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addNoFriend(String userid, String friendid) {
        NoFriend noFriend=new NoFriend();
        noFriend.setUserid(userid);
        noFriend.setFriendid(friendid);
        noFriendDao.save(noFriend);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteFriend(String userid, String friendid) {
        friendDao.deleteFriend(userid,friendid);
        friendDao.updateLike(friendid,userid,"0");
        // 向不喜欢表中添加
        addNoFriend(userid,friendid);
    }
}
