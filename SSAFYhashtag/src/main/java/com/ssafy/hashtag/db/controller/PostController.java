package com.ssafy.hashtag.db.controller;
 
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;

import com.ssafy.hashtag.db.dto.CommentDto;
import com.ssafy.hashtag.db.dto.PostDto;
import com.ssafy.hashtag.db.dto.ScoreDto;
import com.ssafy.hashtag.db.service.PostService;
import org.springframework.web.bind.annotation.RequestParam;



@CrossOrigin(origins = {"*"}, maxAge = 6000)
@Controller
@RequestMapping("/api/post")
@Api(value="SSAFY", description="Post Resouces Management 2019")
public class PostController { 
    public static final Logger logger = 
        LoggerFactory.getLogger(PostController.class);

    
    @Autowired
    private PostService postservice;
    

    @RequestMapping(value = "/addlocationBasedList", method = RequestMethod.POST)
    public void addlocationBasedList() throws Exception {
        logger.info("\n****************add Controller**********************");
        postservice.locationBasedList();
    }
    
    @RequestMapping(value = "/areacode/{areacode}", method = RequestMethod.GET)
    public ResponseEntity<List<PostDto>> Areacode(@PathVariable int areacode) throws Exception {
        logger.info("****************AreaCode Controller**********************");
        List<PostDto> posts = postservice.Areacode(areacode);
        
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
    }


    // Score CRUD
    @RequestMapping(value = "/{post_pk}/score", method = RequestMethod.GET)
    public ResponseEntity<List<ScoreDto>> allScore(@PathVariable int post_pk) throws Exception {
        logger.info("****************allComment Controller**********************");
        List<ScoreDto> scores = postservice.allScore(post_pk);
        
        return new ResponseEntity<List<ScoreDto>>(scores, HttpStatus.OK);
    }

    @RequestMapping(value = "/{post_pk}/create_score", method = RequestMethod.POST)
    public ResponseEntity<String> Create_Score(@RequestBody ScoreDto scoredto, @PathVariable int post_pk) throws Exception {
        logger.info("****************create_score Controller**********************");
        postservice.Create_score(scoredto);
        String message = "평점등록 했습니다.";
        
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

    @RequestMapping(value = "/{score_pk}/update_score", method = RequestMethod.POST)
    public ResponseEntity<String> Update_score(@RequestBody ScoreDto scoredto, @PathVariable int score_pk) throws Exception {
        logger.info("****************update_score Controller**********************");
        postservice.Update_score(scoredto);
        String message = "평점을 수정했습니다.";
        
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }
 
    @RequestMapping(value = "/{score_pk}/delete_score", method = RequestMethod.GET)
    public ResponseEntity<String> Delete_score(@PathVariable int score_pk) throws Exception {
        logger.info("****************delete_score Controller**********************");
        postservice.Delete_score(score_pk);
        String message = "평점을 삭제했습니다.";
        
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }
    
    // // post에 좋아요
    // @RequestMapping(value="/{post_pk}/like", method=RequestMethod.POST)
    // public ResponseEntity<String> requestMethodName(@PathVariable int post_pk) {
    //     logger.info("****************like Controller**********************");
    //     postdao.Post_like(post_pk);

    //     return new ResponseEntity<String>();
    // }
    
}
