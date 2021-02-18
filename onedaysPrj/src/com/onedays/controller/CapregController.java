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
@WebServlet("/register.do")
public class CapregController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CapregController() {
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
		if (com.equals("/register.do")) {
			HttpSession session = request.getSession();
			//	session.invalidate();
			String sid = (String)session.getAttribute("user_id");
			System.out.println("sid:" + sid);
			
			String testpath=request.getSession().getServletContext().getRealPath("/upload/");
			MultipartRequest multi=new MultipartRequest(request,testpath,1024*1024*10,"utf-8",new DefaultFileRenamePolicy());
			//System.out.println("path : "+testpath);
			String subject=multi.getParameter("subject");
			String content =multi.getParameter("content");
			String fileName=multi.getFilesystemName("imgName"); //(중복처리후 파일이름)
			String orgfileName = multi.getOriginalFileName("imgName"); //(중복 처리 전 파일이름)
			//System.out.println("test request subject : "+subject+",content : "+content+",imgName : "+fileName+",imgOrName: "+orgfileName);
			String dtstr=multi.getParameter("today");
			//System.out.println(dtstr);
			String[] dt=dtstr.split("-");
			Date date=new Date(Integer.parseInt(dt[0])-1900,Integer.parseInt(dt[1])-1,Integer.parseInt(dt[2]));
			CaptureDTO bean = new CaptureDTO(subject,content,fileName,date);
			bean.setId(sid);
			try {
				if(capservice.regist(bean) == 1) {
					//System.out.println("regist 1_3");
					nextPage = "list.do";
					response.sendRedirect(nextPage);
					return;
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}
}
