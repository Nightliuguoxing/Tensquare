package com.tensquare.ai.controller;

import com.tensquare.ai.service.CnnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName: AiController
 * @Author: Samele LGX
 * @CreateTime: 2020-08-04 17:38
 * @Description: 智能控制层
 */
@RestController
@RequestMapping("/ai")
public class AiController {

    @Autowired
    private CnnService cnnService;

    @PostMapping("/textclassify")
    public Map textClassify( @RequestBody Map<String,String> content){
        return cnnService.textClassify(content.get("content"));
    }
}
