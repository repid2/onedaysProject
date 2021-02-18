package com.onedays.service;

import com.onedays.vo.MemberDto;

public interface MemberService {
	
	public int login(String id, String pwd);
	
	public String idSelect(String name, String str, int i);
	
	public String pwdSelect(String id, String str, int i);
	
	public int idChk(String id);
	
	public int nickChk(String nick);
	
	public int emailChk(String email);
	
	public int phoneChk(String phone);
	
	public MemberDto memberInfo(String id);
	
	public int memMod(MemberDto dto, String id);
	
	public int memIns(MemberDto dto);
	
	public int memDel(String id);
	
	
}
