package com.ssafy.hashtag.db.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hashtag.db.dto.BorderDto;
import com.ssafy.hashtag.db.dao.BorderDao;

@Service
public class BorderService {

  @Autowired
  private BorderDao borderdao;

  public List<BorderDto> allBorder() throws Exception {
    return borderdao.allBorder();
  }

  public void Delete_border(int border_pk) throws Exception {
    borderdao.Delete_border(border_pk);
  }
}