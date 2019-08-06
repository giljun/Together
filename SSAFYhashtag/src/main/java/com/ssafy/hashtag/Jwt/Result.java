package com.ssafy.hashtag.Jwt;

import org.springframework.http.HttpStatus;

public class Result {
  public static final String SUCCESS_MESSAGE = "성공";
  public static final String SERVER_ERROR_MESSAGE = "실패";

  private HttpStatus statusCode;
  private String message;
  private Object data;
  private int totalCount;
  private String token;
  
  public Result(){}
  
  public Result(HttpStatus statusCode, String message, Object data, int totalCount, String token) {
    super();
    this.statusCode = statusCode;
    this.message = message;
    this.data = data;
    this.totalCount = totalCount;
    this.token = token;
  }


  public static Result successInstance() {
    return new Result().success();
  }

  public Result success() {
    statusCode = HttpStatus.OK;
    message = SUCCESS_MESSAGE;
    return this;
  }

  public Result fail() {
    statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
    message = SERVER_ERROR_MESSAGE;
    return this;
  }

  public HttpStatus getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(HttpStatus statusCode) {
    this.statusCode = statusCode;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public int getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  @Override
  public String toString() {
    return "Result [message=" + message + ", data=" + data + ", totalCount=" + totalCount + ", token=" + token + "]";
  }
}