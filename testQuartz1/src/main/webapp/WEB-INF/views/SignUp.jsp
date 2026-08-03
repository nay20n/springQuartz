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
	<title>회원가입</title>
	<style>
		form > input:nth-child(1) {
			margin-left: 23px;
		}
		form > input:nth-child(3) {
			margin-left: 16px;
		}
		form > * {
			margin-bottom: 3px;
		}
		form > input:last-child {
			width: 195px;
		}
	</style>
</head>
<body>
	<h1>회원가입</h1>
	<form method="post">
		ID: <input type="text" name="id"/> <br/>
		PW: <input type="password" name="pw"/> <br/>
		Name: <input type="text" name="name"/> <br/>
		<input type="submit" value="작성완료"/>
	</form>
</body>
</html>