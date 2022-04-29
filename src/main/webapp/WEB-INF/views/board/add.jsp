<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<c:import url="../temp/header_script.jsp"></c:import>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- include summerNote CSS/JS -->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

<title>Insert title here</title>
</head>
<body>
	<c:import url="../temp/header.jsp"></c:import>
	<div class="container my-5">

		<form action="./add" method="post" class="border row"
			enctype="multipart/form-data">

			<div class="row">
				<div class="col"></div>
				<div class="col-8">
					<label class="mt-5">title</label>
					<div class="justify-content-center my-2">
						<input name="title" class="form-control" style="width: 100%">
					</div>
					<label class="my-2">writer</label>
					<div class="justify-content-center">
						<input name="writer" value="${member.id}" readonly class="form-control" style="width: 100%">
					</div>
					<label class="my-2">contents</label>
					<div class="justify-content-center">
						<textarea name="contents" id="contents" class="form-control"
							style="width: 100%; height: 200px;"></textarea>
					</div>
					<div id="fileResult"></div>
					<div class="justify-content-end my-3 d-block">
						<button id="fileAdd" type="button" class="btn btn-danger d-block">FILE-ADD</button>
					</div>
				</div>
				<div class="col"></div>
			</div>

			<div class="row justify-content-center">
				<div class="col-1 my-4">
					<button type="submit" class="btn btn-primary">ADD</button>
				</div>
			</div>
		</form>

	</div>
	<script src="../js/boardAdd.js"></script>
	<script src="../js/fileAdd.js"></script>
	<script src="../js/summernote.js"></script>

</body>
</html>







