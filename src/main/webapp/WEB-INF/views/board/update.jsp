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
		<div class="row">
			<form action="./update" method="post" class="border row">
				<input type="hidden" name="num" value="${vo.num}">
					<label>title</label>
					<div>
						<input class="form-control" name="title" value="${vo.title}">
					</div>
					<label>contents</label>
					<div>
						<textarea class="form-control" rows="5" cols="22" name="contents">${vo.contents}</textarea>
					</div>
				<div class="row justify-content-center">
					<div class="col-3 my-4">
						<button type="submit" class="btn btn-primary">UPDATE</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<c:import url="../temp/header_script.jsp"></c:import>
</body>
</html>