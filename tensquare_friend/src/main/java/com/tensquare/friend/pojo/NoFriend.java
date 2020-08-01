package com.tensquare.friend.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ClassName: NoFriend
 * @Author: Samele LGX
 * @CreateTime: 2020-08-01 10:08
 * @Description: 不喜欢实体类
 */
@Entity
@Table(name="tb_nofriend")
@IdClass(NoFriend.class)
public class NoFriend implements Serializable {

    @Id
    private String userid;

    @Id
    private String friendid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFriendid() {
        return friendid;
    }

    public void setFriendid(String friendid) {
        this.friendid = friendid;
    }
}

