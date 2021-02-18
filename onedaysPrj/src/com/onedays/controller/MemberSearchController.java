package com.onedays.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onedays.service.MemberServiceImpl;

/**
 * Servlet implementation class MemberSearchController
 */
@WebServlet("/search.do")
public class MemberSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String url = "WEB-INF/jsp/";
		
		MemberServiceImpl service = MemberServiceImpl.getInstance();

		// 아이디, 비밀번호 판별
		session.setAttribute("mem_search",request.getParameter("mem_search"));
		String name = "";
		String id = "";
		
		// 이름 또는 아이디 확인
		if(request.getParameter("search_user_name") != null) {
			name = request.getParameter("search_user_name");
		}else {
			id = request.getParameter("search_user_id");
		}
		
		// 아이디 또는 비밀번호 확인
		String mem_search = request.getParameter("mem_search");
		// 이메일 또는 전화번호 확인
		String mem_search_chk = request.getParameter("mem_search_chk");
		String search_target = request.getParameter("search_target");
		System.out.println(mem_search_chk);
		System.out.println(search_target);
		
		if(mem_search_chk != null && search_target != null) {
			// System.out.println("일단 찾기");
			
			if(search_target.equals("id")) {
				// System.out.println("아이디 찾기");
				if(mem_search_chk.equals("1")) {
					String email = request.getParameter("user_email");
					System.out.println(email);
					session.setAttribute("showUserId",service.idSelect(name, email, 1) );
				}else {
					String phone = request.getParameter("user_phone");
					session.setAttribute("showUserId",service.idSelect(name, phone, 2) );
					
				}
				url += "memIdShow.jsp";
			}else {
				System.out.println("비번용 아디 찾기");
				if(mem_search_chk.equals("1")) {
					String email = request.getParameter("user_email");
					session.setAttribute("showUserId",service.pwdSelect(id, email, 1) );
				}else {
					String phone = request.getParameter("user_phone");
					session.setAttribute("showUserId",service.pwdSelect(id, phone, 2) );
				}
				url += "memPwdMod.jsp";
			}
			
		}else {
		url += "memSelect.jsp";
		System.out.println("아디 또는 비번 찾기");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	
		
	}

}
