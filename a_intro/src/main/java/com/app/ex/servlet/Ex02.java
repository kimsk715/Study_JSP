package com.app.ex.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.IOException;
public class Ex02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Ex02() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/ex02.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String number1 = request.getParameter("number1");
		int num1 = Integer.parseInt(number1);
		String number2 = request.getParameter("number2");
		int num2 = Integer.parseInt(number2);
		int num3 = num1 + num2;
		response.sendRedirect("ex02result?number3=" + num3);
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
	}

}
