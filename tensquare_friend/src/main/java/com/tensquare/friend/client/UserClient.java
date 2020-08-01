package com.tensquare.friend.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName: UserClient
 * @Author: Samele LGX
 * @CreateTime: 2020-08-01 10:32
 * @Description: 调用用户微服务
 */
@FeignClient("tensquare-user")
public interface UserClient {

    /**
     * 增加粉丝数
     *
     * @param userid
     * @param x
     */
    @RequestMapping(value = "/user/incfans/{userid}/{x}", method = RequestMethod.POST)
    public void incFanscount(@PathVariable("userid") String userid, @PathVariable("x") int x);

    /**
     * 增加关注数
     *
     * @param userid
     * @param x
     */
    @RequestMapping(value = "/user/incfollow/{userid}/{x}", method = RequestMethod.POST)
    public void incFollowcount(@PathVariable("userid") String userid, @PathVariable("x") int x);

}
