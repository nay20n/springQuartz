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
	<title>메인페이지</title>
	<style>
		h1 {
			display: inline-block;
		}
		#sideHeader {
			display: inline-block;
		    margin-top: 28px;
		    position: absolute;
   			right: 69px;
		}
		#main {
		    width: 852px;
		    margin: auto;
		}
		#imgs > div {
			display: inline-block;
    		text-align: center;
		}
		#imgs img {
			width: 270px;
			cursor:pointer;
		}
		#footer {
		    display: inline-block;
		    border: 1px solid lightgray;
		    position: absolute;
		    right: 94px;
		    margin-top: 47px;
		}
		#footer > img {
			cursor:pointer;
		}
	</style>
	<script type="text/javascript" src="resources/js/jquery-4.0.0.min.js"></script>
	<script>
		$(function(){
			// 원래의 포인트
			let point = ${dto.point};
			
			$("#logoutBtn").click(function() {
				location.href="Logout";
			});
			// 구매할 수 있는 컨텐츠 클릭 시 
			$("#imgs img").click(function() {
				let imgPoint = $(this).parent().find("span").attr("data-point");
				let imgContent = $(this).parent().find("span").attr("data-content");
				if(point >= imgPoint) { // 구매 가능할때 
					location.href="buyContent?addedPoints=" + addedPoints;
					alert("컨텐츠(" + imgContent + ")를 구매하였습니다.");
				} else { // 구매 불가능할 때
					alert("포인트가 부족합니다. 광고를 클릭하세요.");
				}
			});
			// 광고 클릭 시 
			$("#footer img").click(function(){
				let ranNum = Math.floor(Math.random() * 1000) + 1;
				location.href="getPoint?ranNum=" + ranNum;
				alert(ranNum + "점이 적립되었습니다.");				
				
			});
		});
	</script>
</head>
<body>
	<h1>메인페이지</h1>
	<div id="sideHeader">
		<b>${dto.name}(${dto.id})님 안녕하세요.</b>
		<button id="logoutBtn">로그아웃</button><br/> 
		<b data-point="">포인트 : ${dto.point}점</b>
	</div> 
	
	<div id="main">
		<h3>구입할 컨텐츠를 선택하세요.</h3>
		<div id="imgs">
			<div>
				<img src="resources/img/Intro_350_408.png"/><br/>
				<span data-content="intro" data-point="100000">100,000포인트</span>
			</div>
			<div>
				<img src="resources/img/Java_350_408.png"/><br/>
				<span data-content="java" data-point="500000">500,000포인트</span>
			</div>
			<div>
				<img src="resources/img/Cpp_350_408.png"/><br/>
				<span data-content="C++" data-point="300000">300,000포인트</span>
			</div>
		</div>
	</div>
	<div id="footer">
		<span>&lt; 광고 &gt; </span> <br/>
		<img src="resources/img/korea_it.png"/>
	</div>
</body>
</html>