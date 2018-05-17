<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login Screen</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath }/css/signin.css" rel="stylesheet">
    <%@ include file="/include/jQuery.jsp" %>
    <script type="text/javascript">
    $(function(){
    	if($('#userId').val() != ''){
    		alert("아이디를 다시 확인해주세요.");
    	}
    })
    </script>
  </head>

  <body>
	
    <div class="container">

      <form id="frm" class="form-signin" action="<%= request.getContextPath() %>/login" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
       
        <label for="userId" class="sr-only">UserId</label>
        <input type="text" id="userId" name="userId" class="form-control" placeholder="아이디를 입력해주세요" value="${userId }" required autofocus>
        
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="비밀번호를 입력해주세요" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" id="remember" name="remember" value="remember"> Remember me
          </label>
        </div>
        <button id="signinbtn" class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->

  </body>
</html>
