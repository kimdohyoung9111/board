<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>BoardList</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">

    <%@ include file="/include/jQuery.jsp" %>
    <%@ include file="/include/commonCss.jsp" %>
    
    <script>
    	$(function(){
    		// tr 태그 click 이벤트 처리
    		$("#boardList tr").click(function(){
    			//alert($(this).find("input").val());
    			if($(this).find("input").val().trim() == "N"){
	    			var board_seq = $(this).find("td:eq(0)").text();
	    			$("#board_seq").val(board_seq);
	    			$("#frm").submit();
    			}
    		})
    		
	    	// 글쓰기버튼 클릭 이벤트
	    	$('#write').click(function(){
	    		document.location="${pageContext.request.contextPath}/SE2/index.jsp";
	    	})
    	})
    	
    </script>
  </head>
  
  <body>
	<%@ include file="/layout/header.jsp" %>
	
    <div class="container-fluid">
      <div class="row">
        <%@ include file="/layout/left.jsp" %>
        
        <form id="frm" method="get" action="${pageContext.request.contextPath }/getBoard">
			<input type="hidden" id="board_seq" name="board_seq">
		</form>
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

          <h2 class="sub-header">게시판 리스트</h2>
          
          <div class="table-responsive">
            <table class="table table-striped table-hover">
              <thead>
                <tr>
                  <th>번호</th>
                  <th>제목</th>
                  <th>작성자</th>
                  <th>일시</th>
                </tr>
              </thead>
              <tbody id="boardList">
                <c:forEach items="${boardList }" var="vo">
					<tr>
						<td>${vo.board_seq }</td>
						<td>${vo.title }</td>
						<td>${vo.reg_id }</td>
						<td><fmt:formatDate value="${vo.reg_dt }" pattern="yyyy-MM-dd"/></td>
						<td><input type="hidden" id="del_yn" value="${vo.del_yn }"></td>
					</tr>                
                </c:forEach>
              </tbody>
            </table>
          </div>
          
          <button id="write" type="submit" class="btn btn-default">글쓰기</button>
				<!-- pageNavigation -->
				${pageNav }
				
			</div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
