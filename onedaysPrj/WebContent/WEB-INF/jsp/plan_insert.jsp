<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


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
		
		

		
	<form action="plan_insert_search.do" method="post" id="frm_submit">
		<div class="sideContext">
				<div class="plan_insert">
				  	<b>Plan Table</b>
	      			<div class="plan_insert_list">
	      				
	      				
	      					<!--컨트롤러로가서 처리해야함 -->
		      		     <h1>진행중</h1><span class="dateSelet"><input name="search_date" id="search_date" type="date" style="width: 150px;" value="${insert_date}"><button class="dateBtn" id="search_date_btn">검색하기</button></span>
		
		       			 <ul class="plan_insert_context">  	 <!-- 총5개이후 할일이 너무많습니다. -->
		       			 		
		       			 		<c:forEach var="p_dto" items="${p_dto}">
		 
		       			 		<c:if test="${p_dto.work_end eq 1}">
								<!-- 맨위가 아닌 누른 버튼 기준으로 name값 보내기
									위치찾아서 name값을 해당 위치값 전송으로 바꿈 -->
								
								
								<li id="list" class="plan_insert_list_item">
								
								<input type="hidden" value="${p_dto.work_start}" name="ws"/>
								<input type="hidden" value="${p_dto.work_end}" name="we"/>
								<input type="hidden" value="${p_dto.planDate}" name="pd"/>
								${p_dto.work_start}								
								</li>		
								</c:if>
								</c:forEach>
								<div class="ck_set_del">
								<select name="chk" class="del_chk" id="size">
								<c:forEach var="p_dto" items="${p_dto}">
								<c:if test="${p_dto.work_end eq 1}">
									<option>${p_dto.work_start}</option>
								</c:if>
								</c:forEach>
								</select>
								<button class="plan_insert_chk" formaction="plan_insert_chk.do">완료</button>
								<button class="plan_insert_del" formaction="plan_insert_del.do">삭제</button>
			       			 	</div>		      	  			      		          					
	        			</ul>
	        			<h1>완료</h1>
	        			<ul class="plan_insert_context">
	        					
	        					<c:forEach var="p_dto" items="${p_dto}">
								
								<c:if test="${p_dto.work_end eq 2}">
									
								 <li class="plan_insert_finish_item">${p_dto.work_start}</li>
								
								</c:if>
						
 								
						
								</c:forEach>
        					  
	        			</ul>
	        			<div class="plan_insert_input"><!-- input-container -->
		      		    	 <input type="text" class="plan_insert_text" id="text_set" name="text_set" placeholder="15자 이내 작성해주세요" />
		      		    	 <button class="plan_insert_add" id="insert_btn" formaction="plan_insert_set.do" >작성하기</button> 
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