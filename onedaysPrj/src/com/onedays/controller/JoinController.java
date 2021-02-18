package com.onedays.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onedays.service.MemberServiceImpl;
import com.onedays.vo.MemberDto;

/**
 * Servlet implementation class JoinController
 */
@WebServlet("/join.do")	// 회원가입, 아이디, 비밀번호 찾기 
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url ="WEB-INF/jsp/";
		// request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		// 아이디 비교 안할 경우 
		int res = 2;
		int res2 = 2;
		int res3 = 2;
		int res4 = 2;
		
		MemberServiceImpl m =  MemberServiceImpl.getInstance();
		PrintWriter out = response.getWriter();
		
		if(request.getParameter("overlap") != null ) {
			
			if(request.getParameter("join_user_id") != null) {
				res = m.idChk(request.getParameter("join_user_id"));
				System.out.println("결과 : "+res);
				
				if(res == 0) {
					out.print("ok");
				}
			}else if(request.getParameter("join_user_nick") != null) {
				res2 = m.nickChk(request.getParameter("join_user_nick"));
				
				if(res2 == 0) {
					out.print("ok");
				}
				
			}else if(request.getParameter("join_user_email") != null) {
				res3 = m.emailChk(request.getParameter("join_user_email"));
				
				if(res3 == 0) {
					out.print("ok");
				}
			}else if(request.getParameter("join_user_phone") != null) {
				res4 = m.phoneChk(request.getParameter("join_user_phone"));
				
				if(res4 == 0) {
					out.print("ok");
				}
			}
		
			
			
			
		}else if(request.getParameter("join_chk") == null
				&& ((String)session.getAttribute("id")) == null) {
			
			// 아이디 또는 비밀번호 찾기 여부 확인
			// if(request.getParameter("mem_search") == null) {
				url += "memjoin.jsp";
				System.out.println("회원가입 이동");
						
			//}
			
		}else {
			System.out.println("회원가입 입력");
			Calendar cal = Calendar.getInstance();
			String year = String.valueOf(cal.get(Calendar.YEAR));
			String month = String.valueOf(cal.get(Calendar.MONTH)+1);
			String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
			
			if(month.length() == 1) {
				month = "0"+month;
			}
			
			String join_date = year + month + day;
			
			MemberDto dto = new MemberDto();
			dto.setId(request.getParameter("user_id"));
			dto.setPwd(request.getParameter("user_pwd"));
			dto.setName(request.getParameter("user_name"));
			dto.setNickname(request.getParameter("user_nick"));
			dto.setEmail(request.getParameter("user_email"));
			dto.setPhone(request.getParameter("user_phone"));
			dto.setGender(Integer.parseInt(request.getParameter("user_gen")));
			dto.setAuth(1);
			dto.setJoin_date(join_date);
			dto.setBirth_date(request.getParameter("user_birth"));
			
			int result = m.memIns(dto);
			System.out.println("회원가입 :" + result);
			
			url += "login.jsp";
			res = 2;
			res2 = 2;
			res3 = 2;
			res4 = 2;
		}
		
		if(res == 2 && res2 == 2 && res3 == 2 && res4 == 2) {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		}
		
		
	}

}
