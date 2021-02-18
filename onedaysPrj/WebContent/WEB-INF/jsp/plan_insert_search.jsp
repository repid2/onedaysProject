<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
	Calendar cr = Calendar.getInstance();
	int year = cr.get(Calendar.YEAR);
	int month = cr.get(Calendar.MONTH);
	int date = cr.get(Calendar.DATE);
	int week = cr.get(Calendar.DAY_OF_WEEK );
	String today = year + "." +(month+1)+ "."+date; // 오늘 날짜
	// 1일부터 시작하는 달력을 만들기 위해 오늘의 연도,월을 셋팅하고 일부분은 1을 셋팅한다.
	cr.set(year, month, 1);			 
	// 셋팅한 날짜로 부터 아래 내용을 구함
						 
	// 해당 월의 첫날를 구함
	int startDate = cr.getMinimum(Calendar.DATE);
						 
	// 해당 월의 마지막 날을 구함
	int endDate = cr.getActualMaximum(Calendar.DATE);
						 
	// 1일의 요일을 구함
	int startDay = cr.get(Calendar.DAY_OF_WEEK);
	int count = 0;
	String yo=null;
	%>
	<%	 
	 switch(week){
	 	case 1:
	 		yo="Sunday";
	 		break;
		case 2:
			yo="Monday";
			break;
		case 3:
	 		yo="Tuesday";
			break;
	 	case 4:
	 		yo="Wednesday";
	 		break;
	 	case 5:
	 		yo="Thursday";
			break;
		case 6:
	 		yo="Friday";
	 		break;
	 	case 7:
	 		yo="Saturday";
	 		break;
	 	}	 			
	%>
	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/side.css" rel="stylesheet" />
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Stylish&display=swap" rel="stylesheet">

</head>
<body>
		<!-- header단 -->
		  <%@ include file="/WEB-INF/templates/header.jsp"  %>
	
	
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
                    <a href="https://www.facebook.com/"><img src="image/icon_facebook.png" alt="facebook"></a>
                </li>
                <li>
                    <a href="https://twitter.com/?lang=ko"><img src="image/icon_twitter.png" alt="twitter"></a>
                </li>
                <li>
                    <a href="https://www.instagram.com/"><img src="image/icon_insta.png" alt="instagram"></a>
                </li>
            </ul>
        </div>
		</aside>
		
		
	<form action="plan_insert_search.do" method="post">
		<div class="sideContext">
				<div class="plan_insert">
				  	<b>Plan Table</b>
	      			<div class="plan_insert_list">
	      			
	      					<!--컨트롤러로가서 처리해야함 -->
		      		     <h1>진행중</h1><span class="dateSelet"><input name="search_date" id="search_date" type="date" style="width: 150px;"><button class="dateBtn" id="search_date_btn">검색하기</button></span>
		
		       			 <ul class="plan_insert_context">  	 <!-- 총10개이후 할일이 너무많습니다. -->
				      		   <li id="list" class="plan_insert_list_item">날짜를 검색해주세요.</li>
				      		   
				      		          					
	        			</ul>
	        			<h1>완료</h1>
	        			<ul class="plan_insert_context">
        					   <li class="plan_insert_finish_item">날짜를 검색해주세요.</li>
	        			</ul>
	        			<div class="plan_insert_input"><!-- input-container -->
		      		    	 <input type="text" class="plan_insert_text" id="text" placeholder="15자 이내 작성해주세요" />
		      		    	 <button class="plan_insert_add" id="insert_btn">작성하기</button> 
		      		    	 <button type="reset" class="plan_insert_add">다시쓰기</button> 		
		      			</div>
		      		
    		 		</div>
   			 </div>
		</div>
	</form>	
	
	
	<!-- footer단 -->
		<%@ include file="/WEB-INF/templates/footer.jsp"  %>
	
</body>
</html>