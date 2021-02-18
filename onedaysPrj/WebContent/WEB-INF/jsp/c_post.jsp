<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/test01.css" rel="stylesheet" />
<link href="css/side.css" rel="stylesheet" />
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
	
	
	<div style="text-align: center;" class="onelist">
		<form id="capfrm" name="capfrm" method="post" enctype="multipart/form-data">
			<div id="top_left">
				<div id="top_today">
					<h2><%=daydate[0]%>년<%=daydate[1]%>월<%=daydate[2]%>일</h2>
				</div>
				<div id="top_title">
					<label for="subject">제목</label>:<input type="text" autofocus="autofocus" name="subject">
				</div>
			</div>
			<div id="top_right">
				<div id="top_img">
					<img id="View" src="#" alt="사진 미리보기" />
				</div>
				<div id="img_file">
					<input type='file' id="imgView" name="imgName" accept="image/x-png,image/gif,image/jpeg"/>
					<input type="button" value="파일삭제" id="delimg" style="display: none;" class="c_btn"/>
				</div>
			</div>
			<div id="cont">
				<textarea id="ctn_text" name="content"></textarea>
				<div id="btn_post">
					<button id="btn_submit" name="btn_submit" class="c_btn">작성하기</button><button id="btn_reset" class="c_btn">다시작성</button><button id="btn_back" class="c_btn">뒤로가기</button>
					<input type="hidden" value="<%=request.getParameter("today")%>" name="today" id="today">
				</div>
			</div>
		</form>
	</div>
	<footer id=footer>
		<%@ include file="/WEB-INF/templates/footer.jsp"%>
	</footer>
</body>
</html>