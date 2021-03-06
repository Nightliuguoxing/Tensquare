package com.tensquare.crawler.pipeline;

import com.tensquare.common.util.HTMLUtil;
import com.tensquare.common.util.IKUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * @ClassName: ArticleTxtPipeline
 * @Author: Samele LGX
 * @CreateTime: 2020-08-03 23:05
 * @Description: 文章存入文本类
 */
@Component
public class ArticleTxtPipeline implements Pipeline {

    @Value("${ai.dataPath}")
    private String dataPath;
    private String channelId;//频道ID
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    @Override
    public void process(ResultItems resultItems, Task task) {
        //获取标题
        String title = resultItems.get("title");
        //获取正文并删除html标签
        String content= HTMLUtil.delHTMLTag(resultItems.get("content"));
        try{
            //将标题+正文分词后保存到相应的文件夹
            PrintWriter printWriter=new PrintWriter(new File(dataPath+"/"+channelId+ "/"+ UUID.randomUUID()+".txt"));
            printWriter.print(IKUtil.split(title+" "+content," "));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
