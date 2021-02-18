$(document).ready(function(){
	
	var mem_form = document.getElementById("frm_mem");
	var mod_form = document.getElementById("mod_frm");
	
	// 검사 필터
	var num = /[0-9]/g;
	var eng = /[a-z]/ig;
	var spe= /[`~!@#$%^&*|\\\'\";:\/?]/gi;
	var kor = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
	
	
	/* 유효성 검사 */
	function checkAll(){
		if(!checkId()){
			return false; 
		}
		
		if(!checkPwd())	{
			return false; 
		}
	
		if(!checkName()){
			return false;
		};
		
		if(!checkNick()){
			return false;
		};
		
		if(!checkEmail()){
			return false;
		};
		
		if(!checkPhone()){
			return false;
		};
		
		if(!checkGen()){
			return false;
		};
		
		if(!checkBirth()){
			return false;
		};
		
		return true;
	}
	
	// 아이디 검사
	function checkId() {
        //Id가 입력되었는지 확인하기
		var userid =  $("#join_user_id").val();
        if(userid.length == 0){
        	alert("아이디를 입력해주세요.");
        	$("#join_user_id").focus();
            return false;
        }
        
        var idRegExp = /^[a-zA-z0-9]{4,12}$/; //아이디 유효성 검사
        if (!idRegExp.test(userid)) {
            alert("아이디는 영문 대소문자 또는 숫자 4~12자리로 입력해야합니다!");
        	$("#join_user_id").val("");
        	$("#join_user_id").focus();
            return false;
        }

		//console.log('아이디');
        return true; //확인이 완료되었을 때
    }	// 아이디 검사 
	
	// 비밀번호 검사
	function checkPwd(){
		 
		var pwd = $("#join_user_pwd").val();
		
		 if(pwd.length == 0){
			alert("비밀번호를 입력해주세요.");
			$("#join_user_pwd").val("");
			$("#join_user_pwd").focus();
			return false;
		 }else if(pwd.length < 8 || pwd.length > 15){
			  alert("비밀번호 8자리 ~ 15자리 이내로 입력해주세요.");
			  $("#join_user_pwd").val("");
			  $("#join_user_pwd").focus();
			  return false;
		 }else if(pwd.search(/\s/) != -1){
			  alert("비밀번호는 공백 없이 입력해주세요.");
			  $("#join_user_pwd").val("");
			  $("#join_user_pwd").focus();
			  return false;
		 }else if(!num.test(pwd) || !eng.test(pwd) || !spe.test(pwd) ){
			  alert("영문,숫자, 특수문자를 혼합하여 입력해주세요.");
			  $("#join_user_pwd").val("");
			  $("#join_user_pwd").focus();
			  return false;
		 }else { 
				//console.log('비번');
		    return true;
		 }
	}	// 비번 검사
	
	// 비번 중복 체크
	function checkPwChk(){
		var pwd = $("#join_user_pwd").val();
		var pwchk = $("#join_user_pwd_chk").val();
		
		if(pwd != pwchk){
			alert("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
			$("#join_user_pwd").val("");
			$("#join_user_pwd_chk").val("");
			$("#join_user_pwd").focus();
			return false;
		}else{

			//console.log('비번중복체크');
			
			return true;
		}
		
	}	// 비번 중복 체크
	
	// 이름 검사 
	function checkName(){
		
		var name = $("#join_user_name").val();
		
		if(name.length == 0){
			alert("이름을 입력해주세요.");
			$("#join_user_name").val("");
        	$("#join_user_name").focus();
			return false;
		}else if(name.search(/\s/) != -1){
			alert("이름은 공백 없이 입력해주세요.");
			$("#join_user_name").val("");
        	$("#join_user_name").focus();
			return false;
		}else if(num.test(name) || spe.test(name)){
			alert("이름에 숫자와 특수문자는 사용 불가합니다.");
			$("#join_user_name").val("");
        	$("#join_user_name").focus();
			return false;
		}else {
			//console.log('이름');
			return true;
		
		}	
	}	// 이름 검사 
	
	// 닉네임 검사
	function checkNick(){
		
		var nick = $("#join_user_nick").val();
		if(nick.length == 0){
			alert("닉네임 입력해주세요.");
        	$("#join_user_nick").focus();
        	return false;
		}else if(nick.length < 4 || nick.length > 10){
			alert("닉네임 4자리 ~ 10자리 이내로 입력해주세요.");
			$("#join_user_nick").val("");
        	$("#join_user_nick").focus();
			return false;
		}else if(nick.search(/\s/) != -1){
			alert("닉네임은 공백 없이 입력해주세요.");
			$("#join_user_nick").val("");
        	$("#join_user_nick").focus();
			return false;
		}else if(spe.test(nick)){
			alert("닉네임에 특수문자는 사용 불가합니다.");
			$("#join_user_nick").val("");
        	$("#join_user_nick").focus();
			return false;
		
		}else {
			//console.log('닉네임');
			return true;
		}
	}	// 닉네임 검사 
	
	
	// 전화번호 검사
	function checkPhone(){
		
		var phone = $("#join_user_phone").val();
		var regExp = /(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})/g;
		
		if(phone.length == 0){
			alert("전화번호는 반드시 입력해야합니다.");
        	$("#join_user_phone").focus();
			return false;
		}else if(phone.length < 8 || phone.length > 11 ){
			alert("전화번호는 최소 8자리부터 최대 11자리를 입력할 수 있습니다.");
			$("#join_user_phone").val("");
        	$("#join_user_phone").focus();
			return false;
		}else if(phone.search(/\s/) != -1){
			alert("전화번호는 공백 없이 입력해주세요.");
			$("#join_user_phone").val("");
        	$("#join_user_phone").focus();
			return false;
		}else if(kor.test(phone) || eng.test(phone) || spe.test(phone) ){
			  alert("한글 ,숫자, 특수문자는 입력할 수 없습니다.");
			  $("#join_user_phone").val("");
			  $("#join_user_phone").focus();
			  return false;
		}else if(!regExp.test(phone)){
			alert("정확한 전화번호를 입력해주세요.");
			$("#join_user_phone").val("");
        	$("#join_user_phone").focus();
			return false;
		}else {
			//console.log('번호');
			return true;
		}
	}	// 전화번호 검사 
	
	// 이메일 검사 
	function checkEmail(){   
		var email = $("#join_user_email").val();
	    var reg_email = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	   
	    if(email.length == 0){
	    	alert("이메일은 반드시 작성해야 합니다.");
			$("#join_user_email").val("");
        	$("#join_user_email").focus();
	    	return false;
	    }else if(!reg_email.test(email)){
	    	alert("이메일 형식이 잘못 됬습니다. 다시 입력해주세요.");
			$("#join_user_email").val("");
        	$("#join_user_email").focus();
	    	return false;
	    	
	    }else{

			//console.log('이메일');
	    	return true;
	    }            
	    
	}	// 이메일 검사   
	
	// 성별 검사
	function checkGen(){
		var gen = $("input[name='user_gen']:checked").val();
		
		if(gen == undefined){
			alert("성별을 선택해주세요.");
        	$("input[name='user_gen']").focus();
			return false;
		}else{
			//console.log('성별');
			return true;
		}
		
	} 
	
	function checkBirth(){

		var birth_date = $("#join_user_birth").val();
		
		if(birth_date == 0 ){
			alert("생년월일은 반드시 입력해야합니다.");
        	$("#join_user_birth").focus();
			return false;
		}else if(birth_date.length != 8 ){
			alert("생년월일 8자리 입력해주세요.");
			$("#join_user_birth").val("");
        	$("#join_user_birth").focus();
			return false;
		}else if(birth_date.search(/\s/) != -1){
			alert("생년월일에 공백 없이 입력해주세요.");
			$("#join_user_birth").val("");
        	$("#join_user_birth").focus();
			return false;
		}else if(kor.test(birth_date) || eng.test(birth_date) || spe.test(birth_date) ){
			alert("생년월일에 특수문자, 한글, 영어는 사용 불가합니다.");
			$("#join_user_birth").val("");
        	$("#join_user_birth").focus();
			return false;
		
		}else {
			//console.log('생년월일');
			return true;
		}
		
	};
	

	/* 아이디 중복 확인 */
	$("#join_user_id").blur(function(){
		
		if(!checkId()){
			$("#id_chk").text("");
			return false;
		}
		var overlap = 1;
		
		var join_user_id = $("#join_user_id").val();
		
			$.ajax({
				type :"POST",
				url : "/join.do",	
				data : {join_user_id : join_user_id,
						overlap : overlap	},
				success : function(data) {
					if(data == 'ok'){
						$("#id_chk").text("사용가능한 아이디입니다.");
					}else if(data != 'ok'){
						$("#id_chk").text("사용 불가능한 아이디입니다.");
						$("#join_user_id").val("");
						$("#join_user_id").focus();
					}
					
				},error:function(data){
					console.log("error");
				}
			});
		
	});
	
	/*
	$("#join_user_pwd").blur(function(){
		if(checkPwd()){
			$("#pwd_chk").text("");
		}else{
			$("#pwd_chk").text("다시 입력해주세요.");
		}
		
	});
	
	$("#join_user_name").blur(function(){
		if(checkName()){
			$("#name_chk").text("사용 가능합니다.");
		}else{
			$("#name_chk").text("다시 입력해주세요.");
		}
		
	});
	*/
	
	/* 닉네임 중복 확인 */
	$("#join_user_nick").blur(function(){
		
		if(!checkNick()){
			$("#nick_chk").text("");
			return false;
		}

		var overlap = 1;
		
		var join_user_nick = $("#join_user_nick").val();
		
			$.ajax({
				type :"POST",
				url : "/join.do",	
				data : {join_user_nick : join_user_nick,
						overlap : overlap	},
				success : function(data) {
					if(data == 'ok'){
						$("#nick_chk").text("사용가능한 닉네임입니다.");
					}else if(data != 'ok'){
						$("#nick_chk").text("사용 불가능한 닉네임입니다.");
						$("#join_user_nick").val("");
						$("#join_user_nick").focus();
					}
					
				},error:function(data){
					console.log("error");
				}
			});
		
	});
	
	/* 전화번호 중복 확인 */
	$("#join_user_phone").blur(function(){
		
		if(!checkPhone()){
			$("#phone_chk").text("");
			return false;
		}

		var overlap = 1;
		
		var join_user_phone = $("#join_user_phone").val();
		
			$.ajax({
				type :"POST",
				url : "/join.do",	
				data : {join_user_phone : join_user_phone,
						overlap : overlap	},
				success : function(data) {
					if(data == 'ok'){
						$("#phone_chk").text("사용가능한 전화번호입니다.");
					}else if(data != 'ok'){
						$("#phone_chk").text("사용 불가능한 전화번호입니다.");
						$("#join_user_phone").val("");
						$("#join_user_phone").focus();
					}
					
				},error:function(data){
					console.log("error");
				}
			});
		
	});
	
	/* 이메일 중복 확인 */
	$("#join_user_email").blur(function(){
		
		if(!checkEmail()){
			$("#email_chk").text("");
			return false;
		}
		
		var overlap = 1;
		
		var join_user_email = $("#join_user_email").val();
		
			$.ajax({
				type :"POST",
				url : "/join.do",	
				data : {join_user_email : join_user_email,
						overlap : overlap	},
				success : function(data) {
					if(data == 'ok'){
						$("#email_chk").text("사용가능한 이메일입니다.");
					}else if(data != 'ok'){
						$("#email_chk").text("사용 불가능한 이메일입니다.");
						$("#join_user_email").val("");
						$("#join_user_email").focus();
					}
					
				},error:function(data){
					console.log("error");
				}
			});
		
	});
	
	/*
	$("#join_user_birth").blur(function(){
		if(checkBirth()){
			$("#birth_chk").text("사용 가능합니다.");
		}else{
			$("#birth_chk").text("다시 입력해주세요.");
		}
		
	});
	
	*/
	
	
	
	/* 버튼 클릭 모음 */
	
	/* 로그인 */
	if(getCookie("userInputId") && getCookie("userInputPw")){
		
		$("#user_id").val(getCookie("userInputId"));
		$("#user_pwd").val(getCookie("userInputPw"));
		$("input:checkbox[id='login_chk']").prop("checked",true);
	}
	
	$("#login_btn").click(function(){
		
		var userInputId = getCookie("userInputId");
		var userInputPw = getCookie("userInputPw");
		var setCookieYN = getCookie("setCookieYN");
		
		if(setCookieYN == 'Y') {
	        $("#id_chk").prop("checked", true);
	    } else {
	        $("#id_chk").prop("checked", false);
	    }

		if($("#login_chk").is(":checked")){
			var userInputId = $("#user_id").val(); 
			var userInputPw = $("#user_pwd").val();
			setCookie("userInputId",userInputId,60);
			setCookie("userInputPw",userInputPw,60);
			setCookie("setCookieYN","Y",60);
		}else{
			deleteCookie("userInputId");
			deleteCookie("userInputPw");
			deleteCookie("setCookieYN");
		}

		var user_id = $("#user_id").val();
		var user_pwd = $("#user_pwd").val();
		
		$.ajax({
			url : "member.do",
			type : "post",
			data : { user_id : user_id, user_pwd : user_pwd},
			datatype : "text",
			success: function(data){
				if(data == 'no'){
					alert("로그인 실패했습니다. 다시 입력해주세요.");
					$("#user_id").val("");
					$("#user_pwd").val("");
				}else{
					$("#login_frm").action = "member.do";
					$("#login_frm").submit();
					
				}
			},error :function(data){

				alert("로그인 실패했습니다. 다시 입력해주세요.");
			}
		});
		
		
	});
	
	//쿠키값 Set
	function setCookie(cookieName, value, exdays){
	    var exdate = new Date();
	    exdate.setDate(exdate.getDate() + exdays);
	    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + 
	    exdate.toGMTString());
	    document.cookie = cookieName + "=" + cookieValue;
	}

	//쿠키값 Delete
	function deleteCookie(cookieName){
	    var expireDate = new Date();
	    expireDate.setDate(expireDate.getDate() - 1);
	    document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
	}

	//쿠키값 가져오기
	function getCookie(cookie_name) {
	    var x, y;
	    var val = document.cookie.split(';');
	    
	    for (var i = 0; i < val.length; i++) {
	        x = val[i].substr(0, val[i].indexOf('='));
	        y = val[i].substr(val[i].indexOf('=') + 1);
	        x = x.replace(/^\s+|\s+$/g, ''); // 앞과 뒤의 공백 제거하기
	        
	        if (x == cookie_name) {
	          return unescape(y); // unescape로 디코딩 후 값 리턴
	        }
	    }
	}

	// 아이디 찾기
	$("#id_search").click(function(){
		$("#login_frm").append("<input type='hidden' id='mem_search' name='mem_search' value='1' />");
		// console.log($("#mem_search").val());
		$("#login_frm").attr("action","/search.do");
		
		$("#login_frm").submit();
	});
	
	// 비밀번호 찾기
	$("#pw_search").click(function(){
		$("#login_frm").append("<input type='hidden' id='mem_search' name='mem_search' value='2' />");
		console.log($("#mem_search").val());
		$("#login_frm").attr("action","/search.do");
		
		
		$("#login_frm").submit();
		
	});
	
	// 이메일 또는 전화번호 선택 
	$("#mem_search_chk1").attr("checked",true);
		
	$("input[name='mem_search_chk']").change(function(){
		var mem_search_chk = $("input[name='mem_search_chk']:checked").val();
		
		if(mem_search_chk == 1){
			$(".search_area > div > span.input_box .user_select").remove();
			$(".search_area > div > span.input_box").append(
			"<input type='text' id='join_user_email' class='user_select login_input' name='user_email' placeholder='abc@gmail.com' class='login_input' maxlength='50'>");
			
			
		}else if(mem_search_chk == 2){
			$(".search_area > div > span.input_box .user_select").remove();
			$(".search_area > div > span.input_box").append(
					"<input type='text' id='join_user_phone' class='user_select login_input' name='user_phone' placeholder='휴대폰' class='login_input' maxlength='15'>");
		}
		
		
	});
	
	// 헤더 로그인
	$("#Login").on("click",function(){
		mem_form.submit();
		
	});
	
	// 헤더 회원가입
	$("#Join").on("click",function(){
		
		mem_form.action="/join.do";
		mem_form.submit();
		
	});
	
	/* 회원가입 버튼 */
	$("#join_btn").on("click",function(){
		if(checkAll()){
			$("#login_frm").submit();
		}
	});
	
	/* 아이디 찾기 */
	$("#mem_id_search").click(function(){
		$("#search_target").val("id");
		if($("input[name='mem_search_chk']:checked").val() == 1 ){
			$("input[name='mem_search']").val("1");
		}else{
			$("input[name='mem_search']").val("2");
		}
		
		$("#mem_search_frm").submit();
		
	});
	
	/* 비번 찾기 */
	$("#mem_pwd_search").click(function(){
		$("#search_target").val("pwd");
		if($("input[name='mem_search_chk']:checked").val() == 1 ){
			$("input[name='mem_search']").val("1");
		}else{
			$("input[name='mem_search']").val("2");
		}
		
		$("mem_search_frm").submit();
		
	});
	
	$("#Logout").on("click",function(){
		
		mem_form.para.value="logout";
		alert("로그아웃 처리되었습니다.");
		mem_form.submit();
		
	});
	
	
	$("#Mypage").on("click",function(){
		mem_form.para.value="mypage";
		mem_form.submit();	
		
	});
	
	/*추가한것*/
	$("#Mypage_li").on("click",function(){
		mem_form.para.value="mypage";
		mem_form.submit();	
		
	});
	$("#Mypage_btn").on("click",function(){
		mem_form.para.value="mypage";
		mem_form.submit();	
		
	});
	/*여기까지*/
	
	$("#mp_mod_btn").on("click",function(){
		mem_form.para.value="modify";
		
		mem_form.submit();
		
		
	});
	
	$("#mp_del_btn").on("click",function(){
		
		if(confirm("삭제한 정보는 돌릴 수 없습니다. 정말로 삭제하시겠습니까?(Y/N)")){
			mem_form.para.value="delete";
			mem_form.submit();
		}
		
		
	});
	
	$("#mem_mod_btn").on("click",function(){
		
		if(checkAll() && checkPwChk()){
			$("input[name='para']").val("mem_mod");
			mod_form.submit();
		}
		
		
	});	
	
});