package com.onedays.service;

import java.sql.Date;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onedays.vo.CaptureDTO;


public interface CaptureSerivce{
	
	public int regist(CaptureDTO bean)throws Exception;
	
	public CaptureDTO list(Date pic_date,String id)throws Exception;
	
	public int remove(Date pic_date,String id)throws Exception;
	
	public void modify(CaptureDTO bean)throws Exception;
	
	public List<CaptureDTO> listall(String id) throws Exception;
	
	public String removepic(Date date,String id)throws Exception;

	

}
