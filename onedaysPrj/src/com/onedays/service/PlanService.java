package com.onedays.service;

import java.util.List;

import com.onedays.vo.PlanDto;

public interface PlanService {
	public void plan_del(String id,String ws,String we,String date);
	
	public List<PlanDto> searchDate(String id,String date);
	
	public List<PlanDto> searchDate_insert(String id,String date);
	
	public void plan_chk(String id,String ws,String we,String date);

	public void plan_set(String id,String text,String date);
	
	public void plan_all_del(String id);
}
