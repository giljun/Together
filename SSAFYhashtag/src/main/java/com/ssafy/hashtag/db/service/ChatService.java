package com.ssafy.hashtag.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.ssafy.hashtag.db.dao.ChatDao;
import com.ssafy.hashtag.db.dto.ChatDto;
import com.ssafy.hashtag.db.dto.ChatroomDto;

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

  public List<ChatDto> Locate_chat(String locate) throws Exception {
    System.out.println("****************** Locate_chat chatservice **********************");
    return chatdao.Locate_chat(locate);
  }

  public int Enter(ChatroomDto chatroomdto) throws Exception {
    System.out.println("****************** Enter chatservice **********************");
    String check_sex = chatdao.Check(chatroomdto.getChat_id());
    String user_sex = chatdao.Check_user(chatroomdto.getUser_id());
    int cnt = 0;
    if(check_sex.equals("남/여 무관") || check_sex.equals(user_sex)) {
      cnt = 0;
      chatdao.Enter(chatroomdto);
    } else if(!check_sex.equals(user_sex)) {
      cnt = 1;
    } 
    return cnt;
  }

  public void Leave(ChatroomDto chatroomdto) throws Exception {
    System.out.println("****************** Leave chatservice **********************");
    chatdao.Leave(chatroomdto);
  }

  public List<Integer> Chat_user(int chat_pk) throws Exception {
    System.out.println("****************** Chat_user chatservice **********************");
    return chatdao.Chat_user(chat_pk);
  }
}