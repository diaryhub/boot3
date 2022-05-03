<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<div class="container text-center my-5">
		<h3>OneChou</h3>
		<div class="row">
			<div class="col"></div>
			<div class="col-6">
				<div class="mb-5 mt-3 border border-2 rounded">
					
					<form:form modelAttribute="memberVO" action="./login" method="post" class="my-5">
						<input type="hidden" name="connectionPath"
							value="${connectionPath}">
						<div class="row">
							<div class="col"></div>
							<div class="col-8">
								<fieldset>
									<legend>아이디</legend>
									<%-- <input type="text" class="form-control my-3" name="id"
										value="${cookie.remember.value}"> --%>
									<form:input path="id" cssClass="form-control my-3" id="id"/>
									<form:errors path="id"></form:errors>
								</fieldset>

								<fieldset>
									<legend>비밀번호</legend>
									<!-- <input type="password" class="form-control my-3" name="pw"> -->
									<form:password path="pw" cssClass="form-control my-3"/>
									<form:errors path="pw" cssStyle="color:red;"></form:errors>
								</fieldset>
								<!-- <div>
									<fieldset class="text-end">
										아이디 기억하기 <input type="checkbox" name="remember"
											id="rememberId" value="1">
									</fieldset>
								</div> -->
								<div class="d-flex justify-content-between align-items-end mt-4">
									
										<span> 아직 회원이 아니신가요? <a href="./join">회원가입</a>
										</span>
									
									
									<span>
										<button type="submit" class="btn btn-outline-primary">LOGIN</button>
									</span>
									

								</div>
									<div class="d-flex justify-content-between align-items-end mt-4">
										<span> ID를 잊어버리셨나요?
											<a href="./findId">
											<button type="button" class="btn btn-danger">ID찾기</button>
											</a>
										</span>
									</div>
							</div>
							<div class="col"></div>
						</div>
					</form:form>
				</div>
			</div>
			<div class="col"></div>
		</div>
	</div>
	<c:import url="../temp/header_script.jsp"></c:import>
</body>
</html>