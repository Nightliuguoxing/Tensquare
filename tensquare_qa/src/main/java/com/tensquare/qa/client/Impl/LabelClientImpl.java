package com.tensquare.qa.client.Impl;

import com.tensquare.common.entity.Result;
import com.tensquare.common.entity.StatusCode;
import com.tensquare.qa.client.LabelClient;
import org.springframework.stereotype.Component;

/**
 * @ClassName: LabelClientImpl
 * @Author: Samele LGX
 * @CreateTime: 2020-08-01 10:42
 * @Description: 标签服务调用熔断实现类
 */
@Component
public class LabelClientImpl implements LabelClient {

    @Override
    public Result findById(String id) {
        return new Result(false, StatusCode.ERROR, "熔断器启动了");
    }
}
