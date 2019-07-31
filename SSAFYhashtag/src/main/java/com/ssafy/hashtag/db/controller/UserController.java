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

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@Controller
@RequestMapping("/api/user")
@Api(value = "SSAFY", description = "Board Resouces Management 2019")
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
    public ResponseEntity<Boolean> Login(@RequestBody UserDto userdto, HttpSession session) throws Exception {
        logger.info("\n****************loginController**********************");
        Boolean sign = false;
        int code = userservice.Login(userdto, session);
        
        if(code == 200) {
            session.setAttribute("userdto", userdto);
            sign = true;
        }
        return new ResponseEntity<Boolean>(sign, HttpStatus.OK);
    }

    @RequestMapping(value = "/{user_pk}/update/", method = RequestMethod.POST)
    public ResponseEntity<String> Update_user(@RequestBody UserDto userdto, @PathVariable int user_pk, HttpSession session) throws Exception {
        logger.info("\n****************Update_user Controller**********************");
        String message = userservice.Update_user(userdto, session);
        session.invalidate();
        session.setAttribute("userdto", userdto);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public void Logout(@RequestBody HttpSession session) throws Exception {
        logger.info("\n****************logout Controller**********************");
        session.invalidate();
    }

    @RequestMapping(value = "/{user_pk}/delete", method = RequestMethod.POST)
    public String delete_user(int user_pk) throws Exception {
        logger.info("\n****************signup Controller**********************");
        userservice.Delete_user(user_pk);
        // session.invalidate();
        return "회원탈퇴를 하셨습니다.";
    }
}