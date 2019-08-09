package com.ssafy.hashtag.db.dao;

import com.ssafy.hashtag.db.dto.ChatDto;
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
  public void Inroom(ChatDto chatdto) throws Exception {
    System.out.println("****************** Inroom chatdao **********************");
    sqlSession.insert(ns + "inroom", chatdto);
  }

  @Override
  public void Outroom(ChatDto chatdto) throws Exception {
    System.out.println("****************** Outroom chatdao **********************");
    sqlSession.insert(ns + "outroom", chatdto);
  }
}
