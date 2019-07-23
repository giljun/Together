package com.ssafy.hashtag.db.mapper;
 
import java.util.List;
import com.ssafy.hashtag.db.dto.Test;
 
public interface TestMapper {
 
    public List<Test> Getall() throws Exception;
    // public Test get(int n) throws Exception;
    // public void add() throws Exception;
}