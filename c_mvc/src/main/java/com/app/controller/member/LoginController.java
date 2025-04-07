package com.app.controller.member;

import java.io.IOException;

import com.app.Action;
import com.app.Result;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginController implements Action{
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Result result = new Result();
		if(req.getParameter("login") != null) {
			req.setAttribute("login", false);
		}
		result.setPath("/templates/member/login.jsp");
		result.setForward(true);
		return result;
	}
}





















