<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

    <title>Create Notice Board</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">

<%@ include file="/include/jQuery.jsp" %>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	$(function(){
		
		// 게시판 등록 크릭
		$('#boardReg').on('click', function(){
			if($('#title').val().trim() == ""){
				alert("제목을 입력해주세요.");
				$('#title').focus();
				return false;
			}
			if($('#content').val().trim() == ""){
				alert("내용을 입력해주세요.");
				$('#content').focus();
				return false;
			}
			// submit
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
			<form id="frm" action="${pageContext.request.contextPath }/modifyBoard" method="post" class="form-horizontal" role="form" >
				<input type="hidden" id="board_seq" name="board_seq" value="${boardVO.board_seq}">
				
				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">제목</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="title" name="title"
							placeholder="제목을 입력하세요" >
					</div>
				</div>
				
				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">내용</label>
					<div class="col-sm-4">
						<textarea rows="20" cols="10" class="form-control" id="content" name="content" placeholder="내용을 입력하세요."></textarea>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button id="boardReg" type="button" class="btn btn-default">수정</button>
					</div>
				</div>
			</form>
		</div>
	  </div>
	</div>
</body>
</html>