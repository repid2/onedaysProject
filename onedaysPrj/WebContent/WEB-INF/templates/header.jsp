<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!-- 통합 css -->
<link href="css/jquery.bxslider.css" rel="stylesheet" /> 
<link href="css/main.css" rel="stylesheet" />



<header>	
<div class="centerBox">

		<div class="logobox">   
				<a href="onedays.do"><img src="image/logo.png" width="100%"/></a>
		</div>
		<div class="rightBox">		
			<div class="navi">
				<ul>
					<li>
						<a href="#">ABOUT US</a>
						<ul>
							<li><a href="view.do">프로젝트 소개</a></li>				
							<li><a href="map.do">오시는 길</a><!-- google ifram --></li>
						</ul>
					</li>	
					<li>
						<a href="#">SUPPORT</a>
						<ul>
							<li><a href="plan_index.do">Plan table</a></li>
							<li><a href="/list.do">Diary</a></li>			
						</ul>
					</li>	
					<li>
						<a href="#">CONTACT US</a>
						<ul>
							<li><a href="#" id="Mypage_li">내 정보</a></li>
						</ul>	
					</li>							
				</ul>	
				
				<ul>	
				<form action="/member.do" method="post" name="frm_member" id="frm_mem" >
					<input type="hidden" id="para" name="para" />
						<c:choose>
							<c:when test="${sessionScope.user_id eq null}" >
								<li class="jbtn"><input type="button" value="Login" id="Login"></li>
								<li class="jbtn"><input type="button" value="Join" id="Join"></li>
							</c:when>
							<c:otherwise>
								<li class="jbtn"><input type="button" value="My" id="Mypage" /></li>
								<li class="jbtn"><input type="button" value="Logout" id="Logout" /></li>
							</c:otherwise>
						</c:choose>
				</form>		
				 </ul>	
		   </div>	  	
	   </div>
	</div>
	
	
	</header>