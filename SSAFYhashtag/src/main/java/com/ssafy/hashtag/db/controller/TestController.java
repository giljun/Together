package com.ssafy.hashtag.db.controller;
 
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.ssafy.hashtag.db.dto.Test;
import com.ssafy.hashtag.db.service.TestService;

@Controller
public class TestController { 
	public static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
    @Autowired
    TestService testService;
    
    @RequestMapping("/query")
    public @ResponseBody List<Test> query() throws Exception{
    	logger.info("getall12345");
        return testService.getAll();
    }
    
    @RequestMapping("/add")
    public @ResponseBody void add() throws Exception {
    	logger.info("getadd123456");
    	testService.add();
    }
    
    
}
