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
@WebServlet("/plan_insert_search.do")
public class Plan_insertController_search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Plan_insertController_search() {
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

		String sid = (String)session.getAttribute("user_id");
		System.out.println("sid:" + sid);
		PlanServiceImpl service = PlanServiceImpl.getInstance();
		String insert_date = request.getParameter("search_date");
		System.out.println(insert_date);
		request.setAttribute("insert_date",insert_date);
		if(insert_date != null) {
			List<PlanDto> p_dto = service.searchDate_insert(sid, insert_date);
			for(PlanDto p : p_dto) {
				System.out.println(p.getWork_start());
				System.out.println(p.getWork_end());
				System.out.println(p.getPlanDate());
				System.out.println(p.getId());		
			}
			request.setAttribute("p_dto",p_dto);
			url+="plan_insert.jsp";
		}
		
		
			RequestDispatcher dispatch = request.getRequestDispatcher(url);
	        dispatch.forward(request, response);

				
		
	}
}
