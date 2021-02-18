<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/side.css" rel="stylesheet" />
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Stylish&display=swap" rel="stylesheet">
</head>
<body>
		<!-- header단 -->
		  <%@ include file="/WEB-INF/templates/header.jsp"  %>
	
	
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
                    <a href="https://www.facebook.com/"><img src="image/icon_facebook.png" alt="facebook"></a>
                </li>
                <li>
                    <a href="https://twitter.com/?lang=ko"><img src="image/icon_twitter.png" alt="twitter"></a>
                </li>
                <li>
                    <a href="https://www.instagram.com/"><img src="image/icon_insta.png" alt="instagram"></a>
                </li>
            </ul>
        </div>
		</aside>
		
			<form action="plan_success_search.do" method="post" id="index_frm">
				<div class="selectMonth">
					<select name="year">
						<option autofocus="autofocus">연도</option>
					<%for(int i=2020;i<=2025;i++){ %>
				  		<option><%=i %></option>
				  	<%} %>	
				  	</select>
				  	<select name="month">
				  		<option autofocus="autofocus">월</option>
				  	<% for(int i=1;i<=12;i++) {%>
				  		<option><%=i %></option>
				  	<%}%>	
				  	</select>
				  	<button class="dateBtn" id="index_btn">검색하기</button>	<br>
				  	<div class="space">
				  	<h1>날짜를 검색해주세요.</h1>		
					</div>
				</div>
			</form>
			

			
	
	
	
	<!-- footer단 -->
		<%@ include file="/WEB-INF/templates/footer.jsp"  %>
	
</body>
</html>