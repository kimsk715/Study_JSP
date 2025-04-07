package com.app.ex.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

public class Ex05 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Ex05() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("ex05.jsp").forward(request, response);	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String failMessage = "아이디 또는 비밀번호가 일치하지 않습니다.";
		String result = "";
		if(id.equals("test") && password.equals("1234")) {
//			response.sendRedirect("ex05Success");
			response.sendRedirect("ex05Success?result="+ URLEncoder.encode(id + "님 환영합니다.", "UTF-8") );
		}
		else {
			//request.getRequestDispatcher("/ex05.jsp").forward(request, response);
			response.sendRedirect("ex05");
			alert(failMessage);
		}
	}
	

	private void alert(String failMessage) {
		// TODO Auto-generated method stub
		
	}

}
