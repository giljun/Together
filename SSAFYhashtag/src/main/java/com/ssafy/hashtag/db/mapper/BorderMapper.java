package com.ssafy.hashtag.db.mapper;

import java.util.List;

import com.ssafy.hashtag.db.dto.BorderDto;

public interface BorderMapper {
  public List<BorderDto> allBorder() throws Exception;
  public void Delete_border(int border_pk) throws Exception;
}