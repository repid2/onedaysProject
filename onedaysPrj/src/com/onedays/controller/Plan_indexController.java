package com.onedays.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onedays.service.MemberServiceImpl;
import com.onedays.service.PlanServiceImpl;
import com.onedays.vo.PlanDto;


@WebServlet("/plan_index.do")
public class Plan_indexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
		
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
		
		
		
	}
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String url ="WEB-INF/jsp/";
		HttpSession session = request.getSession();

		String sid = (String)session.getAttribute("user_id");
		System.out.println("sid:" + sid);
		String action = request.getPathInfo();
		PlanServiceImpl service = PlanServiceImpl.getInstance();
		
		
		
		/*비로그인 상태시 로그인창 이동*/
		if(sid == null) {
			url+="login.jsp";
		}else {
			url+="plan_index_search.jsp";
		}
		
			System.out.println(action);
			RequestDispatcher dispatch = request.getRequestDispatcher(url);
	        dispatch.forward(request, response);
		
			
			
		
		

				
		}
	}




