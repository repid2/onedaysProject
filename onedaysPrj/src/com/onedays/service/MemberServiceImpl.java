package com.onedays.service;

import com.onedays.dao.MemberDao;
import com.onedays.vo.MemberDto;

import com.onedays.service.MemberService;

public class MemberServiceImpl implements MemberService {
	
	private MemberServiceImpl() {};
	
	// 싱글톤 싱글턴 << 단 하나의 객체만 사용
	
	private static class Holder{
		static { System.out.println("holder serviceimpl class create"); }
		private static final MemberServiceImpl instance = new MemberServiceImpl();
		
	}
	
	public static MemberServiceImpl getInstance() {
		return Holder.instance;	
	}
	

	@Override
	public int login(String id, String pwd) {	// 로그인 메서드
		return MemberDao.getInstance().login(id, pwd);	// 1
	}


	@Override
	public String idSelect(String name, String str, int i) {
		return MemberDao.getInstance().idSelect(name, str, i);
	}


	@Override
	public String pwdSelect( String id, String str, int i) {
		return MemberDao.getInstance().pwdSelect(id ,str,i);
	}

	@Override
	public int idChk(String id) {
		return MemberDao.getInstance().idChk(id);
	}
	
	@Override
	public int nickChk(String nick) {
		return MemberDao.getInstance().nickChk(nick);
	}
	
	@Override
	public int emailChk(String email) {
		return MemberDao.getInstance().emailChk(email);
	}
	
	@Override
	public int phoneChk(String phone) {
		return MemberDao.getInstance().phoneChk(phone);
	}
	
	@Override
	public MemberDto memberInfo(String id) {
		return MemberDao.getInstance().memberInfo(id);
	}
	
	@Override
	public int memMod(MemberDto dto, String id) {
		
		return MemberDao.getInstance().memberModify(dto, id);
	}

	@Override
	public int memIns(MemberDto dto) {
		
		return MemberDao.getInstance().memberInsert(dto);
	}

	@Override
	public int memDel(String id) {
		// TODO Auto-generated method stub
		return MemberDao.getInstance().memberDelete(id);
	}










	
}
