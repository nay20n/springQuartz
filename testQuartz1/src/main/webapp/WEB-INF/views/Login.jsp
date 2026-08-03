<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
 
<c:if test="${not empty msg}">
	<script>alert("${msg}");</script>
</c:if>
 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<style>
		form > input:nth-child(1) {
			margin-left: 8px;
		}
		form > * {
			margin-bottom: 3px;
		}
		form > input:nth-child(5),
		form > input:nth-child(7) {
			width: 182px;
		}
	</style>
	<script type="text/javascript" src="resources/js/jquery-4.0.0.min.js"></script>
	<script>
		$(function(){
			
			$("#signUpBtn").click(function() {
				location.href = "SignUp";
			});
		});
	</script>
	
</head>
<body>
	<h1>로그인</h1>
	<form method="post">
		ID : <input type="text" name="id"/> <br/>
		PW : <input type="password" name="pw"/> <br/>
		<input type="submit" value="로그인"/> <br/>
		<input type="button" value="회원가입" id="signUpBtn"/>
	</form>
	
</body>
</html>