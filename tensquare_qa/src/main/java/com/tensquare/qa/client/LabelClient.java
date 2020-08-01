package com.tensquare.qa.client;

import com.tensquare.common.entity.Result;
import com.tensquare.qa.client.Impl.LabelClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName: LabelClient
 * @Author: Samele LGX
 * @CreateTime: 2020-08-01 08:16
 * @Description: 标签服务调用
 */
@FeignClient(value = "tensquare-base", fallback = LabelClientImpl.class)
public interface LabelClient {

    @RequestMapping(value="/label/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable("id") String id);

}
