package com.onedays.controller;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onedays.service.CaptureSerivce;
import com.onedays.service.CaptureServiceImpl;
import com.onedays.vo.CaptureDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/onelist.do")
public class CaponeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CaponeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}

	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CaptureSerivce capservice = new CaptureServiceImpl();
		String nextPage = "";
		String uri=request.getRequestURI();
		String conPath=request.getContextPath();
		String com=uri.substring(conPath.length());
		System.out.println(com);
		//System.out.println(action);
		if(com.contains("/onelist.do")) {
			HttpSession session = request.getSession();
			//	session.invalidate();
			String sid = (String)session.getAttribute("user_id");
			System.out.println("sid:" + sid);
			//조회한 게시물 번호
			String dtstr=request.getParameter("today");
			//System.out.println(dtstr);
			String[] dt=dtstr.split("-");
			Date date=new Date(Integer.parseInt(dt[0])-1900,Integer.parseInt(dt[1])-1,Integer.parseInt(dt[2]));
			
			//게시물을 조회하는 메서드에 게시물 번호를 인자로 넘기고, 결과를 받는다.
			try {
				request.setAttribute("post", capservice.list(date,sid));
				//System.out.println("test");
				//capservice.testImg(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			nextPage="WEB-INF/jsp/c_one.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}
}
