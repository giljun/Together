package com.ssafy.hashtag.db.mapper;
 
import java.util.List;

import javax.servlet.http.HttpSession;
import com.ssafy.hashtag.db.dto.UserDto;

public interface UserMapper {
 
    // public List<Test> Getall() throws Exception;
    public void Signup(UserDto userdto) throws Exception;
    // public int Check_name(String name) throws Exception;
    // public int Check_email(String email) throws Exception;
    // public ConfirmMsgDto(String Confirm, String data) throws Exception;
    // public void Check_login(String email) throws Exceoption;
    public UserDto Login(UserDto userdto) throws Exception;
    public void Delete_user(int user_pk) throws Exception;
    public void Update_user(UserDto userdto) throws Exception;
    public UserDto Mypage(int user_pk) throws Exception;
  }

    
