<%@page import="com.onedays.vo.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  --%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="/WEB-INF/templates/header.jsp"  %>
<section>
<%
	
	MemberDto dto = (MemberDto)session.getAttribute("memberdto");
	
%>

	<div id ="mp_container">
		<div class="join_input_area">
			<span class="join_line">아이디 *</span>
			<div class="input_row">
				<span class="input_box">
					<input type="text" id="id" name="id" class="login_input" value="<%=dto.getId() %>" readonly >
				</span>
			</div>
		</div>
		<div class="join_input_area">
			<span class="join_line">이름 *</span>
			<div class="input_row">
				<span class="input_box">
					<input type="text" id="name" name="name" class="login_input" value="<%=dto.getName() %>" readonly >
				</span>
			</div>
		</div>
		<div class="join_input_area">
			<span class="join_line">닉네임 *</span>
			<div class="input_row">
				<span class="input_box">
					<input type="text" id="nickname" name="nickname" class="login_input" value="<%=dto.getNickname() %>" readonly >
				</span>
			</div>
		</div>
		<div class="join_input_area">
			<span class="join_line">이메일 *</span>
			<div class="input_row">
				<span class="input_box">
					<input type="text" id="email" name="email" class="login_input" value="<%=dto.getEmail() %>" readonly >
				</span>
			</div>
		</div>
		<div class="join_input_area">
			<span class="join_line">전화번호 *</span>
			<div class="input_row">
				<span class="input_box">
					<input type="text" id="phone" name="phone" class="login_input" value="<%=dto.getPhone() %>" readonly >
				</span>
			</div>
		</div>
		<div class="join_input_area">
			<span class="join_line">성별 *</span>
			<br/>
			<c:choose>
				<c:when test="${dto.getGender() == 1 }">
					<input type="radio" name="gender" id="gender_man" value="1" checked readonly>
					<label for="gender_man" id="label_gender_area" class="login_radio" >남자</label>
				</c:when>
				<c:otherwise>
					<input type="radio" name="gender" id="gender_woman" value="2" checked readonly>
					<label for="gender_woman" id="label_gender_area" class="login_radio" >여자</label>
				</c:otherwise>
			</c:choose>
			</div>
		<div class="join_input_area">
			<span class="join_line">생년월일(8자리 숫자로 입력) *</span>
			<div class="input_row">
				<span class="input_box">
					<input type="text" id="birth_date" name="birth_date"  class="login_input" value="<%=dto.getBirth_date() %>"readonly>
				</span>
			</div>
		</div>
		<div class="join_input_area">
			<span class="join_line">가입일자(8자리 숫자로 입력) *</span>
			<div class="input_row">
				<span class="input_box">
					<input type="text" id="join_date" name="join_date" class="login_input" value="<%=dto.getJoin_date() %>"readonly>
				</span>
			</div>
		</div>
		<div id="mp_div">
			<form action="/member.do" method="post" enctype="utf-8" >
				<input type="hidden" name="par" />
				<input type="button" value="회원 정보 수정" class="mp_btn btn_global" id="mp_mod_btn"/>
				<input type="button" value="회원 정보 삭제" class="mp_btn btn_global" id="mp_del_btn"/>
			</form>
		</div>
	
	</div>
</section>

	<%@ include file="/WEB-INF/templates/footer.jsp"  %>

</body>
</html>