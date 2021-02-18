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

	<div id ="mem_mod_container">
		<form action="/member.do" name="mod_frm" id="mod_frm" method="post" enctype="utf-8">
		<input type="hidden" name="para" />
		<div class="join_input_area">
			<span class="join_line">아이디 *</span>
			<div class="input_row input_read">
				<span class="input_box">
					<input type="text" id="join_user_id" name="user_id" class="login_input input_read" value="<%=dto.getId() %>" readonly >
				</span>
			</div>
		</div>
		<div class="join_input_area">
			<span class="join_line">이름 *</span>
			<div class="input_row input_read" >
				<span class="input_box">
					<input type="text" id="join_user_name" name="user_name" class="login_input input_read" value="<%=dto.getName() %>" readonly >
				</span>
			</div>
		</div>
		<div class="join_input_area">
			<span class="join_line">비밀번호(영문, 숫자, 특수문자를 혼합한 8자리 ~ 15자리 입력) *</span>
			<div id="pwd_chk" ></div>
			<div class="input_row">
				<span class="input_box">
					<input type="password" id="join_user_pwd" name="user_pwd" placeholder="비밀번호" class="login_input" maxlength="15">
				</span>
			</div>
			<span class="join_line">비밀번호 확인(영문, 숫자, 특수문자를 혼합한 8자리 ~ 15자리 입력) *</span>
			<div class="input_row">
				<span class="input_box">
					<input type="password" id="join_user_pwd_chk" name="user_pwd_chk"  placeholder="비밀번호 확인" class="login_input" maxlength="15">
				</span>
			</div>
		</div>
		<div class="join_input_area">
			<span class="join_line">닉네임 *</span>
			<div class="input_row input_read">
				<span class="input_box ">
					<input type="text" id="join_user_nick" name="user_nick" class="login_input input_read" value="<%=dto.getNickname() %>" readonly >
				</span>
			</div>
		</div>
		<div class="join_input_area">
			<span class="join_line">이메일 *</span>
			<div id="email_chk" ></div>
			<div class="input_row">
				<span class="input_box">
					<input type="email" id="join_user_email" name="user_email" class="login_input" placeholder="abc@gmail.com" value="<%=dto.getEmail() %>" >
				</span>
			</div>
		</div>
		<div class="join_input_area">
			<span class="join_line">전화번호('-'를 제외한 번호 입력) * </span>
			<div id="phone_chk" ></div>
			<div class="input_row">
				<span class="input_box">
					<input type="text" id="join_user_phone" name="user_phone" class="login_input" value="<%=dto.getPhone() %>"  >
				</span>
			</div>
		</div>
		<div class="join_input_area">
			<span class="join_line">성별 *</span>
			<br/>
				<c:choose>
				<c:when test="${dto.getGender() == 1 }">
					<input type="radio" name="user_gen" id="gender_man" value="1" checked readonly>
					<label for="gender_man" id="gender_man" class="login_radio" >남자</label>
				</c:when>
				<c:otherwise>
					<input type="radio" name="user_gen" id="gender_woman" value="2" checked readonly>
					<label for="gender_woman" id="gender_woman" class="login_radio" >여자</label>
				</c:otherwise>
			</c:choose>
			</div>
		<div class="join_input_area">
			<span class="join_line">생년월일(8자리 숫자로 입력) *</span>
			<div class="input_row input_read">
				<span class="input_box">
					<input type="text" id="join_user_birth" name="user_birth"  class="login_input input_read" value="<%=dto.getBirth_date() %>"readonly>
				</span>
			</div>
		</div>
		<div class="join_input_area">
			<span class="join_line">가입일자(8자리 숫자로 입력) *</span>
			<div class="input_row input_read">
				<span class="input_box">
					<input type="text" id="join_user_join" name="user_join" class="login_input input_read" value="<%=dto.getJoin_date() %>"readonly>
				</span>
			</div>
		</div>
		<div class = "join_div"> 
			<input type="button" title="회원정보 수정" alt="회원정보 수정" value="회원정보 수정" class="btn_global join_btn" id="mem_mod_btn" >
		</div>
		</form>
	</div>
</section>

<footer id=footer>
	<%@ include file="/WEB-INF/templates/footer.jsp"  %>
</footer> 

</body>
</html>