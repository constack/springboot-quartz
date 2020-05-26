package com.example.quartz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xh.zhang
 * @description
 * @date 2020-05-26 10:50
 */
@Controller
@RequestMapping
public class IndexController {


    @RequestMapping(value = {"/",""})
    public String index(){
        return "httpJob.html";
    }

}
