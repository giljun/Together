package com.ssafy.hashtag.db.dao;

import java.util.List;

import com.ssafy.hashtag.db.dto.ChatDto;
import com.ssafy.hashtag.db.dto.ChatroomDto;
import com.ssafy.hashtag.db.mapper.ChatMapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ChatDao implements ChatMapper {
  
  String ns = "com.ssafy.hashtag.db.";

  @Autowired
  private SqlSession sqlSession;

  @Override
  public void Create(ChatDto chatdto) throws Exception {
    System.out.println("****************** create chatdao **********************");
    sqlSession.insert(ns + "create", chatdto);
  }

  @Override
  public void Delete(ChatDto chatdto) throws Exception {
    System.out.println("****************** delete chatdao **********************");
    sqlSession.delete(ns + "delete", chatdto);
  }

  @Override
  public List<ChatDto> Locate_chat(String locate) throws Exception {
    System.out.println("****************** Locate chatdao **********************");
    return sqlSession.selectList(ns + "locate", locate);
  }

  @Override
  public void Enter(ChatroomDto chatroomdto) throws Exception {
    System.out.println("****************** Enter chatdao **********************");
    sqlSession.insert(ns + "enter", chatroomdto);
  }

  @Override
  public void Leave(ChatroomDto chatroomdto) throws Exception {
    System.out.println("****************** Leave chatdao **********************");
    sqlSession.delete(ns + "leave", chatroomdto);
  }

  public String Check(int chat_pk) throws Exception {
    System.out.println("****************** Check chatdao **********************");
    return sqlSession.selectOne(ns + "check_chat", chat_pk);
  }
  public String Check_user(int user_pk) throws Exception {
    System.out.println("****************** Check_user chatdao **********************");
    return sqlSession.selectOne(ns + "check_user", user_pk);
  }

  public List<Integer> Chat_user(int chat_pk) throws Exception {
    System.out.println("****************** Chat_user chatdao **********************");
    return sqlSession.selectList(ns + "chat_user", chat_pk);
  }
}
