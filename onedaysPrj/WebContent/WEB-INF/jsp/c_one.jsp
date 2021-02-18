<%@page import="java.sql.Date"%>
<%@page import="com.onedays.service.CaptureServiceImpl"%>
<%@page import="com.onedays.dao.CaptureDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/test01.css?ver=1" rel="stylesheet" />
<link href="css/side.css?ver=1" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="js/capture.js?ver=10" type="text/javascript"></script>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Stylish&display=swap" rel="stylesheet">
<title>Insert title here</title>
</head>
<%
String day=request.getParameter("today");
String[] daydate=day.split("-");
Date todate=new Date(Integer.parseInt(daydate[0]),Integer.parseInt(daydate[1]),Integer.parseInt(daydate[2]));
int tcolor=todate.getDay();
%>
<body>
	<header id=top>
		<%@ include file="/WEB-INF/templates/header.jsp"%>
	</header>
	
	<!-- <aside>
		<aside>
 		<div id="side_top">
           
            <nav>
                <ul id="gnb">
                    <li class="mm1">
                        <a href="plan_index.do">목록</a>
                      
                      
                    </li>
                    <li class="mm2">
                        <a href="plan_insert.do">작성하기</a>
                       
                            
                        
                    </li>
                    <li class="mm3">
                        <a href="plan_success.do">달성률</a>
            
                    </li>
                    
                   
                </ul>
            </nav>
        </div>
        <div id="side_bottom">
            <ul class="sns">
                <li>
                    <a href="#"><img src="image/icon_facebook.png" alt="facebook"></a>
                </li>
                <li>
                    <a href="#"><img src="image/icon_twitter.png" alt="twitter"></a>
                </li>
                <li>
                    <a href="#"><img src="image/icon_insta.png" alt="instagram"></a>
                </li>
            </ul>
        </div>
		</aside> -->
		

	
	<div  class="onelist">
	<form id="caplist" name="caplist" enctype="multipart/form-data">
		<div id="top_left">
			<div id="top_today">
				<h2><%=daydate[0]%>년<%=daydate[1]%>월<%=daydate[2]%>일</h2>
			</div>
			<div id="top_title">
				제목 : <input type='text' id='title' name='title' value='${post.pic_title }' disabled="disabled">
			</div>
		</div>
		<div id="top_right">
			<div id="top_img">
				<c:if test="${!empty post.pic_path}"><img src="http://localhost:8080/upload/${post.pic_path}" id="View" style="display: inline;"></c:if><c:if test="${empty post.pic_path}"><img src="#" alt="등록된 이미지 없음" id="View"></c:if>
			</div>
			<c:if test="${!empty post.pic_path}">
				<div id="img_file" style="display: none;">
					<%-- <span>${post.pic_path}</span> --%>
					<input type='file' id="imgView" name="imgName" disabled="disabled" accept="image/x-png,image/gif,image/jpeg"/>
					<input type="button" value="파일삭제" id="delimg" />
				</div>
			</c:if>
			<c:if test="${empty post.pic_path}">
				<!-- <span>이미지없음</span> -->
				<div id="img_file" style="display: none;" >
					<input type='file' id="imgView" name="imgName" disabled="disabled" accept="image/x-png,image/gif,image/jpeg"/>
					<input type="button" value="파일삭제" id="delimg" style="display: none;" />
				</div>
			</c:if>
		</div>
		<div id="cont">
			<textarea rows="20" cols="60" id='ctn_text' name='content' disabled="disabled">${post.pic_content}</textarea>
			<div id="modBtn" style='display: none;'>
				<input type=button id='mod'	value="수정 완료" class="c_btn">
				<input type=button id='back' value="취소" class="c_btn">
			</div>
			<div id="btn">
				<input type='button' id='modify'value='수정' class="c_btn">
				<input type='button' id='remove' value='삭제' class="c_btn">
				<input type='button' id='list' value='목록' class="c_btn">
			</div>
		</div>
		<input type='hidden' id='today' name='today' value='<%=request.getParameter("today")%>'>
	</form>
	</div>
	<footer id=footer>
		<%@ include file="/WEB-INF/templates/footer.jsp"%>
	</footer>
</body>
</html>