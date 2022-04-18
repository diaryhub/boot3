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
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../temp/header.jsp"></c:import>
	<div class="container my-5">
		<div class="row">
			<div class="col-4"></div>
			<form action="" method="post" class="col-4 border row">
				<div class="col"></div>
				<div class="col-6">
					<label>title</label>
					<div>
						<input name="title">
					</div>
					<label>writer</label>
					<div>
						<input name="writer">
					</div>
					<label>contents</label>
					<div>
						<textarea rows="5" cols="22" name="contents"></textarea>
					</div>
				</div>
				<div class="col"></div>
				<div class="row justify-content-center">
					<div class="col-1 my-4">
						<button type="submit" class="btn btn-primary">ADD</button>
					</div>
				</div>
			</form>
			<div class="col-4"></div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>