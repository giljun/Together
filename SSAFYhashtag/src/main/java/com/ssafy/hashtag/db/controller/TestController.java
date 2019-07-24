package com.ssafy.hashtag.db.controller;
 
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;

import com.ssafy.hashtag.db.dto.PostDto;
import com.ssafy.hashtag.db.service.TestService;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@Controller
@RequestMapping("/api")
@Api(value="SSAFY", description="Board Resouces Management 2019")
public class TestController { 
    public static final Logger logger = 
        LoggerFactory.getLogger(TestController.class);

    String ns = "com.ssafy.hashtag.db.";
    
    @Autowired
    private TestService testservice;
    
    // @RequestMapping(value = "/Getall", method = RequestMethod.GET)
    // public ResponseEntity<List<Test>> Getall() throws Exception {
    //     logger.info("****************TestController**********************");
    //     List<Test> tests = testservice.Getall();

    //     return new ResponseEntity<List<Test>>(tests, HttpStatus.OK);
    // }

    @RequestMapping(value = "/addlocationBasedList", method = RequestMethod.POST)
    public void addlocationBasedList() throws Exception {
        logger.info("\n****************add TestController**********************");
        testservice.locationBasedList();
    }
    

}
