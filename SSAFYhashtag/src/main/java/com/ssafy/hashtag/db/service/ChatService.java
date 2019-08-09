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

  public void Delete(int chat_pk) throws Exception {
    System.out.println("****************** delete chatservice **********************");

    chatdao.Delete(chat_pk);
  }
}