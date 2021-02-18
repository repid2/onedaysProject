<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.onedays.vo.CaptureDTO"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./css/test01.css?ver=5" rel="stylesheet" />
<link href="./css/side.css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="./js/capture.js?ver=7" type="text/javascript"></script>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Stylish&display=swap" rel="stylesheet">

<%
	Date date = new Date();
	int year = date.getYear();
	

	if(request.getParameter("month")!=null){
		 date.setMonth(Integer.parseInt(request.getParameter("month")));
	}
	date.setDate(1);
	Calendar cal = Calendar.getInstance();
	cal.set(year, date.getMonth(), 1);
	int startdate = date.getDay();
	int startday = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
	int endday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	List<CaptureDTO> v = (List) request.getAttribute("capList");
	SimpleDateFormat fmtdate=new SimpleDateFormat("yyyy-MM-dd");
%>
<title>Insert title here</title>
</head>
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
		
		
	</aside>
	<div style="text-align: center;" id="cap_main">
		<h2 class="c_main"><%=date.getMonth() + 1%>월의 일기장</h2>
		<select id="month" name="month" >
			<option selected="selected" disabled="disabled">선택해주세요</option>
			<option value="0">1월</option>
			<option value="1">2월</option>
			<option value="2">3월</option>
			<option value="3">4월</option>
			<option value="4">5월</option>
			<option value="5">6월</option>
			<option value="6">7월</option>
			<option value="7">8월</option>
			<option value="8">9월</option>
			<option value="9">10월</option>
			<option value="10">11월</option>
			<option value="11">12월</option>
		</select>
		<table id="captbl" border="1">
			<%-- <c:choose>
				<c:when test='${capList == null}'>
					<td colspan="3">
						<p align="center">
							<b><span style=''>등록된 일기가 없습니다.</span></b>
						</p>
					</td>
				</c:when>
				
				<c:when test="${capList != null }">
					<c:forEach var="post" items="${capList }" varStatus="postNum">
						<tr align="center" id="listall">
							<td width="66%" style="overflow: hidden;text-overflow: ellipsis;"><a href="/onelist.do?no=${post.pic_no}">${post.pic_title}</a></td>
							<td width="30%"><fmt:formatDate value="${post.pic_date }" pattern="MM-dd"/>
							</td>
							<td width="5%"><c:if test="${!empty post.pic_path}"><img src="http://localhost:8080/upload/${post.pic_path}" id="View" style="display: inline;"></c:if><c:if test="${empty post.pic_path}"><img src="#" alt="등록된 이미지 없음" id="View"></c:if></td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose> --%>
			<%
				for (int i = 0; i < startdate; i++) {
			%>
			<tr id="whitespace" style="opacity: 0">
				<td style="width: 170px"></td>
			</tr>
			<%
				}
			%>

			<%
				Boolean flag=true;
					for (int i = startday; i <= endday; i++) {
						for(int j=0;j<v.size();j++){
							CaptureDTO o = v.get(j);
							if(fmtdate.format(new Date(date.getYear(),date.getMonth(),i)).contains(fmtdate.format(o.getPic_date()))){
			%>
						<tr align="center" id="listall" onclick="location.href='onelist.do?today=<%=fmtdate.format(new Date(date.getYear(),date.getMonth(),i))%>'">
							<td width="65%"
								style="overflow: hidden; text-overflow: ellipsis; font-size: 14px;padding-left: 4px;padding-top: 4px"><%=o.getPic_title()%></td>
							<td width="30%" style="font-size: 12px"><%=date.getMonth() + 1%>월<%=i%>일</td>
							<td id="hr"></td>
							<td><%if(o.getPic_path() !=null){ %><img src="http://localhost:8080/upload/<%=o.getPic_path() %>" id="View" style="display: inline;"><%} %></td>
						</tr>
			<%				
							flag=false;
							break;
						}
						flag=true;
					}
					if(flag){
			%>			
					<c:choose>
						<c:when test="${sessionScope.user_id eq null}" >
							<tr align="center" id="listall" onclick="alertLogin()">
								<td width="66%"
									style="overflow: hidden; text-overflow: ellipsis; font-size: 14px;padding-left: 3px"></td>
								<td width="30%" style="font-size: 12px"><%=date.getMonth() + 1%>월<%=i%>일</td>
								<td width="5%" id="posting" >작성하기</td>
							</tr>
						</c:when>
						<c:otherwise>
							<tr align="center" id="listall" onclick="location.href='post.do?today=<%=fmtdate.format(new Date(date.getYear(),date.getMonth(),i))%>'">
								<td width="66%"
									style="overflow: hidden; text-overflow: ellipsis; font-size: 14px;padding-left: 3px"></td>
								<td width="30%" style="font-size: 12px"><%=date.getMonth() + 1%>월<%=i%>일</td>
								<td width="5%" id="posting" >작성하기</td>
							</tr>
						</c:otherwise>
					</c:choose>
			<%		}
				}
			%>

		</table>
	</div>
	<footer id=footer>
		<%@ include file="/WEB-INF/templates/footer.jsp"%>
	</footer>
</body>
</html>