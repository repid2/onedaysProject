package com.onedays.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mapController
 */
@WebServlet("/map.do")
public class mapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public mapController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="WEB-INF/jsp/map.jsp";
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
        dispatch.forward(request, response);
	}

	
}
