package com.app.ex.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

public class Ex04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Ex04() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("ex04.jsp").forward(request, response);	
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cityname =  request.getParameter("city");
		System.out.println(cityname);
//		request.setAttribute("sigu", cityname.equals("경기도") ? "남양주시" : "강남구");
		
//		request.getRequestDispatcher("ex04-result.jsp").forward(request, response);
		
		 response.sendRedirect(cityname.equals("경기도") ? "ex04-gang" : "ex04-nam");
		
		
	}

}
