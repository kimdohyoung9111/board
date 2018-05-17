<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>BoardVO</title>

    <!-- Bootstrap core CSS -->
    <link href="/jsp/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/jsp/css/dashboard.css" rel="stylesheet">

    <%@ include file="/include/jQuery.jsp" %>
    <script>
    	$(function(){
    		if($('#mem_id').val().trim() == "${boardVO.reg_id}"){
    			$('#modifyBoard').attr('type', 'button');
    			$('#deleteBoard').attr('type', 'button');
    		}
    		
    		$('#modifyBoard').on('click', function(){
    			$('#frm').attr('action', "${pageContext.request.contextPath }/modifyBoard");
				$('#frm').attr('method', 'get');
				$('#frm').submit();
    		})
    		
    		$('#deleteBoard').on('click', function(){
    			$('#frm').attr('action', "${pageContext.request.contextPath }/deleteBoard");
				$('#frm').attr('method', 'post');
				$('#frm').submit();
    		})
    		
    		$('#replyWrite').on('click', function(){
    			$('#frm').attr('action', "${pageContext.request.contextPath }/insertReply");
				$('#frm').attr('method', 'post');
				$('#frm').submit();
    		})

    		$('#reply button').on('click', function(){
    			var reply_seq = $(this).val();
    			$('#reply_seq').val(reply_seq);
    			$('#frm').attr('action', "${pageContext.request.contextPath }/deleteReply");
				$('#frm').attr('method', 'post');
				$('#frm').submit();
    		})
    		
    		
    	})
    </script>
</head>
<body>
	<%@ include file="/layout/header.jsp" %>
	
    <div class="container-fluid">
      <div class="row">
        <%@ include file="/layout/left.jsp" %>
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        
			<form id="frm" class="form-horizontal" role="form" method="post">
				<input type="hidden" id="board_seq" name="board_seq" value="${boardVO.board_seq}">
				<input type="hidden" id="mem_id" name="mem_id" value="${userVO.mem_id}">
				<input type="hidden" id="reply_seq" name="reply_seq" value="">
		
				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">제목</label>
					<label for="userNm" class="col-sm-2 control-label">${boardVO.title }</label>
					<label for="userNm" class="col-sm-2 control-label">작성자</label>
					<label class="control-label">${boardVO.reg_id }</label>
				</div>
		
				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">내용</label>
					<div class="col-sm-10">
						<label class="control-label">${boardVO.content }</label>
					</div>
				</div>
		
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input id="modifyBoard" type="hidden" name="modifyBoard" class="btn btn-default" value="글 수정">
						<input id="deleteBoard" type="hidden" name="deleteBoard" class="btn btn-default" value="글 삭제">
					</div>
				</div>
				<hr>
						<!-- 댓글리스트 -->
				<c:forEach items="${replyList}" var="replyVO">
					<div class="form-group">
						<div id="reply" class="col-sm-offset-2 col-sm-10">
							<label for="userNm" class="col-sm-2 control-label">${replyVO.reply_content}</label>
							<label for="userNm" class="col-sm-2 control-label">작성자 : </label>
							<label class="control-label">${replyVO.mem_id }</label>
							<label class="control-label">   /   </label>
							<label class="control-label"><fmt:formatDate value="${replyVO.reply_dt}" pattern="yyyy-MM-dd HH:mm:ss"/></label>
							<c:if test="${userVO.mem_id == replyVO.mem_id}">
								<button type="button" class="btn btn-sm" value="${replyVO.reply_seq}">삭제</button>
							</c:if>
						</div>
					</div>
				</c:forEach>
				
				<!-- 댓글 -->
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<textarea rows="1" cols="70" name="reply_content"></textarea>
						<button id="replyWrite" type="button" class="btn btn-sm">댓글쓰기</button>
					</div>
				</div>
			
			</form>
			
			
		</div>
	  </div>
	</div>
</body>
</html>