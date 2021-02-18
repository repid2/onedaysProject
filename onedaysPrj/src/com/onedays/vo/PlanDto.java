package com.onedays.vo;

public class PlanDto {
	
	//테이블 이름 MyWork
	private String id; //사용자아이디
	private String work_start; //할일
	private int work_end; //완료한 할일(1,2)
	private String planDate; // 날짜
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWork_start() {
		return work_start;
	}
	public void setWork_start(String work_start) {
		this.work_start = work_start;
	}
	public int getWork_end() {
		return work_end;
	}
	public void setWork_end(int work_end) {
		this.work_end = work_end;
	}
	public String getPlanDate() {
		return planDate;
	}
	public void setPlanDate(String planDate) {
		this.planDate = planDate;
	}
	


	
	
		
	
}
