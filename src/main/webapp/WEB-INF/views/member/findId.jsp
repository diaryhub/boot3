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
	<div class="container text-center my-5">
		<div class="row">
			<div class="col"></div>
			<div class="col-6">
				<div class="mb-5 mt-3 border border-2 rounded">

					<form action="./findId" method="post" class="my-5">
						<input type="hidden" name="connectionPath" value="${connectionPath}">
						<div class="row">
							<div class="col"></div>
							<div class="col-8">
								<fieldset>
									<legend>이메일을 입력하세요.</legend>
									<input type="text" class="form-control my-3" name="email">
								</fieldset>

								
								<div>
								</div>
								<div class="d-flex justify-content-between align-items-end mt-4">	
									<span>					
										<button type="submit" class="btn btn-outline-primary">확인</button>
									</span>
									
								</div>								
							</div>
							<div class="col"></div>
						</div>
					</form>
				</div>
			</div>
			<div class="col"></div>
		</div>
	</div>
	<c:import url="../temp/header_script.jsp"></c:import>
</body>
</html>