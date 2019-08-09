package com.ssafy.hashtag.db.mapper;

import com.ssafy.hashtag.db.dto.ChatDto;

public interface ChatMapper {
  public void Create(ChatDto chatdto) throws Exception;
  public void Delete(int chat_pk) throws Exception;
}