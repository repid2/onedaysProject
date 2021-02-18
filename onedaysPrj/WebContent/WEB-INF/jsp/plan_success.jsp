
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
			<div class="sideContext">
				<div class="selectMonth">
					<select name="year">
						<option autofocus="autofocus">${year}</option>
					<%for(int i=2020;i<=2025;i++){ %>
				  		<option><%=i %></option>
				  	<%} %>	
				  	</select>
				  	<select name="month"> 
				  		<option autofocus="autofocus">${month}</option>
				  	<% for(int i=1;i<=12;i++) {%>
				  		<option><%=i %></option>
				  	<%}%>	
				  	</select>
				  	<button class="dateBtn" onclick="">검색하기</button>			
				</div>
			</form>	
			
			
				<div class="plan_success">
					

					<div class="plan_success_merge">
							<c:forEach var="p_dto" items="${p_dto}">
								<c:if test="${p_dto.work_end eq 2}">
								 	<c:set var="cnt" value="${cnt+1}"/>
								</c:if>
							</c:forEach>
							
							
							<h1>${year}년&nbsp;${month} 월 달성률</h1>
							<div class="merge">	
							<ul>
							
							
					 		<li>입력한 Plan :${fn:length(p_dto)} 개</li>
					 		<li>달성한 Plan :${cnt} 개</li>
					 		
					 		</ul>
					 		<p>총 <fmt:formatNumber value="${cnt/fn:length(p_dto)*100}" pattern="###.##"/>%</p>
						</div>
					</div>
				</div>
			 </div>
		
	<!-- footer단 -->
		<%@ include file="/WEB-INF/templates/footer.jsp"  %>
	
</body>
</html>