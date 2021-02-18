<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 보여주기</title>
</head>
<body>
	<%@ include file="/WEB-INF/templates/header.jsp"  %>
	유저 아이디 : <%= session.getAttribute("showUserId") %>
	<a href="/main.do">메인 페이지로 이동</a>
	
	<%@ include file="/WEB-INF/templates/footer.jsp"  %>
</body>
</html>