<%@page import="com.onedays.vo.PlanDto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    
<%  
	Calendar cr = Calendar.getInstance();
	// 1일부터 시작하는 달력을 만들기 위해 검색한의 연도,월을 셋팅하고 일부분은 1을 셋팅한다.
	int s_year=Integer.valueOf((String)request.getParameter("year"));
	int s_month=Integer.valueOf((String)request.getParameter("month"));
//	List<Map<String, Object>> listMap = request.getParameter("p_dto");
	cr.set(s_year, s_month-1, 1);
	
	int s_startDate = cr.getMinimum(Calendar.DATE);
	int s_endDate = cr.getActualMaximum(Calendar.DATE);
	
%>
	

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
		

		
			<form action="plan_index_search.do" method="post" id="index_frm">
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
				  	<button class="dateBtn" id="index_btn">검색하기</button>			
				</div>
			</form>

	

 	
		<ul class="bxslider">
		<!-- 1 -->
		<li>
		<div class="sideContext">
			<h1>Plan</h1>
			<hr>
			<% for (int i=s_startDate;i<=12;i++){
				
				String month=null;
				String day = null;
				String today = null;
				if(request.getParameter("month").length()==1){
					month = "0"+request.getParameter("month");
				}else{
					month = request.getParameter("month");
				}
				if(i<10){
					day = "0"+i;
				}else{
					day = String.valueOf(i); ;
				}
				
				today=s_year+"-"+month+"-"+day;
				
			%>	
			<c:set var="today" value="<%=today%>"/>
			<div class="plan_index">
				<p class="plan_index_day"><%=s_year + " ." +(s_month)+ " ."+i%></p>
						 <div class="plan_index_sub">
							<ul>
							
							
							<c:forEach var="p_dto" items="${p_dto}">
						
							<c:if test="${p_dto.planDate eq today and p_dto.work_end eq 1}">
									
								<li>${p_dto.work_start}</li>	
								
							</c:if>
 
							
							</c:forEach>


				 			</ul>
				 			
				 			<div class="plan_index_check_tool"></div> 				
				 		
						 	<b class="plan_index_detail"><a href="#"></a></b>
						   </div>			 
				 
						</div>
				<%} %>
		</div>
		</li>
		<li>
		
		<!-- 2 -->
		<div class="sideContext">
			<h1>Plan</h1>
			
			<% for (int i=13;i<=24;i++){
				String month=null;
				String day = null;
				String today = null;
				if(request.getParameter("month").length()==1){
					month = "0"+request.getParameter("month");
				}else{
					month = request.getParameter("month");
				}
				if(i<10){
					day = "0"+i;
				}else{
					day = String.valueOf(i); ;
				}
				
				today=s_year+"-"+month+"-"+day;
			%>	
			<c:set var="today" value="<%=today%>"/>
			<div class="plan_index">
				<p class="plan_index_day"><%=s_year + " ." +(s_month)+ " ."+i%></p>
				 <div class="plan_index_sub">
				 <ul>		
				<c:forEach var="p_dto" items="${p_dto}">
						
							<c:if test="${p_dto.planDate eq today and p_dto.work_end eq 1}">
									
								<li>${p_dto.work_start}</li>	
								
							</c:if>
 
							
							</c:forEach>		
				 </ul>
				 <hr>
				 
				 <div class="plan_index_check_tool"></div> 
				
				 <b class="plan_index_detail"><a href="#"></a></b>
				 </div>
			</div>
			<%
			}
			%>	
		</div>
		</li>
		
		<!-- 3 -->
		<li>
		<div class="sideContext">
			<h1>Plan</h1>
			
			<% for (int i=25;i<=s_endDate;i++){
				String month=null;
				String day = null;
				String today = null;
				if(request.getParameter("month").length()==1){
					month = "0"+request.getParameter("month");
				}else{
					month = request.getParameter("month");
				}
				if(i<10){
					day = "0"+i;
				}else{
					day = String.valueOf(i); ;
				}
				
				today=s_year+"-"+month+"-"+day;
				 %>	
			<c:set var="today" value="<%=today%>"/>	 
			<div class="plan_index">
				<p class="plan_index_day"><%=s_year + " ." +(s_month)+ " ."+i%></p>
				 <div class="plan_index_sub">
				 <ul>
				<c:forEach var="p_dto" items="${p_dto}">
						
						<!-- 첫번째 문제점 : 5개만 보이게할것 -->
						
							<c:if test="${p_dto.planDate eq today and p_dto.work_end eq 1}">
									
								<li>${p_dto.work_start}</li>	
							</c:if>
 
							
							</c:forEach>
				 </ul>
		
				 <div class="plan_index_check_tool"></div> 
				 
				 <b class="plan_index_detail"><a href="#"></a></b>
				 </div>
			</div>
				<%}%>
		</div>
		</li>
	</ul>
		
	
	<!-- footer단 -->
		<%@ include file="/WEB-INF/templates/footer.jsp"  %>
	
</body>
</html>