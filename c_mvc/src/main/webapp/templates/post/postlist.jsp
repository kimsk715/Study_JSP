
<%@page import="com.app.domain.vo.MemberVO"%>
<%@page import="com.app.domain.vo.PostVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<%
	MemberVO member =(MemberVO)session.getAttribute("member");
	PostVO post = (PostVO) session.getAttribute("post"); 
	%>
	
	<h1><%=post.getPostTitle()%> </h1>
	<h1><%=post.getPostContent()%> </h1>
	<h1><%=member.getId()%> </h1>
	
	<a href="/templates/member/mypage.jsp"><button>마이 페이지로 돌아가기</button></a>
	
</body>
</html>