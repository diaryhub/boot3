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
			<div class="col-4"></div>
			<form action="./add" method="post" class="col-4 border row"
				enctype="multipart/form-data">
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
				<input class="form-control" type="file" id="formFileMultiple" name="files"> 
				<input class="form-control" type="file" id="formFileMultiple" name="files">
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
	<c:import url="../temp/header_script.jsp"></c:import>
</body>
</html>