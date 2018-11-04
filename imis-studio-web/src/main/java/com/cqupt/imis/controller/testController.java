package com.cqupt.imis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhoujun on 2018/7/22.
 */

@Controller
public class testController {

    @RequestMapping("/index")
    public String index(){
        return "/index";
    }
}
