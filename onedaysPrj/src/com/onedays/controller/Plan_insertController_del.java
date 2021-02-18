package com.onedays.controller;

import java.io.IOException;
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

/**
 * Servlet implementation class PlanTable
 */
@WebServlet("/plan_insert_del.do")
public class Plan_insertController_del extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Plan_insertController_del() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);

	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "WEB-INF/jsp/";
		HttpSession session = request.getSession();
		String pd = request.getParameter("search_date");
		request.setAttribute("insert_date",pd);
		String we = request.getParameter("we");
		/* String pd = request.getParameter("pd"); */
		String chk = request.getParameter("chk");
	
		String sid = (String)session.getAttribute("user_id");
		System.out.println("sid:" + sid); 
		PlanServiceImpl service = PlanServiceImpl.getInstance();
		 
		service.plan_del(sid,chk,we,pd);
		 
	    List<PlanDto> p_dto = service.searchDate_insert(sid, pd);
	    request.setAttribute("p_dto",p_dto); url+="plan_insert.jsp";
		 
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
		 

	}
}
