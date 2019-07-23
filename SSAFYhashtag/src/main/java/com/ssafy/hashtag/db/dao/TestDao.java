package com.ssafy.hashtag.db.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.hashtag.db.dto.PostDto;
import com.ssafy.hashtag.db.dto.Test;
import com.ssafy.hashtag.db.mapper.TestMapper;;

@Repository
public class TestDao implements TestMapper {
  List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

  String ns = "com.ssafy.hashtag.db.";

  public static final Logger logger = LoggerFactory.getLogger(TestMapper.class);

  @Autowired
  private SqlSession sqlSession;

  @Override
  public List<Test> Getall() throws Exception {
    List<Test> tests = sqlSession.selectList(ns + "Getall");
    logger.info("**************** TestDao **********************");
    return tests;
  }

  @Override
  public void addlocationBasedList(PostDto postdto) throws Exception {
    logger.info("**************** add TestDao **********************");
    System.out.println(postdto.toString());
    sqlSession.insert(ns + "addlocationBasedList", postdto);
  }

}
