package com.app.controller.member;

import java.io.IOException;

import com.app.domain.vo.MemberVO;
import com.app.repository.member.MemberDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class MyPageController extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	      HttpSession session = req.getSession();
	      MemberVO member = (MemberVO)session.getAttribute("member");
	      req.setAttribute("member", member);
	      req.getRequestDispatcher("/templates/member/mypage.jsp").forward(req, resp);
	   }
	
	


	
}

