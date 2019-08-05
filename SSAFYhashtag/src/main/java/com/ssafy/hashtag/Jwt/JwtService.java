package com.ssafy.hashtag.Jwt;

import java.util.Map;


public interface JwtService {
	<T> String create(String key, T data, String subject);
	Map<String, Object> get(String key);
	int getMemberId();
  boolean isUsable(String jwt);
}