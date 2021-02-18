package com.onedays.service;

import java.sql.Date;
import java.util.List;

import com.onedays.dao.CaptureDAO;
import com.onedays.vo.CaptureDTO;

public class CaptureServiceImpl implements CaptureSerivce{
	private CaptureDAO dao;
	
	public CaptureServiceImpl() {
		// TODO Auto-generated constructor stub
		dao=new CaptureDAO(); //�̱��� �������� ��ü
	}
	
	@Override
	public int regist(CaptureDTO bean) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertBoard(bean);
	}
	
	@Override
	public CaptureDTO list(Date pic_date,String id) throws Exception {
		// TODO Auto-generated method stub
		
		return dao.getOneBoard(pic_date, id);
	}

	@Override
	public int remove(Date pic_date,String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.deleteBoard(pic_date, id);
	}

	@Override
	public void modify(CaptureDTO bean) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("bean test:"+bean.getPic_content());
		dao.updateBoard(bean);
	}

	@Override
	public List<CaptureDTO> listall(String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.getAllBoard(id);
	}

	@Override
	public String removepic(Date pic_date,String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.deletepic(pic_date, id);
	}

	
}
