package com.ssafy.hashtag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
@Controller
public class CommonController {
 
    @RequestMapping("/demo")
    public @ResponseBody String demo_test() throws Exception{
        return "Hello demo(/demo)";
    }
}
