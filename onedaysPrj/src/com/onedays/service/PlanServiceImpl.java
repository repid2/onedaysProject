package com.onedays.service;

import java.util.List;

import com.onedays.dao.PlanDao;
import com.onedays.vo.PlanDto;

public class PlanServiceImpl implements PlanService{
	
	
	private PlanServiceImpl() {
		
	}
	
	private static class Holder{
		static { System.out.println("holder serviceimpl class create"); }
		private static final PlanServiceImpl instance = new PlanServiceImpl();
		
	}
	
	public static PlanServiceImpl getInstance() {
		return Holder.instance;	
	}


	@Override
	public List<PlanDto> searchDate(String id,String date) {
		return PlanDao.getInstance().searchDate(id,date);
	}



	@Override
	public List<PlanDto> searchDate_insert(String id, String date) {
		return PlanDao.getInstance().searchDate_insert(id,date);
	}


	@Override
	public void plan_del(String id, String ws, String we, String date) {
		PlanDao.getInstance().plan_del(id,ws,we,date);
		System.out.println("(서비스)삭제되었습니다.");
	}


	@Override
	public void plan_chk(String id, String ws, String we, String date) {
		PlanDao.getInstance().plan_chk(id,ws,we,date);
		System.out.println("(서비스)완료되었습니다.");	
	}


	@Override
	public void plan_set(String id,String text,String date) {
		PlanDao.getInstance().plan_set(id,text,date);
		System.out.println("(서비스)추가되었습니다.");
		
	}


	@Override
	public void plan_all_del(String id) {
		PlanDao.getInstance().plan_all_del(id);
		System.out.println(id+"님의정보가 삭제되었습니다.");
		
	}
	

	
}
