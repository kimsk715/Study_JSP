package com.app.controller.post;

import java.io.IOException;

import com.app.Action;
import com.app.Result;
import com.app.domain.vo.MemberVO;
import com.app.domain.vo.PostVO;
import com.app.repository.post.PostDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class WriteOkController implements Action{
	 @Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Result result = new Result();
		PostVO postVO = new PostVO();
		PostDAO postDAO = new PostDAO();
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO)session.getAttribute("member");
		Long id = member.getId();
		String postTitle = req.getParameter("postTitle");
		String postContent = req.getParameter("postContent");
		
		
		postVO.setMemberId(id);
		postVO.setPostTitle(postTitle);
		postVO.setPostContent(postContent);
		postDAO.insert(postVO);
//		System.out.println(postVO.getMemberId());
		
		session.setAttribute("post", postVO);
		result.setPath("/write.post");
		
		return result;
	}
}
