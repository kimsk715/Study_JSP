package com.app.controller.post;

import java.io.IOException;
import java.util.Optional;

import com.app.Action;
import com.app.Result;
import com.app.domain.dto.PostDTO;
import com.app.domain.vo.MemberVO;
import com.app.domain.vo.PostVO;
import com.app.exception.PostNotFoundException;
import com.app.repository.post.PostDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SearchController implements Action {
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Result result = new Result();
		PostDAO postDAO = new PostDAO();
		PostVO postVO = new PostVO();
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		Long memberId =  member.getId();
		Long searchId = Long.parseLong(req.getParameter("Id"));
		System.out.println(memberId);

	
		PostVO foundpost = postDAO.selectByMemberIdAndPostId(searchId,memberId);
		System.out.println(foundpost.getId());
		if(foundpost != null) {		
				postVO.setPostContent(foundpost.getPostContent());
				postVO.setPostTitle(foundpost.getPostTitle());
				session.removeAttribute("post");
				session.setAttribute("post", postVO);
		}
	
			
			
			
			
	
		result.setPath("/search.post");
//		result.setForward()
		return result;
	}
}
