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
@WebServlet("/modify.do")
public class CapmdfController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CapmdfController() {
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
		if (com.equals("/modify.do")) {
			HttpSession session = request.getSession();
			//	session.invalidate();
			String sid = (String)session.getAttribute("user_id");
			System.out.println("sid:" + sid);
			//수정
			String testpath=request.getSession().getServletContext().getRealPath("/upload/");
			String rs=request.getParameter("title");
			//System.out.println("rs="+rs);
			int confirm=0;
			String dtstr="";
			try {
			//System.out.println("request getContentType : " + request.getContentType());
			MultipartRequest multi=new MultipartRequest(request,testpath,1024*1024*10,"utf-8",new DefaultFileRenamePolicy());
			//System.out.println("path : "+testpath);
			String subject=multi.getParameter("title");
			String content =multi.getParameter("content");
			String fileName=multi.getFilesystemName("imgName"); //(중복처리후 파일이름)
			String orgfileName = multi.getOriginalFileName("imgName"); //(중복 처리 전 파일이름)
			dtstr=multi.getParameter("today");
			//System.out.println(dtstr);
			String[] dt=dtstr.split("-");
			Date date=new Date(Integer.parseInt(dt[0])-1900,Integer.parseInt(dt[1])-1,Integer.parseInt(dt[2]));

			String path=testpath+"//"+capservice.removepic(date,sid);
			if(fileName!=null) {
				//System.out.println("path"+path);
				File f=new File(path);
				if(f.exists()){
					f.delete();
					System.out.println("파일 삭제됨");
				}else{
					System.out.println("파일 없음");
				}
			}
				/*
				 * else { fileName=capservice.removepic(date,sid); }
				 */
			CaptureDTO bean = new CaptureDTO();
			//System.out.println("test request subject : "+subject+",content : "+content+",imgName : "+fileName+",imgOrName: "+orgfileName);
			//수정한 데이터로 vo초기화
			bean.setPic_title(subject);
			bean.setPic_content(content);
			bean.setPic_path(fileName);
			bean.setPic_date(date);
			bean.setId(sid);
			capservice.modify(bean);
				confirm=1;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String msg = confirm==1 ? "success" : "fail";
			
			//list페이지로 성공 여부 메세지를 보낸다.
			//성공하면 list창에 alert창을 띄워 삭제했다는 메세지를 띄운다.
			request.setAttribute("modify", msg);
			
          		//내가 수정한 게시물로 이동
			if(confirm == 1) {
				//System.out.println("regist 1_3");
				nextPage="/onelist.do?today="+dtstr;
				response.sendRedirect(nextPage);
				return;
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}
}
