package com.ssafy.hashtag.db.mapper;
 
import java.util.List;
import com.ssafy.hashtag.db.dto.PostDto;

public interface PostMapper {
 
    // public List<Test> Getall() throws Exception;
    public void addlocationBasedList(PostDto postdto) throws Exception;
    public List<PostDto> Areacode(int areacode) throws Exception;
}