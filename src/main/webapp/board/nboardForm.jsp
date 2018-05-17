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
    <link href="/jsp/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/jsp/css/dashboard.css" rel="stylesheet">

<%@ include file="/include/jQuery.jsp" %>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	$(function(){
		
			if($('#error').val() != ""){
				alert("같은 이름의 게시판이 있습니다.");
				return false;
			}
		
		// 게시판 등록 크릭
		$('#userReg').on('click', function(){
			if($('#nb_name').val().trim() == ""){
				alert("게시판 이름을 입력해주세요.");
				$('#nb_name').focus();
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
			<form id="frm" action="${pageContext.request.contextPath }/insertNboard" method="post" class="form-horizontal" role="form" >
				
				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">게시판 이름</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="nb_name" name="nb_name"
							placeholder="게시판 이름을 입력하세요">
						<input type="hidden" name="mem_id" value="${userVO.mem_id }">
						<input type="hidden" id="error" value="${error }">
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button id="userReg" type="button" class="btn btn-default">게시판 등록</button>
					</div>
				</div>
			</form>
		</div>
	  </div>
	</div>
</body>
</html>