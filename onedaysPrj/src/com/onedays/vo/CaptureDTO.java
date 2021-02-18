package com.onedays.vo;

import java.sql.Date;

public class CaptureDTO {
	private int pic_no;
	private int bca_no;
	private String id;
	private String pic_title;
	private String pic_content;
	private Date pic_date;
	private String pic_path;

	public CaptureDTO() {
		// TODO Auto-generated constructor stub
	}

	public CaptureDTO(String pic_title, String pic_content, String pic_path) {
		this.pic_title = pic_title;
		this.pic_content = pic_content;
		this.pic_path = pic_path;
	}


	public CaptureDTO(String pic_title, String pic_content, String pic_path, Date date) {
		this.pic_title = pic_title;
		this.pic_content = pic_content;
		this.pic_path = pic_path;
		this.pic_date=date;
	}

	public String getPic_path() {
		return pic_path;
	}


	public void setPic_path(String pic_path) {
		this.pic_path = pic_path;
	}


	public Date getPic_date() {
		return pic_date;
	}


	public void setPic_date(Date pic_date) {
		this.pic_date = pic_date;
	}


	public int getPic_no() {
		return pic_no;
	}


	public void setPic_no(int pic_no) {
		this.pic_no = pic_no;
	}


	public int getBca_no() {
		return bca_no;
	}


	public void setBca_no(int bca_no) {
		this.bca_no = bca_no;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPic_title() {
		return pic_title;
	}


	public void setPic_title(String pic_title) {
		this.pic_title = pic_title;
	}


	public String getPic_content() {
		return pic_content;
	}


	public void setPic_content(String pic_content) {
		this.pic_content = pic_content;
	}
}
