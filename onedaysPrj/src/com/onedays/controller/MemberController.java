package com.onedays.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;

import com.onedays.service.MemberServiceImpl;
import com.onedays.service.PlanServiceImpl;
import com.onedays.vo.MemberDto;

/**
 * Servlet implementation class MemberController
 */

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url ="WEB-INF/jsp/";
		

		// serviceimpl의 한 객체 선언(하나가지고 돌려쓰기)
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		HttpSession session = request.getSession();
		MemberDto dto = new MemberDto();
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		String sid = (String)session.getAttribute("user_id");
		
		//System.out.println(user_id);
		//System.out.println(user_pwd);
		
		
		
		//Cookie cookie = new Cookie("id", id);
		String login_chk = request.getParameter("login_chk");
		
		// 로그인 판별 여부
		int idChk = 0;
		
		// 정보 수정, 삭제 여부
		int memChk = 0;
		
		// 정보 입력
		if(user_id != null && user_pwd != null && sid == null) {

			// 정보 뽑기
			idChk = service.login(user_id,user_pwd);	// 로그인 맞을 경우 1을 반환
			if(idChk == 1 ) {
				
				session.setAttribute("user_id", user_id);
				session.setAttribute("memberdto", service.memberInfo(user_id));
				idChk = 0;
			}else {
				idChk = 2;
				out.print("no");
				
			}
		}
		
		String para = request.getParameter("para");	
		// System.out.println("para ="+para);
		System.out.println("sid = "+sid);
		
		if(para != null && sid != null) {
			if(para.equals("modify")) {
				url += "memmod.jsp";
			}else if(para.equals("mypage")) {
				url += "mypage.jsp";			
			}else if(para.equals("logout")) {
				session.invalidate();
				url += "main.jsp";
			}else if(para.equals("login")) {
				url += "main.jsp";
			}else if(para.equals("mem_mod")) {
				
				dto.setEmail(request.getParameter("user_email"));
				dto.setPwd(request.getParameter("user_pwd"));
				dto.setPhone(request.getParameter("user_phone"));
				dto.setId(request.getParameter("user_id"));
				
				memChk = service.memMod(dto, sid);
				// System.out.println(memChk);
				
				if(memChk == 1) {
					session.setAttribute("memberdto", service.memberInfo(sid));
					
					url+="mypage.jsp";
					
				}else {
					
					url+="memmod.jsp";
				}
				
			}else if(para.equals("delete")){
				PlanServiceImpl service_p = PlanServiceImpl.getInstance();
				service_p.plan_all_del(sid);
				memChk = service.memDel(sid);
				if(memChk == 1) {
					System.out.println(sid+"는 삭제되었습니다.");
					session.invalidate();
				}else {
					System.out.println(sid+"는 삭제되지 않았습니다.");
				}
				
				url += "main.jsp";
			}
			
		}else {
			// 로그인 여부
			if(sid == null) {
				
				url += "login.jsp";
			}else {
				url += "main.jsp";
			}
		}
		
		if(idChk == 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
		
	}

}
