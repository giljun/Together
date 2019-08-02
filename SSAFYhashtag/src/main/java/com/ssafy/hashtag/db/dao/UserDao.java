package com.ssafy.hashtag.db.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.hashtag.db.dto.PostDto;
import com.ssafy.hashtag.db.dto.UserDto;
import com.ssafy.hashtag.db.dto.ConfirmMsgDto;

import com.ssafy.hashtag.db.mapper.UserMapper;

@Repository
public class UserDao implements UserMapper {
    public static final Logger logger = LoggerFactory.getLogger(UserMapper.class);
    
    String ns = "com.ssafy.hashtag.db.";
    
    @Autowired
    private SqlSession sqlSession;

    // 회원가입
    @Override
    public void Signup(UserDto userdto) throws Exception {
        logger.info("**************** signup UserDao **********************");
        System.out.println(userdto.toString());
        sqlSession.insert(ns + "Signup", userdto);
    }

    // 아이디 중복 검사
	public int Check_name(String nickname) throws Exception {
        logger.info("**************** check_name UserDao **********************");
		return sqlSession.selectOne(ns+ "check_name", nickname);
	}

	// 이메일 중복 검사
	public int Check_email(String email) throws Exception {
        logger.info("**************** check_email UserDao **********************");
		return sqlSession.selectOne(ns+ "check_email", email);
    }
    
    // 로그인 체크(이메일, 비밀번호가 맞는지)
    public UserDto Check_login(String email) throws Exception {
        logger.info("**************** check_login UserDao **********************");
        return sqlSession.selectOne(ns + "check_login", email);
    }

    // 로그인
    @Override
    public UserDto Login(UserDto userdto) throws Exception {
        logger.info("**************** login UserDao **********************");
        return sqlSession.selectOne(ns + "check_login", userdto);
    }

    // 회원 탈퇴 및 삭제
    @Override
    public void Delete_user(int user_pk) throws Exception {
        logger.info("**************** delete UserDao **********************");
        sqlSession.delete(ns+"delete_user", user_pk);
    }

    // 유저 개인정보 수정
    @Override
    public void Update_user(UserDto userdto) throws Exception {
        logger.info("****************udpate_user UserDao **********************");
        sqlSession.update(ns + "update_user", userdto);
    }

    @Override
    public UserDto Mypage(int user_pk) throws Exception {
        logger.info("****************mypage UserDao **********************");
        return sqlSession.selectOne(ns + "mypage", user_pk);
    }
}
