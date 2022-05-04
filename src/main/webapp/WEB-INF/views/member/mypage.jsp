<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../temp/header.jsp"></c:import>
	<div class="text-center my-5">
		<h5>내 정보</h5>
	</div>
	<div class="container border rounded my-5">
		<div>
			<ul class="list-group list-group-flush">
				<li class="list-group-item">아이디 : ${vo.id}</li>
				<li class="list-group-item">이름 : ${vo.name}</li>
				<li class="list-group-item">이메일 : ${vo.email}</li>
				<li class="list-group-item">전화번호 : ${vo.phone}</li>
				<c:if test="${not empty vo.memberFileVO.fileName}">
				<li class="list-group-item"> <img src="../resources/upload/member/${vo.memberFileVO.fileName}"> </li>
				</c:if>
			</ul>
		</div>
		<div class="d-flex justify-content-between mt-4 ">
			<a href="./update" class="btn btn-outline-secondary">내 정보 수정하기</a> 
			<a href="./delete" class="btn btn-outline-secondary">회원 탈퇴</a>
		</div>
	<div class="container">
		<div class="row">
			<button type="button" class="btn btn-primary" id="getList">GETLIST</button>
			<button type="button" id="delbtn">DELETE</button>
		</div>
	
	</div>

	</div>
	
	<c:import url="../temp/header_script.jsp"></c:import>
	<script src="../js/cart.js"></script>
	<script type="text/javascript">
		getList();
	</script>
</body>
</html>