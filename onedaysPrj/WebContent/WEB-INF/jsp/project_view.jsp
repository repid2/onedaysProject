<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Stylish&display=swap" rel="stylesheet">
</head>
<body>
<%@ include file="/WEB-INF/templates/header.jsp"  %>


<div class="proBox">
<h3>프로젝트 소개</h3>
<p class="proG">오늘도 <b><ins>10분</ins></b>이 부족했다면? <br>
<b><ins>단1분</ins></b>도 버리지 않는 가장 철저한 자기관리 플래너</p>

	<ul class="bxslider">
			<li>
			<img src="image/1번.png" width="100%"/>
			</li>
		    <li>
			<img src="image/2번.png" width="100%"/>
			</li>
			<li>
			<img src="image/3번.png" width="100%"/>
			</li> 
		</ul>
</div>
<%@ include file="/WEB-INF/templates/footer.jsp"  %>
</body>
</html>