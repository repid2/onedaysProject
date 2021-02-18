<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/templates/header.jsp"  %>
	<section>
		<div id=join_container>
			<div id="login_div">
				<form action="/join.do" name="login_frm" id="login_frm" method="post" enctype="utf-8">
					<input type="hidden" name="join_chk" value="1" />
						<div class="join_input_area">
							<span class="join_line">아이디(영문 또는 숫자 4자리~ 12자리 입력) * </span>
							<div id="id_chk" ></div>
							<div class="input_row">
								<span class="input_box">
									<input type="text" id="join_user_id" name="user_id" placeholder="아이디" class="login_input" maxlength="20" >
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
						</div>
						<div class="join_input_area">
							<span class="join_line">이름(특수문자 사용 불가) * </span>
							<div id="name_chk" ></div>
							<div class="input_row">
								<span class="input_box">
									<input type="text" id="join_user_name" name="user_name" placeholder="이름" class="login_input" maxlength="15">
								</span>
							</div>
						</div>
						<div class="join_input_area">
							<span class="join_line">닉네임(4자리 ~ 10자리  입력) *</span>
							<div id="nick_chk" ></div>
							<div class="input_row">
								<span class="input_box">
									<input type="text" id="join_user_nick" name="user_nick" placeholder="닉네임" class="login_input" maxlength="12">
								</span>
							</div>
						</div>
						<div class="join_input_area">
							<span class="join_line">이메일 *</span>
							<div id="email_chk" ></div>
							<div class="input_row">
								<span class="input_box">
									<input type="text" id="join_user_email" name="user_email" placeholder="abc@gmail.com" class="login_input" maxlength="50">
								</span>
							</div>
						</div>
						<div class="join_input_area">
							<span class="join_line">전화번호('-'를 제외한 번호 입력) * </span>
							<div id="phone_chk" ></div>
							<div class="input_row">
								<span class="input_box">
									<input type="text" id="join_user_phone" name="user_phone" placeholder="휴대폰" class="login_input" maxlength="15">
								</span>
							</div>
						</div>
						<div class="join_input_area">
							<span class="join_line">성별 * </span>
							<br/>
							
							<input type="radio" name="user_gen" id="gender_man" value="1">
							<label for="gender_man" id="gender_man" class="login_radio">남자</label>
							 &nbsp;&nbsp;
							<input type="radio" name="user_gen" id="gender_woman" value="2">
							<label for="gender_woman" id="gender_woman" class="login_radio">여자</label>
						</div>
						<div class="join_input_area">
							<span class="join_line">생년월일('-'를 제외한 생년월일 입력) *</span>
							<div class="input_row">
								<span class="input_box">
									<input type="text" id="join_user_birth" name="user_birth" placeholder="생년월일" class="login_input" maxlength="8">
								</span>
							</div>
						</div>
					<div class = "join_div"> 
						<input type="button" title="회원가입" alt="회원가입" value="회원가입" class="btn_global join_btn"  id="join_btn" >
					
					</div>
				</form>
				
			</div>	
		</div>
	</section>
	<%@ include file="/WEB-INF/templates/footer.jsp"  %>
</body>
</html>