package com.ssafy.hashtag.db.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.hashtag.db.dto.BorderDto;
import com.ssafy.hashtag.db.mapper.BorderMapper;

@Repository
public class BorderDao implements BorderMapper {
  
  public static final Logger logger = LoggerFactory.getLogger(BorderMapper.class);

  String ns = "com.ssafy.hashtag.db.";

  @Autowired
  private SqlSession sqlSession;

  @Override
  public List<BorderDto> allBorder() throws Exception {
    logger.info("**************** allBorder BorderDao **********************");
    return sqlSession.selectList(ns + "allBorder");
  }

  @Override
  public void Delete_border(int border_pk) throws Exception {
    sqlSession.delete(ns + "delete", border_pk);
  }
}