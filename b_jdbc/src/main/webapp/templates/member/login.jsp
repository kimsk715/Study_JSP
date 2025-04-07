<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#check{
color : red;
}
</style>
</head>
<body>
<form action="/member/login" method ="post" name = "join-form">
		<div><input type = "text" name="memberEmail" placeholder="이메일"></div>
		<div><input type = "password" name="memberPassword" placeholder="비밀번호"></div>
		<div><%if(request.getParameter("login")!=null){ %>
		<p id = "check"></div>
		<%} %>
		<button>로그인</button>
	</form>
</body>
</html>