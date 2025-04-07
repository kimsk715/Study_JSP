<%@page import="com.app.domain.vo.PostVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 조회</title>
</head>
<body>
<%
	PostVO post = (PostVO)request.getAttribute("post");
%>
<form action="/search-ok.post">
<input type="text" name="Id" placeholder="게시글 번호">
<input type="text" name="postTitle"  placeholder="빈 값">
<input type="text" name="postContent"  placeholder="빈 값">
<button>게시글 검색</button>

</form>

</body>
</html>