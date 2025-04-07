package com.app.ex.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Ex03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Ex03() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("ex03.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fruitname = request.getParameter("fruit");
		int fruitprice = Integer.parseInt(request.getParameter("fruitprice"));
		request.setAttribute("fruitname", fruitname + "은(는)");
		request.setAttribute("fruitprice", fruitprice + "원입니다.");
		request.getRequestDispatcher("ex03-result.jsp").forward(request, response);
		System.out.println(fruitname);
		System.out.println(fruitprice);
	}

}
