package com.ssafy.hashtag.db.dto;

public class UserDto {
    
  private int user_pk;
  private String name;
  private String nickname;
  private String phone_number;
  private String password;
  private int grade;
  private String profile_Imgae;
  private int together;
  private String description;
  private String created_at;
  private String updated_at;

  public UserDto() {
      super();
      // TODO Auto-generated constructor stub
  }
  public UserDto(int user_pk, String name, String nickname, String phone_number, String password, int grade,
          String profile_Imgae, int together, String description, String created_at, String updated_at) {
      super();
      this.user_pk = user_pk;
      this.name = name;
      this.nickname = nickname;
      this.phone_number = phone_number;
      this.password = password;
      this.grade = grade;
      this.profile_Imgae = profile_Imgae;
      this.together = together;
      this.description = description;
      this.created_at = created_at;
      this.updated_at = updated_at;
  }
  public int getUser_pk() {
      return user_pk;
  }
  public void setUser_pk(int user_pk) {
      this.user_pk = user_pk;
  }
  public String getName() {
      return name;
  }
  public void setName(String name) {
      this.name = name;
  }
  public String getNickname() {
      return nickname;
  }
  public void setNickname(String nickname) {
      this.nickname = nickname;
  }
  public String getPhone_number() {
      return phone_number;
  }
  public void setPhone_number(String phone_number) {
      this.phone_number = phone_number;
  }
  public String getPassword() {
      return password;
  }
  public void setPassword(String password) {
      this.password = password;
  }
  public int getGrade() {
      return grade;
  }
  public void setGrade(int grade) {
      this.grade = grade;
  }
  public String getProfile_Imgae() {
      return profile_Imgae;
  }
  public void setProfile_Imgae(String profile_Imgae) {
      this.profile_Imgae = profile_Imgae;
  }
  public int getTogether() {
      return together;
  }
  public void setTogether(int together) {
      this.together = together;
  }
  public String getDescription() {
      return description;
  }
  public void setDescription(String description) {
      this.description = description;
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
      return "UserDto [user_pk=" + user_pk + ", name=" + name + ", nickname=" + nickname + ", phone_number="
              + phone_number + ", password=" + password + ", grade=" + grade + ", profile_Imgae=" + profile_Imgae
              + ", together=" + together + ", description=" + description + ", created_at=" + created_at
              + ", updated_at=" + updated_at + "]";
  }
}