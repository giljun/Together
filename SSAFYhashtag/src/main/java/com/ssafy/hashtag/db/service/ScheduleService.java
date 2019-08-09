package com.ssafy.hashtag.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hashtag.db.dto.ScheduleDto;

import java.util.List;

import com.ssafy.hashtag.db.dao.ScheduleDao;

@Service
public class ScheduleService {

  @Autowired
  private ScheduleDao scheduledao;

  public void Add_schedule(ScheduleDto scheduledto) throws Exception {
    System.out.println("****************add ScheduleService**********************");

    scheduledao.Add_schedule(scheduledto);
  }

  public List<ScheduleDto> allSchedule(int user_pk) throws Exception {
    System.out.println("****************all ScheduleService**********************");

    return scheduledao.allSchedule(user_pk);
  }

  public void Delete_schedule(int schedule_pk) throws Exception {
    System.out.println("****************delete ScheduleService**********************");

    scheduledao.Delete_schedule(schedule_pk);
  }
}