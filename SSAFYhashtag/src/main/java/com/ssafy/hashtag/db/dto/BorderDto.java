package com.ssafy.hashtag.db.dto;

public class BorderDto {
	private int notice_pk;
	private String title;
	private String content;
	private String name;
	private int hits;
  private String created_at;
  
	public BorderDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BorderDto(int notice_pk, String title, String content, String name, int hits, String created_at) {
		super();
		this.notice_pk = notice_pk;
		this.title = title;
		this.content = content;
		this.name = name;
    this.hits = hits;
    this.created_at = created_at;
	}
	
	public int getNotice_pk() {
		return notice_pk;
	}
	public void setNotice_pk(int notice_pk) {
		this.notice_pk = notice_pk;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}

	public void setCreated_at(String created_at) {
    this.created_at = created_at;
  }

  public String getCreated_at() {
    return created_at;
  }

	@Override
	public String toString() {
		return "BorderDto [notice_pk=" + notice_pk + ", title=" + title + ", content=" + content + ", name=" + name
				+ ", hits=" + hits + ", created_at=" + created_at + "]";
	}
}