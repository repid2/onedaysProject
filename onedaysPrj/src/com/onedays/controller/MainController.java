package com.onedays.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onedays.service.CaptureServiceImpl;
import com.onedays.service.PlanServiceImpl;
import com.onedays.vo.CaptureDTO;
import com.onedays.vo.PlanDto;

import oracle.sql.DATE;


@WebServlet("/onedays.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
    public MainController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session = request.getSession();
	//	session.invalidate();
		String sid = (String)session.getAttribute("user_id");
		System.out.println("sid:" + sid);
		PlanServiceImpl service = PlanServiceImpl.getInstance();
	    
		
	    /*메인화면에 비치하기위한 캘린더*/
		Calendar cr = Calendar.getInstance();
		int y = cr.get(Calendar.YEAR);
		int m = cr.get(Calendar.MONTH)+1;
		int d = cr.get(Calendar.DATE);
		String year = String.valueOf(y);
		String month=null;
		String date=null;
		System.out.println(year+"이거");
		String year2 = "21";
		if(m<10) {
			month ="0"+m;
		}else {
			month = String.valueOf(m);
		}
		if(d<10) {
			date ="0"+d;
		}else {
			date = String.valueOf(d);
		}
		
		
		String today = year+"-"+month+"-"+date;
		System.out.println(today);
		
		//
		
		if(sid != null) {
			List<PlanDto> p_dto= service.searchDate_insert(sid, today);
			request.setAttribute("p_dto",p_dto);
				
		}
		
		
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
