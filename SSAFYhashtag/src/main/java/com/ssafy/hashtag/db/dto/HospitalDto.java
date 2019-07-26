package com.ssafy.hashtag.db.dto;

import java.awt.Point;

public class HospitalDto {
	/*
	 * clCdNm : 종별코드명
	 * sidoCdNm : 시도명
	 * sgguCdNm : 시군구명
	 * emdongNm : 읍면동명
	 * postNo : 우편번호
	 * addr : 주소
	 * telno : 전화번호
	 * XPos : x좌표
	 * YPos : y좌표
	 */
	private String clCdNm;
	private String sidoCdNm; 
	private String sgguCdNm;
	private String emdongNm;
	private String postNo;
	private String addr;
	private String telno;
	private double XPos;
	private double YPos;
	
	public HospitalDto(String clCdNm, String sidoCdNm, String sgguCdNm, String emdongNm, String postNo, String addr,
			String telno, double xPos, double yPos) {
		super();
		this.clCdNm = clCdNm;
		this.sidoCdNm = sidoCdNm;
		this.sgguCdNm = sgguCdNm;
		this.emdongNm = emdongNm;
		this.postNo = postNo;
		this.addr = addr;
		this.telno = telno;
		XPos = xPos;
		YPos = yPos;
	}

	public HospitalDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "HospitalDto [clCdNm=" + clCdNm + ", sidoCdNm=" + sidoCdNm + ", sgguCdNm=" + sgguCdNm + ", emdongNm="
				+ emdongNm + ", postNo=" + postNo + ", addr=" + addr + ", telno=" + telno + ", XPos=" + XPos + ", YPos="
				+ YPos + "]";
	}

	public String getClCdNm() {
		return clCdNm;
	}

	public void setClCdNm(String clCdNm) {
		this.clCdNm = clCdNm;
	}

	public String getSidoCdNm() {
		return sidoCdNm;
	}

	public void setSidoCdNm(String sidoCdNm) {
		this.sidoCdNm = sidoCdNm;
	}

	public String getSgguCdNm() {
		return sgguCdNm;
	}

	public void setSgguCdNm(String sgguCdNm) {
		this.sgguCdNm = sgguCdNm;
	}

	public String getEmdongNm() {
		return emdongNm;
	}

	public void setEmdongNm(String emdongNm) {
		this.emdongNm = emdongNm;
	}

	public String getPostNo() {
		return postNo;
	}

	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public double getXPos() {
		return XPos;
	}

	public void setXPos(double xPos) {
		XPos = xPos;
	}

	public double getYPos() {
		return YPos;
	}

	public void setYPos(double yPos) {
		YPos = yPos;
	}
	
}
