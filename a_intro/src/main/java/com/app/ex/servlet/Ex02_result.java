package com.app.ex.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Ex02_result extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Ex02_result() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num3 = request.getParameter("number3");
		request.setAttribute("number3", num3);
		request.getRequestDispatcher("/ex02-result.jsp").forward(request, response);
	}
}
