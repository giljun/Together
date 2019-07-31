package com.ssafy.hashtag.db.mapper;
 
import java.util.List;
import com.ssafy.hashtag.db.dto.PostDto;
 
public interface TestMapper {
 
    // public List<Test> Getall() throws Exception;
    public void addlocationBasedList(PostDto postdto) throws Exception;
    public List<PostDto> AreaCode(int areacode) throws Exception;
}