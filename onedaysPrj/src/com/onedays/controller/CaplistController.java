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
@WebServlet("/list.do")
public class CaplistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CaplistController() {
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
		if (com == null || com.equals("/list.do")) {
			HttpSession session = request.getSession();
			//	session.invalidate();
			String sid = (String)session.getAttribute("user_id");
			System.out.println("sid:" + sid);
			System.out.println("1");
			try {
				request.setAttribute("capList", capservice.listall(sid));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			nextPage = "WEB-INF/jsp/c_list.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}
}
