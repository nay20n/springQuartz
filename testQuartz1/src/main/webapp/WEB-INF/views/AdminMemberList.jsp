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
	<title>회원목록</title>
	<style>
		body > h1:nth-child(1) {
			display: inline-block;
		}
		#loginBtn {
			display: inline-block;
		    margin-top: 28px;
		    position: absolute;
   			right: 69px;
		}
		table { 
			border-collapse : collapse;
		    margin: auto;
		}
		td, th { 
			width: 110px;
			border: 1px solid lightgrey;
		    text-align: center;
		}
	</style>
	<script type="text/javascript" src="resources/js/jquery-4.0.0.min.js"></script>
	<script>
		$(function(){
			$("#loginBtn").click(function() {
				location.href="Login";
			});
			$(".modify").click(function() {
				let id = $(this).parent().parent().find(".id").text();
				location.href="modifyMember?id=" + id;
			});
			$(".delete").click(function() {
				let id = $(this).parent().parent().find(".id").text();
				location.href="deleteMember?id=" + id;
				alert("삭제되었습니다.");
			});
			$("#btn_startScheduler").click(function(){
				//alert("스케줄러 버튼 클릭");
				location.href="startScheduler";
			});
			$("#btn_endScheduler").click(function(){
				location.href="endScheduler";
			});
		});
	</script>
</head>
<body>
	<h1>회원관리</h1>
	<button id="loginBtn">로그인</button>
	<div id="tableDiv">
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>PW</th>
					<th>Name</th>
					<th>Point</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${dtos}">
					<tr>
						<td class="id">${dto.id}</td>
						<td>${dto.pw}</td>
						<td>${dto.name}</td>
						<td>${dto.point}</td>
						<td><button class="modify">수정</button></td>
						<td><button class="delete">삭제</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<h1>스케줄러관리</h1>
	<button id="btn_startScheduler">스케줄러(20초마다 포인트 1증가) 실행 시작</button>
	<button id="btn_endScheduler"> 스케줄러 실행 종료</button>
</body>
</html>