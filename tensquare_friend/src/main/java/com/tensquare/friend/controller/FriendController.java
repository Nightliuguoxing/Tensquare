package com.tensquare.friend.controller;

import com.tensquare.common.entity.Result;
import com.tensquare.common.entity.StatusCode;
import com.tensquare.friend.service.FriendService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: FriendController
 * @Author: Samele LGX
 * @CreateTime: 2020-08-01 09:36
 * @Description: 交友控制层
 */
@RestController
@RequestMapping("/friend")
public class FriendController {

    @Autowired
    private FriendService friendService;

    @Autowired
    private HttpServletRequest request;

    /**
     * 添加好友
     *
     * @param friendid 对方用户ID
     * @param type     1：喜欢 0：不喜欢
     * @return
     */
    @PutMapping("/like/{friendid}/{type}")
    public Result addFriend(@PathVariable String friendid, @PathVariable String type) {
        Claims claims = (Claims) request.getAttribute("user_claims");
        if (claims == null) {
            return new Result(false, StatusCode.ACCESSERROR, "无权访问");
        }
        // 如果是喜欢
        if (type.equals("1")) {
            if (friendService.addFriend(claims.getId(), friendid) == 0) {
                return new Result(false, StatusCode.REPERROR, "已经添加此好友");
            }
        } else {
            // 不喜欢
            // 向不喜欢列表中添加记录
            friendService.addNoFriend(claims.getId(), friendid);
        }
        return new Result(true, StatusCode.OK, "操作成功");
    }

    /**
     * 删除好友
     *
     * @param friendid
     * @return
     */
    @DeleteMapping("/{friendid}")
    public Result remove(@PathVariable String friendid) {
        Claims claims = (Claims) request.getAttribute("user_claims");
        if (claims == null) {
            return new Result(false, StatusCode.ACCESSERROR, "无权访问");
        }
        friendService.deleteFriend(claims.getId(), friendid);
        return new Result(true, StatusCode.OK, "删除成功");
    }

}
