<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>join.jsp</title>
</head>
<body>
	아이디 : ${member.id }<br>
	비밀번호 : ${member.pw }<br>
	이름 : ${member.name }<br>
	이메일 : ${member.email }<br>
	<!-- http://localhost:8888/ex_13_1/board/join?id=lion&pw=12345 -->
</body>
</html>