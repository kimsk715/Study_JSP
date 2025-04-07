<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입</title>
</head>
<body>
<form action="/join-ok.member" method="post">
<h1>회원가입</h1>
<div><input type="text" name="memberEmail" placeholder="이메일"></div>
<div><input type="password" name="memberPassword" placeholder="비밀번호"></div>
<div><input type="text" name="memberName" placeholder="이름"></div>
<div><input type="text" name="memberAge" placeholder="나이"></div>
<div>
<div><input type="radio" name="memberGender" value="남자" placeholder="">남자<input type="radio" name="memberGender" value="여자" placeholder="">여자<input type="radio" name="memberGender" value="선택 안함" placeholder="">선택 안함</div>
</div>
<button>입력 완료</button>
</form>
</body>
</html>