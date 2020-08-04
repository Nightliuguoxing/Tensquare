package com.tensquare.crawler.pipeline;

import com.tensquare.common.util.DownloadUtil;
import com.tensquare.common.util.IdWorker;
import com.tensquare.user.dao.UserDao;
import com.tensquare.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.io.IOException;

/**
 * @ClassName: UserPipeline
 * @Author: Samele LGX
 * @CreateTime: 2020-08-03 22:24
 * @Description: 用户入库类
 */
@Component
public class UserPipeline implements Pipeline {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private UserDao userDao;

    @Override
    public void process(ResultItems resultItems, Task task) {
        User user=new User();
        user.setId(idWorker.nextId()+"");
        user.setNickname(resultItems.get("nickname"));
        // 图片地址
        String image = resultItems.get("image");
        String fileName = image.substring(image.lastIndexOf("/")+1);
        user.setAvatar(fileName);
        userDao.save(user);
        // 下载图片
        try {
            DownloadUtil.download(image,fileName,"e:/userimg");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
