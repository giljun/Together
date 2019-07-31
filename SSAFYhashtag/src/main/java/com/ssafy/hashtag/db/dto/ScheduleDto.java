package com.ssafy.hashtag.db.dto;

public class ScheduleDto {
    
  private int schedule_pk;
  private int user_id;
  private int post_id;
  private String start_date;
  private String end_date;
  private String comment;
  private String created_at;
  private String updated_at;
  public ScheduleDto() {
      super();
      // TODO Auto-generated constructor stub
  }
  public ScheduleDto(int schedule_pk, int user_id, int post_id, String start_date, String end_date, String comment,
          String created_at, String updated_at) {
      super();
      this.schedule_pk = schedule_pk;
      this.user_id = user_id;
      this.post_id = post_id;
      this.start_date = start_date;
      this.end_date = end_date;
      this.comment = comment;
      this.created_at = created_at;
      this.updated_at = updated_at;
  }
  public int getSchedule_pk() {
      return schedule_pk;
  }
  public void setSchedule_pk(int schedule_pk) {
      this.schedule_pk = schedule_pk;
  }
  public int getUser_id() {
      return user_id;
  }
  public void setUser_id(int user_id) {
      this.user_id = user_id;
  }
  public int getPost_id() {
      return post_id;
  }
  public void setPost_id(int post_id) {
      this.post_id = post_id;
  }
  public String getStart_date() {
      return start_date;
  }
  public void setStart_date(String start_date) {
      this.start_date = start_date;
  }
  public String getEnd_date() {
      return end_date;
  }
  public void setEnd_date(String end_date) {
      this.end_date = end_date;
  }
  public String getComment() {
      return comment;
  }
  public void setComment(String comment) {
      this.comment = comment;
  }
  public String getCreated_at() {
      return created_at;
  }
  public void setCreated_at(String created_at) {
      this.created_at = created_at;
  }
  public String getUpdated_at() {
      return updated_at;
  }
  public void setUpdated_at(String updated_at) {
      this.updated_at = updated_at;
  }
  @Override
  public String toString() {
      return "ScheduleDto [schedule_pk=" + schedule_pk + ", user_id=" + user_id + ", post_id=" + post_id
              + ", start_date=" + start_date + ", end_date=" + end_date + ", comment=" + comment + ", created_at="
              + created_at + ", updated_at=" + updated_at + "]";
  }
}