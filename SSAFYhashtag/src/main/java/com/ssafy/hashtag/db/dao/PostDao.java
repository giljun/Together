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
import com.ssafy.hashtag.db.dto.ScoreDto;
import com.ssafy.hashtag.db.mapper.PostMapper;

@Repository
public class PostDao implements PostMapper {
  List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

  String ns = "com.ssafy.hashtag.db.";

  public static final Logger logger = LoggerFactory.getLogger(PostMapper.class);

  @Autowired
  private SqlSession sqlSession;

  @Override
  public void addlocationBasedList(PostDto postdto) throws Exception {
    // logger.info("**************** add TestDao **********************");
    System.out.println(postdto.toString());
    sqlSession.insert(ns + "addlocationBasedList", postdto);
  }

  @Override
  public List<PostDto> Areacode(int areacode) throws Exception {
    List<PostDto> posts = sqlSession.selectList(ns + "Areacode" , areacode);
    logger.info("****************PostDao AreaCode**********************");
    
    // System.out.println(posts.toString());
    return posts;
  }

  @Override
  public List<ScoreDto> allScore(int post_pk) throws Exception {
    logger.info("****************PostDao allScore**********************");

    List<ScoreDto> scores = sqlSession.selectList(ns + "allScore", post_pk);
    System.out.println(scores.toString());
    return scores;
  }

  @Override
  public void Create_Score(ScoreDto scoredto) throws Exception {
    logger.info("****************Create_score PostDao**********************");
    sqlSession.insert(ns + "Create_Score", scoredto);
  }
}
