$(document).ready(function() {
	
	

	
	/*할일넣기*/
	$('#insert_btn').click(function(){
	
	if($('#text_set').val().length == 0){
		alert("할일을 입력해주세요.");
		$("#text_set").focus();
		return false;
	}
	if($('#text_set').val().length > 15){
		alert("15자 이내 작성해주세요.");
		$("#text_set").focus();
        return false;
	}
	
	var size = $("#size option").size();
	if(size > 4) {	
		alert("할일은 5개까지만 등록가능 합니다.");
		$("#text_set").focus();
		return false;
	}
	
	});
	

	
	
	
	
	/*날짜검색버튼 달력 값 넘기기*/
	
	var date;
	$('#search_date').change(function (){
          date = $('#search_date').val();
          
    });
	
	$('#search_date_btn').click(function(){
		if(date == null){
			alert("날짜를 정해주세요");
			$("#search_date").focus();
			return false;
		}else{
			submit();
		}
	});
		
		
	
	
	
	
	
	
	
	
	

	
	

	
	

});	
	
	
	
