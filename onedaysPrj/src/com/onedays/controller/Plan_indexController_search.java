package com.onedays.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onedays.service.PlanServiceImpl;
import com.onedays.vo.PlanDto;


@WebServlet("/plan_index_search.do")
public class Plan_indexController_search extends HttpServlet {
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
		PrintWriter out = response.getWriter();
		String sid = (String)session.getAttribute("user_id");
		System.out.println("sid:" + sid);
		String action = request.getPathInfo();
		PlanServiceImpl service = PlanServiceImpl.getInstance();
		String nextPage = null;
		/*날짜얻어오기*/
		String s_year = request.getParameter("year");
		String s_month = request.getParameter("month");
		request.setAttribute("year",s_year);
		request.setAttribute("month",s_month);
		System.out.println(s_year);
		System.out.println(s_month);
		String s_date=null;//
		
		 if(s_month.length() == 1) {
			 s_date = s_year+"-0"+s_month;
			 }else {//
			 s_date = s_year+"-"+s_month;// 
			 }
		 request.setAttribute("s_date",s_date);		
		 
		if(s_year != null && s_month != null) {/*아이디와 날짜에 맞는 목록창으로 정보 전달*/
			List<PlanDto> p_dto = service.searchDate(sid,s_date);//
			for(PlanDto p : p_dto) {
				System.out.println(p.getWork_start());
				System.out.println(p.getWork_end());
				System.out.println(p.getPlanDate());
				System.out.println(p.getId());		
			}
			request.setAttribute("p_dto",p_dto);//		
			nextPage="plan_index.jsp";
		}else {
			nextPage="plan_index_search.jsp";
		}
		
		
		/*dto 정보담아 넘겨서 index.jsp에서 호출하게하기*/
		
		RequestDispatcher dispatch = request.getRequestDispatcher(url+nextPage);
	    dispatch.forward(request, response);
		
			
			
		
		

				
		}
	}




