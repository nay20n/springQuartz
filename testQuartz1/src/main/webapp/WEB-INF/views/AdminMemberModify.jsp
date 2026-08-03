<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원관리-수정</title>
	<style>
		form > input:nth-child(1) {
			margin-left: 25px;
		}
		form > input:nth-child(3) {
			margin-left: 17px;
		}
		form > input:nth-child(7) {
			margin-left: 4px;
		}
		form > * {
			margin-bottom: 3px;
		}
		form > input:last-child {
			width: 191px;
		}
	</style>
</head>
<body>
	<h1>회원관리-수정관리사</h1>
	<form action="modifyMember" method="post">
		ID <input type="text" value="${dto.id}" name="id" readonly/> <br/>
		PW <input type="text" value="${dto.pw}" name="pw"/> <br/>
		Name <input type="text" value="${dto.name}" name="name"/> <br/>
		point <input type="text" value="${dto.point}" name="point"/> <br/>
		<input type="submit" value="제출"/>
	</form>
</body>
</html>