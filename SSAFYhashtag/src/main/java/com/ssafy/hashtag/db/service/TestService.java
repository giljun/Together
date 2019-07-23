package com.ssafy.hashtag.db.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.ssafy.hashtag.db.dto.Test;
import com.ssafy.hashtag.db.dao.TestDao;
 
@Service
public class TestService {
 
    @Autowired
    private TestDao testdao;
    
    public List<Test> Getall() throws Exception{
        System.out.println("****************Getall**********************");
        
        return testdao.Getall();
    }

    // public Test get(int n) throws Exception{
    //     return testMapper.get(n);
    // }
    // public void add() throws Exception {
    // 	testMapper.add();
    // }
}
