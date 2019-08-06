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
    logger.info("****************PostDao AreaCode**********************");

    List<PostDto> posts = sqlSession.selectList(ns + "Areacode" , areacode);
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
    sqlSession.insert(ns + "create_score", scoredto);
  }

  @Override
  public void Update_Score(ScoreDto scoredto) throws Exception {
    logger.info("****************Update_score PostDao**********************");
    sqlSession.update(ns + "update_score", scoredto);
  }

  @Override
  public void Delete_score(int score_pk) throws Exception {
    logger.info("****************Delete_score PostDao**********************");
    sqlSession.delete(ns + "delete_score", score_pk);
  }

}
