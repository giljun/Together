package com.ssafy.hashtag.db.controller;

import java.util.List;

import com.ssafy.hashtag.db.dto.ChatDto;
import com.ssafy.hashtag.db.dto.ChatroomDto;
import com.ssafy.hashtag.db.service.ChatService;

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
import org.springframework.web.bind.annotation.RequestParam;




@CrossOrigin(origins = { "*" }, maxAge = 6000)
@Controller
@RequestMapping("/api/chat")
@Api(value = "SSAFY", description = "Chat Resouces Management 2019")
public class ChatController {
  public static final Logger logger = LoggerFactory.getLogger(ChatController.class);

  @Autowired
  private ChatService chatservice;

  // 채팅방 create
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public ResponseEntity<String> Create(@RequestBody ChatDto chatdto) throws Exception {
    logger.info("\n****************create ChatController**********************");
    chatservice.Create(chatdto);
    return new ResponseEntity<String>("채팅방을 개설하였습니다.", HttpStatus.OK);
  }
  
  // opener가 채팅방 삭제
  @RequestMapping(value = "/{chat_pk}/delete/{user_pk}", method = RequestMethod.POST)
  public ResponseEntity<String> Delete(@PathVariable int chat_pk, @PathVariable int user_pk) throws Exception {
    logger.info("\n****************delete ChatController**********************");
    ChatDto chat = new ChatDto();
    chat.setOpener_id(user_pk);
    chat.setChat_pk(chat_pk);
    chatservice.Delete(chat);
    return new ResponseEntity<String> ("채팅방을 삭제했습니다.", HttpStatus.OK);
  }

  // location에 따라 채팅방 조회
  @RequestMapping(value="/locate/{location}", method = RequestMethod.GET)
  public ResponseEntity<List<ChatDto>> Locate_chat(@PathVariable String location) throws Exception {
    logger.info("\n****************Locate_chat ChatController**********************");
    System.out.println(location);
    List<ChatDto> chatrooms = chatservice.Locate_chat(location);
    return new ResponseEntity<List<ChatDto>>(chatrooms, HttpStatus.OK);
  }

  // 채팅방에 user가 입장
  @RequestMapping(value = "/{chat_pk}/enter/{user_pk}", method = RequestMethod.POST)
  public ResponseEntity<String> Enter(@RequestBody ChatroomDto chatroomdto)throws Exception {
    logger.info("\n****************enter ChatController**********************");
    String message = "";
    int cnt = chatservice.Enter(chatroomdto);
    if(cnt == 0) {
      message = "채팅방에 참여하셨습니다.";
    } else {
      message = "채팅방에 입장할 수 없습니다.";
    }
    System.out.println(message);
    return new ResponseEntity<String>(message, HttpStatus.OK);
  }

  // 채팅방에 user가 퇴장
  @RequestMapping(value = "/{chat_pk}/leave/{user_pk}", method = RequestMethod.POST)
  public ResponseEntity<String> Leave(@RequestBody ChatroomDto chatroomdto)throws Exception {
    logger.info("\n**************** Leave ChatController **********************");
    chatservice.Leave(chatroomdto);
    System.out.println("채팅방을 나갔습니다.");
    return new ResponseEntity<String> ("채팅방을 나갔습니다.", HttpStatus.OK);
  }

  // 채팅방에 참여한 user
  @RequestMapping(value="/{chat_pk}", method=RequestMethod.GET)
  public ResponseEntity<List<Integer>> Chat_user(@PathVariable int chat_pk) throws Exception {
    logger.info("\n**************** Chat_user ChatController **********************");
    List<Integer> users = chatservice.Chat_user(chat_pk);
    System.out.println(users.toString());
    return new ResponseEntity<List<Integer>> (users, HttpStatus.OK);
  }
}