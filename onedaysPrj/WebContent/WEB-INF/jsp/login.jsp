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
		<div id=login_container>
			<div>
				<form action="/member.do" name="login_frm" id="login_frm" method="post" enctype="utf-8">
					
					<div class="login_div">
						<div>
							<div class="id_area">
								<div class="input_row" id="id_area">
									<span class="input_box">
										<label for="id" id="label_id_area" class="login_text" >아이디</label>
										<input type="text" id="user_id" name="user_id" placeholder="아이디" class="login_input" maxlength="41" value="">
									</span>
								</div>
							</div>
							<div class="pw_area">
								<div class="input_row" id="pw_area">
									<span class="input_box">
										<label for="pw" id="label_pw_area" class="login_text">비밀번호</label>
										<input type="password" id="user_pwd" name="user_pwd" placeholder="비밀번호" class="login_input" maxlength="16">
									</span>
								</div>
							</div>
							
						</div>
						<div class="login_chk_btn">
							<input type="checkbox" name="login_chk" id="login_chk" value="1"/>
							<label for="login_chk" >자동로그인</label>
								<div id="search_btn">
								
								
								
							</div>
						</div>
						<div>
						<input type="button" title="로그인" alt="로그인" value="로그인" class="input_row btn_global" id="login_btn">
						<input type="button" title="회원가입" alt="회원가입" value="회원가입" class="input_row btn_global" id="join_btn" onclick="location.href='/join.do'">
						</div>
					</div>
				</form>
				
			</div>	
		</div>
	</section>
		<%@ include file="/WEB-INF/templates/footer.jsp"  %>
</body>
</html>