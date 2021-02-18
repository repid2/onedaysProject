<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%  
	Calendar cr = Calendar.getInstance();
	int year = cr.get(Calendar.YEAR);
	int month = cr.get(Calendar.MONTH);
	int date = cr.get(Calendar.DATE);
	int week = cr.get(Calendar.DAY_OF_WEEK );
	String today = year + "." +(month+1)+ "."+date; // 오늘 날짜
	// 1일부터 시작하는 달력을 만들기 위해 오늘의 연도,월을 셋팅하고 일부분은 1을 셋팅한다.
	cr.set(year, month, 1);
						 
	// 셋팅한 날짜로 부터 아래 내용을 구함
						 
	// 해당 월의 첫날를 구함
	int startDate = cr.getMinimum(Calendar.DATE);
						 
	// 해당 월의 마지막 날을 구함
	int endDate = cr.getActualMaximum(Calendar.DATE);
						 
	// 1일의 요일을 구함
	int startDay = cr.get(Calendar.DAY_OF_WEEK);
	int count = 0;
	String yo=null;
	%>
	<%	 
	 switch(week){
	 	case 1:
	 		yo="Sunday";
	 		break;
		case 2:
			yo="Monday";
			break;
		case 3:
	 		yo="Tuesday";
			break;
	 	case 4:
	 		yo="Wednesday";
	 		break;
	 	case 5:
	 		yo="Thursday";
			break;
		case 6:
	 		yo="Friday";
	 		break;
	 	case 7:
	 		yo="Saturday";
	 		break;
	 	}	 			
	%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>OneDays main</title>
 

</head>
<body>
	
	
	
	
	<!-- header단 -->
		<%@ include file="/WEB-INF/templates/header.jsp"  %>

	<div id=body1>
		<ul class="bxslider">
			<li>
			<img src="image/mainbnr1.png" width="100%"/>
			</li>
		    <li>
			<img src="image/mainbnr2.jpg" width="100%"/>
			</li>
			<li>
			<img src="image/mainbnr3.png" width="100%"/>
			</li> 
		</ul>
	</div>
	
	<c:choose>
		<c:when test="${sessionScope.user_id eq null}" >
			<div class="double">
				<div class="wrap_box">
		 			<p class="small_txt"><%=year %></p>
		 			<p class="medium_txt"><%=month+1 %>월</p>
				<div class="week_box">
		 		<p class="sub_tit"><%=yo %>
		 		<span class="day"><%=date %>일</span></p>
		 		<div class="list_box">
		  		<p class="mini_tit">완료한 일</p>
		  				<div class="section1">
		  					<p>로그인후 이용해주세요</p>
		  					
		  				</div>
		  		<p class="mini_tit">오늘의 계획</p>
		  				<div class="section2">
		  					<p>로그인후 이용해주세요</p>
		  	
		  				</div>
		  		
		 		</div>
				</div><!-- week_box -->
				</div><!-- wrap_box -->
			</div><!-- double -->
		</c:when>
		<c:otherwise>
			<div class="double">
				<div class="wrap_box">
		 			<p class="small_txt"><%=year %></p>
		 			<p class="medium_txt"><%=month+1 %>월</p>
				<div class="week_box">
		 		<p class="sub_tit"><%=yo %>
		 		<span class="day"><%=date %>일</span></p>
		 		<div class="list_box">
		  		<p class="mini_tit">완료한 일</p>
		  				<div class="section1">
			  				<c:forEach var="p_dto" items="${p_dto}">		
							<c:if test="${p_dto.work_end eq 2}">		
							<p>${p_dto.work_start}</p>	
							</c:if>
							</c:forEach>	
		  				</div>
		  				
		  		<p class="mini_tit">오늘의 계획</p>
		  			<div class="section2">
		  				<c:forEach var="p_dto" items="${p_dto}">		
						<c:if test="${p_dto.work_end eq 1}">		
						<p>${p_dto.work_start}</p>	
						</c:if>
						</c:forEach>	
		  			</div>
		  		
		 		</div>
				</div><!-- week_box -->
				</div><!-- wrap_box -->
			</div><!-- double -->
		</c:otherwise>
	</c:choose>
	
	
	<div class="double">
		<div class="calender">
			<div name="calendar">
				<h3><%=today %></h3>
				<br>
				<table>
				<tr height="80">
				<td><font size="4" color="#FE2E2E">Sunday</font></td>
				<td><font size="4" color="#6E6E6E">Monday</font></td>
				<td><font size="4" color="#6E6E6E">Tuesday</font></td>
				<td><font size="4" color="#6E6E6E">Wednesday</font></td>
				<td><font size="4" color="#6E6E6E">Thursday</font></td>
				<td><font size="4" color="#6E6E6E">Friday</font></td>
				<td><font size="4" color="#0040FF">Saturday</font></td>
				</tr>
				<tr height="80">
				<%
				for (int i=1;i<startDay;i++){
					count++;
				%>
				<td>&nbsp;</td>
				<%
				}
				for (int i=startDate;i<=endDate;i++){
					String bgcolor
					= (today.equals(year+"."+(month+1)+"."+i))? "#CCCCCC" : "#FFFFFF";
					String color;
					
					if(count%7==0){
							color="red";
					}else if(count%7==6){
							color="blue";
					}else{
							color="#6E6E6E";
					}
							count++;
				
				%>
				<td bgcolor="<%=bgcolor %>"><font size="5" color=<%=color%>><%=i%>
			</font></td>
				<%
				if(count%7 == 0 && i < endDate){
				%>
				</tr>
				<tr height="80">
				<%
					}
			    }
				while(count%7 != 0){
				%>
				<td>&nbsp;</td>
				<%
				count++;
				}
				%>
				</tr> 
				</table>
			</div>	
		</div>
		</div>
    <div style="clear:both;"></div>
	<div class="btnList">
		<p class="btn"><a href="view.do">Project</a></p>
		<p class="btn"><a href="map.do">Location</a></p>
		<p class="btn"><a href="plan_index.do">Plan table</a></p>
		<p class="btn"><a href="/list.do">Diary</a></p>
		<p class="btn"><a href="#" id="Mypage_btn">My menu</a></p>
	</div>
		<!--버튼5개 밑으로 가야함  -->
		<div style="clear:both;"></div> <!-- footer가 올라가는거 막아줌 -->
	
	
	<!-- footer단 -->
		<%@ include file="/WEB-INF/templates/footer.jsp"  %>
	
</body>
</html>