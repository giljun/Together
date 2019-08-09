package com.ssafy.hashtag.db.dto;

public class ChatDto {
	private int chatroom_pk;
	private String title;
	private int user_id;
	private String created_at;
	
	public ChatDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChatDto(int chatroom_pk, String title, int user_id, String created_at) {
		super();
		this.chatroom_pk = chatroom_pk;
		this.title = title;
		this.user_id = user_id;
		this.created_at = created_at;
	}

	public int getChatroom_pk() {
		return chatroom_pk;
	}

	public void setChatroom_pk(int chatroom_pk) {
		this.chatroom_pk = chatroom_pk;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return "ChatDto [chatroom_pk=" + chatroom_pk + ", title=" + title + ", user_id=" + user_id + ", created_at="
				+ created_at + "]";
	}
}