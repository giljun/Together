package com.ssafy.hashtag.db.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;

import com.ssafy.hashtag.db.dto.PostDto;
import com.ssafy.hashtag.db.dto.UserDto;

import com.ssafy.hashtag.db.service.PostService;
import com.ssafy.hashtag.db.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = { "*" }, maxAge = 6000)
@Controller
@RequestMapping("/api/user")
@Api(value = "SSAFY", description = "User Resouces Management 2019")
public class UserController {
    public static final Logger logger = 
        LoggerFactory.getLogger(UserController.class);

    String ns = "com.ssafy.hashtag.db.";

    @Autowired
    private UserService userservice;
    @Autowired
    private PostService postservice;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<String> Signup(@RequestBody UserDto userdto) throws Exception {
        logger.info("\n****************signup Controller**********************");
        logger.info(userdto.toString());
        String message = userservice.Signup(userdto);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

    @RequestMapping(value = "/check_name", method = RequestMethod.POST)
    public ResponseEntity<String> Check_name(@RequestBody UserDto userdto) throws Exception {
        logger.info("\n****************check_name Controller**********************");
        String message = userservice.Check_name(userdto);
        System.out.println(message);

        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

    @RequestMapping(value = "/check_email", method = RequestMethod.POST)
    public ResponseEntity<String> Check_email(@RequestBody UserDto userdto) throws Exception {
        logger.info("\n****************check_email Controller**********************");
        String message = userservice.Check_email(userdto);
        System.out.println(message);

        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<UserDto> Login(@RequestBody UserDto userdto) throws Exception {
        logger.info("\n****************login Controller**********************");
        UserDto user = userservice.Login(userdto);
        
        return new ResponseEntity<UserDto>(user, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public void Logout(@RequestBody HttpSession session) throws Exception {
        logger.info("\n****************logout Controller**********************");
        session.invalidate();
    }
    
    @RequestMapping(value = "/{user_pk}/delete", method = RequestMethod.POST)
    public ResponseEntity<String> delete_user(@RequestBody int user_pk) throws Exception {
        logger.info("\n****************user_delete Controller**********************");
        userservice.Delete_user(user_pk);
        String message = "회원탈퇴를 하셨습니다.";
        // session.invalidate();
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }
    
    @RequestMapping(value="/{user_pk}", method=RequestMethod.POST)
    public ResponseEntity<UserDto> Mypage(@PathVariable int user_pk) throws Exception {
        logger.info("\n****************mypage Controller**********************");
        
        UserDto user = userservice.Mypage(user_pk);
        return new ResponseEntity<UserDto>(user, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{user_pk}/update", method = RequestMethod.POST)
    public ResponseEntity<String> Update_user(@RequestBody UserDto userdto) throws Exception {
        logger.info("\n****************Update_user Controller**********************");
        String message = userservice.Update_user(userdto);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }
    
    // @RequestMapping(value = "/{user_pk}/follow", method = RequestMethod.POST)
    // public ResponseEntity<String> Update_user(@RequestBody UserDto userdto) throws Exception {
    //     logger.info("\n****************Update_user Controller**********************");
    //     String message = userservice.Update_user(userdto);
    //     return new ResponseEntity<String>(message, HttpStatus.OK);
    // }
}