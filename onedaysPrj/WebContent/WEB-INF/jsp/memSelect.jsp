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
	<div id="memSel_container">
		<div>
		<form action="search.do" method="post" id="mem_search_frm" >
			<input type="hidden" name="mem_search" />
			<input type="hidden" name="search_target" id="search_target" />
			<input type="radio" title="이메일로 찾기" alt="이메일로 찾기" value="1" class="btn_global " id="mem_search_chk1" name="mem_search_chk">
			<label for ="mem_search_chk1" >이메일</label>
			<input type="radio" title="번호로 찾기" alt="번호로 찾기" value="2" class="btn_global " id="mem_search_chk2" name="mem_search_chk" >
			<label for ="mem_search_chk2" >번호</label>
			
			<div class="login_div">
				<div>
					<div class="id_area">
						<div class="input_row" id="id_area">
							<span class="input_box">
								<c:choose>
									<c:when test="${sessionScope.mem_search == 1 and sessionScope.user_id == null}">
										<input type="text" id="join_user_name" name="search_user_name" placeholder="이름" class="login_input" maxlength="15">
									</c:when>
									<c:when test="${sessionScope.mem_search == 2 and sessionScope.user_id == null}">
										<input type="text" id="join_user_id" name="search_user_id" placeholder="아이디" class="login_input" maxlength="20" >
									</c:when>
								</c:choose>
							</span>
						</div>
					</div>
					<div class="search_area">
						<div class="input_row" id="pw_area">
							<span class="input_box">
								<input type='text' id='join_user_email' class='user_select login_input' name='user_email' placeholder='abc@gmail.com' class='login_input' maxlength='50'>
							</span>
						</div>
					</div>
					
				</div>
				<div class = "join_div"> 
					<c:choose>
						<c:when test="${sessionScope.mem_search == 1 and sessionScope.user_id == null}">
							<input type="button" title="아이디 찾기" alt="아이디 찾기" value="아이디 찾기" class="btn_global join_btn" id="mem_id_search" >
						</c:when>
						<c:when test="${sessionScope.mem_search == 2 and sessionScope.user_id == null}">
							<input type="button" title="비밀번호 찾기" alt="비밀번호 찾기" value="비밀번호 찾기" class="btn_global join_btn" id="mem_pwd_search" >
						</c:when>
					</c:choose>
				</div>
			</div>
		
		</form>
		
		</div>
	</div>
	</section>
		<%@ include file="/WEB-INF/templates/footer.jsp"  %>
</body>
</html>