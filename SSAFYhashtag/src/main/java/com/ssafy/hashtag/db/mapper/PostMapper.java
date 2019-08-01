package com.ssafy.hashtag.db.mapper;
 
import java.util.List;
import com.ssafy.hashtag.db.dto.PostDto;
import com.ssafy.hashtag.db.dto.ScoreDto;

public interface PostMapper {
 
    // public List<Test> Getall() throws Exception;
    public void addlocationBasedList(PostDto postdto) throws Exception;
    public List<PostDto> Areacode(int areacode) throws Exception;
    public List<ScoreDto> allScore(int post_pk) throws Exception;
    public void Create_Score(ScoreDto scoredto) throws Exception;
}