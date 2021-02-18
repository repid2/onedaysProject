function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();

		reader.onload = function(e) {
			$('#View').attr('style', 'width: 320px;height:270px;display: inline');
			$('#View').attr('src', e.target.result);
			$('#delimg').attr('style','display:inline');
		}

		reader.readAsDataURL(input.files[0]);
	}
}
function alertLogin(){
	alert("로그인 해주세요");
	location.href='/member.do'
}
function DelURL() {
	$('#View').attr('style', 'width: 400px;height:270px;display: none;');
	$('#View').attr('src', "#");
	var t1=$('#imgView');
	t1.val("");
	$('#delimg').attr('style','display:none');
}

$(document).ready(function() {
	$(function() {
		$("#imgView").on('change', function() {
			readURL(this);
		});
	});
	$(function(){
		$("#delimg").click(function(){
			DelURL();
		})
	})
	$('#btn_submit').click(function() {
		if (!(document.capfrm.subject.value).trim()) {
			alert("제목을 입력해주세요");
			document.capfrm.subject.focus();
			return false;
		}
		viewsty = $('#View').css('display');
		ctn=$("#ctn_text").val();
		if (!ctn && viewsty == "none") {
			alert("내용을 입력해주세요");
			$('#ctn_text').focus();
			return false;
		}
		document.capfrm.action = '/register.do';
		document.capfrm.method = 'post';
		document.capfrm.submit();
	})
	
	$('#btn_reset').click(function() {
		document.capfrm.reset();  
	})
	
	/*$('#btn_back').click(function() {
		alert("뒤로가기");
		$(location).attr('replace','/list.do');
	})*/
	
	$(function(){
		const remove = document.getElementById('remove')
		const list = document.getElementById('list')
		const back= document.getElementById("btn_back");
		
		
		console.log(document.getElementById("btn_submit"));
		console.log(remove)
		console.log(list)
		console.log(back)
		
		if(back!=null){
			back.addEventListener("click", function(){
				window.history.replaceState("test",null,"/list.do");
				location.replace('/list.do');
			})
		}
		if(list!=null){
			list.addEventListener("click", function(){
				location.replace('/list.do')
			})
		
			//수정 버튼 이벤트
			modify.addEventListener("click", function(){
				document.getElementById('title').disabled=false
				document.getElementById('ctn_text').disabled=false
				document.getElementById('imgView').disabled=false
				document.getElementById("modBtn").style.display="block"
				document.getElementById('btn').style.display="none"
				$('#content').attr('contenteditable',true);
				$('#img_file').attr('style',"display:block");
				
			})
			
			//수정 완료
				
			document.getElementById('mod').addEventListener("click",function(){
				document.caplist.action = '/modify.do';
				document.caplist.method = 'post';
				document.caplist.encoding = 'multipart/form-data';
				document.caplist.submit();
			})
			
			//수정 취소
			document.getElementById('back').addEventListener("click",function(){
				document.getElementById('btn').style.display="block"
				document.getElementById("modBtn").style.display="none";
				document.getElementById('ctn_text').disabled=true
				document.getElementById('title').disabled=true
				document.getElementById('imgView').disabled=true
				$('#content').attr('contenteditable',false);
				$('#img_file').attr('style',"display:none");
				location.reload();
			})
		}
		//삭제
		if(remove!=null){
			remove.addEventListener("click", function() {
				if(!confirm("삭제하겠습니까?")) { return; }
				else{
					document.caplist.action = '/remove.do';
					document.caplist.method = 'post';
					document.caplist.submit();
				}
			})
		}
  	});
	
	$(function(){
		const removeResult = '${result }'
		if(removeResult == 'success') {
			alert('삭제 되었습니다.')
		} else if(removeResult=='fail') {
			alert('다시 시도하세요');
			return;
		}
	});
	
	$(function(){
		const modifyResult = '${modify }'
		if(modifyResult == 'success') {
			alert('수정 되었습니다.')
		} else if(modifyResult=='fail') {
			alert('다시 시도하세요');
			return;
		}
	});
	
	$("#month").on( "change", function() {
		var loc=this.value
			location.href='/list.do?month='+loc;
		});
});
