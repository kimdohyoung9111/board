<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%@ include file="/include/jQuery.jsp" %>
    
 <script>
 	$(function(){
 		// 만들기 버튼 클릭
	  	$('#addbtn').on('click', function(){
	  		document.location="${pageContext.request.contextPath}/board/nboardForm.jsp";
	  	})
 	})
 	
 </script>
</head>
<body>

	<div class="col-sm-3 col-md-2 sidebar">
         <ul class="nav nav-sidebar">
        	<!-- class="active" -->
           <%-- <li><a href="${pageContext.request.contextPath}/freeBoard">자유 게시판</a></li> --%>
           <c:forEach items="${nbList}" var="nbVO">
				    <li><a href="${pageContext.request.contextPath}/noticeBoard?nb_seq=${nbVO.nb_seq}">${nbVO.nb_name}</a></li>
	    	</c:forEach>
         </ul>
         <button id="addbtn" type="button" name="addbtn">만들기</button>
	</div>
        
</body>
</html>