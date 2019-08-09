package com.ssafy.hashtag.db.controller;

import com.ssafy.hashtag.db.dto.ChatDto;
import com.ssafy.hashtag.db.service.ChatService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;



@CrossOrigin(origins = { "*" }, maxAge = 6000)
@Controller
@RequestMapping("/api/chat")
@Api(value = "SSAFY", description = "Chatting Resouces Management 2019")
public class ChatController {
  public static final Logger logger = LoggerFactory.getLogger(ChatController.class);

  @Autowired
  private ChatService chatservice;

  // 채팅방 create
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public void Create(@RequestBody ChatDto chatdto) throws Exception {
    logger.info("\n****************create ChatController**********************");
    chatservice.Create(chatdto);
  }
  
  // opener가 채팅방 삭제
  @RequestMapping(value = "/{chat_pk}/delete/{user_pk}", method = RequestMethod.POST)
  public void Delete(@PathVariable int chat_pk, @PathVariable int user_pk) throws Exception {
    logger.info("\n****************delete ChatController**********************");
    ChatDto chat = new ChatDto();
    chat.setOpener_id(user_pk);
    chat.setChat_pk(chat_pk);
    chatservice.Delete(chat);
  }

  // // 채팅방에 user가 입장
  // @RequestMapping(value = "/{chat_pk}/inuser/{user_pk}", method = RequestMethod.POST)
  // public void Inroom(@RequestBody ChatDto chatdto)throws Exception {
  //   logger.info("\n****************inroom ChatController**********************");
  //   chatservice.Inroom(chatdto);
  // }

  // // 채팅방에 user가 퇴장
  // @RequestMapping(value = "/{chat_pk}/outuser/{user_pk}", method = RequestMethod.POST)
  // public void Outroom(@RequestBody ChatDto chatdto)throws Exception {
  //   logger.info("\n****************outroom ChatController**********************");
  //   chatservice.Outroom(chatdto);
  // }

}