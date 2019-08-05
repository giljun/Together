package com.ssafy.hashtag.Jwt;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.hashtag.db.dto.UserDto;
import com.ssafy.hashtag.db.service.UserService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/user")
public class MemberController {
 
 
    @Autowired
    private UserService userservice;

    @Autowired
    private JwtService jwtService;
     
    @RequestMapping(value="/signin", method = RequestMethod.POST)
    public ResponseEntity<Result> signin(@RequestBody UserDto userdto, HttpServletResponse response) throws Exception{
        System.out.println("**********************Signin********************");
        String email = userdto.getEmail();
        String password = userdto.getPassword();
        System.out.println(email);
        System.out.println(password);
        Result result = Result.successInstance();
        UserDto loginMember = userservice.Signin(userdto);
        String token = jwtService.create("member", loginMember, "user");
        System.out.println(token);
        response.setHeader("Authorization", token);
        result.setData(loginMember);
        result.setToken(token);
        System.out.println(result);
        return new ResponseEntity<Result> (result, HttpStatus.OK);
    }

    
}