package com.ssafy.hashtag.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hashtag.db.dao.ChatDao;
import com.ssafy.hashtag.db.dto.ChatDto;

@Service
public class ChatService {

  @Autowired
  private ChatDao chatdao;

  public void Create(ChatDto chatdto) throws Exception {
    System.out.println("****************** create chatservice **********************");
    chatdao.Create(chatdto);
  }

  public void Delete(ChatDto chatdto) throws Exception {
    System.out.println("****************** delete chatservice **********************");
    chatdao.Delete(chatdto);
  }

  public void Inroom(ChatDto chatdto) throws Exception {
    System.out.println("****************** Inroom chatservice **********************");
    chatdao.Inroom(chatdto);
  }

  public void Outroom(ChatDto chatdto) throws Exception {
    System.out.println("****************** Outroom chatservice **********************");
    chatdao.Outroom(chatdto);
  }
}