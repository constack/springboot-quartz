package com.example.quartz.controller;

import com.alibaba.fastjson.JSON;
import com.example.quartz.config.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xh.zhang
 * @description:调用实例参考
 * @date 2020-05-26 09:49
 */
@Controller
@RequestMapping("/test")
public class TestController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/test1")
    @ResponseBody
    public Response test(String message){
        logger.info("任务开始");
        long start=System.currentTimeMillis();
        try {
            //开始处理任务
            logger.info("收到的消息{}",message);
            //模拟任务处理时长
            Thread.sleep(5000);
            //任务处理完成
            Map<String,Object> result=new HashMap<>();
            result.put("message","成功");
            return Response.success(result);
        } catch (Exception e) {
            logger.error("执行任务出现异常",e);
            return Response.error(e.getMessage());
        }finally {
            logger.info("任务结束，耗时{}秒",(System.currentTimeMillis()-start)/1000);
        }
    }
}
