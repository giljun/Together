package com.ssafy.hashtag.db.mapper;

import com.ssafy.hashtag.db.dto.ChatDto;

public interface ChatMapper {
  public void Create(ChatDto chatdto) throws Exception;
  public void Delete(ChatDto chatdto) throws Exception;
  public void Inroom(ChatDto chatdto) throws Exception;
  public void Outroom(ChatDto chatdto) throws Exception;
}