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

import com.onedays.service.PlanServiceImpl;
import com.onedays.vo.PlanDto;

/**
 * Servlet implementation class PlanTable
 */
@WebServlet("/plan_success.do")
public class Plan_successController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Plan_successController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
		
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
		
		
		
	}
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String url ="WEB-INF/jsp/";
		HttpSession session = request.getSession();
//		String action = request.getPathInfo();
		String sid = (String)session.getAttribute("user_id");
		System.out.println("sid:" + sid);
		

		
		RequestDispatcher dispatch = request.getRequestDispatcher(url+"plan_success_search.jsp");
        dispatch.forward(request, response);

				
		
	}
}
