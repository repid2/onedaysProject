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
import javax.websocket.Session;

import com.onedays.service.CaptureSerivce;
import com.onedays.service.CaptureServiceImpl;
import com.onedays.vo.CaptureDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/remove.do")
public class CaprmvController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CaprmvController() {
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
		 if (com.equals("/remove.do")) {
			 	HttpSession session = request.getSession();
				//	session.invalidate();
				String sid = (String)session.getAttribute("user_id");
				System.out.println("sid:" + sid);
			 
				String testpath=request.getSession().getServletContext().getRealPath("/upload/");
				MultipartRequest multi=new MultipartRequest(request, testpath);
				String dtstr=multi.getParameter("today");
				//System.out.println(dtstr);
				String[] dt=dtstr.split("-");
				Date date=new Date(Integer.parseInt(dt[0])-1900,Integer.parseInt(dt[1])-1,Integer.parseInt(dt[2]));
				int removeResult = 0;
				try {
					String path=testpath+"//"+capservice.removepic(date,sid);
					//System.out.println(path);
					File f=new File(path);
					if(f.exists()){
						f.delete();
						System.out.println("파일 삭제됨");
					}else{
						System.out.println("파일 없음");
					}
					removeResult = capservice.remove(date,sid);
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println("test remove");
				String msg = removeResult==1 ? "success" : "fail";
				//System.out.println("test remove2");
				//list페이지로 성공 여부 메세지를 보낸다.
				//성공하면 list창에 alert창을 띄워 삭제했다는 메세지를 띄운다.
				request.setAttribute("result", msg);
				nextPage="/list.do";
			}
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}
}
