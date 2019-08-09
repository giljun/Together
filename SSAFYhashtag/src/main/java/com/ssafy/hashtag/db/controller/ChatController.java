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

  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public void Create(@RequestBody ChatDto chatdto) throws Exception {
    logger.info("\n****************create ChatController**********************");
    chatservice.Create(chatdto);
  }

  // @RequestMapping(value = "/")

  @RequestMapping(value = "/{chat_pk}/delete", method = RequestMethod.POST)
  public void Delete(@PathVariable int chat_pk) throws Exception {
    logger.info("\n****************delete ChatController**********************");
    chatservice.Delete(chat_pk);
  }
}