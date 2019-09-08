package com.cqupt.imis.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author zhoujun
 * @date 2018/7/22
 */
@Controller
@RequestMapping("/imis")
public class IndexViewController {
     @RequestMapping("/index")
     public  String index(){
          return "/index";
     }
     @RequestMapping("/regist")
     public String regist(){
          return "/regist";
     }
}
