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
	<div class="container my-5">
		<div class="border border-2 rounded-3 m-5">
			<div class="text-center border-bottom border-2 p-4">
				<h3>기본정보를 수정해주세요</h3>
			</div>
			<form action="./update" method="post" id="updateForm">
			<input type="hidden" name="id" value="${vo.id}">
			<div class="mb-5">				
				
				<div class="row d-flex justify-content-center m-3 g-3">
					<div class="col-6">
					    <label for="inputName" class="form-label fw-bold">이름</label>
					    <input type="text" class="form-control" id="inputName" name="name" value="${vo.name}" placeholder="이름을 입력해주세요">
					    <div class="fs-6 text-danger" id="nameFeedback">
					    </div>
					</div>				
				</div>
				
				
				<div class="row d-flex justify-content-center mx-3 mt-3 g-3">
					<div class="col-6">
					    <label for="inputEmail" class="form-label fw-bold">이메일</label>
					    <input type="text" class="form-control" id="inputEmail" name="email" value="${vo.email}" placeholder="id@site.com의 형식으로 입력해주세요">
						<div class="fs-6 text-danger" id="emailFeedback">
						</div>
					</div>
				</div>

				<div class="row d-flex justify-content-center mx-3 mt-3 g-3">		
					<div class="col-6">
					    <label for="inputPhone" class="form-label fw-bold">전화번호</label>
					    <input type="text" class="form-control" id="inputPhone" name="phone" value="${vo.phone}" placeholder="숫자만 입력해주세요">
						<div class="fs-6 text-danger" id="phoneFeedback">
						</div>
					</div>
				</div>
				
			</div>
		<div class="text-center">
			<button class="btn btn-outline-secondary" id="updateBtn" type="submit">수정하기</button>
		</div>
			</form>
		</div>
	</div>
	
	<c:import url="../temp/header_script.jsp"></c:import>
</body>
</html>