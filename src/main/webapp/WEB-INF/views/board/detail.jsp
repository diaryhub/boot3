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
	<h1>Detail Page</h1>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col" class="col-2">${VO.num}</th>
					<th scope="col" class="col-4">${VO.title}</th>
					<th scope="col" class="col-2">${VO.writer}</th>
					<th scope="col" class="col-2">${VO.regDate}</th>
					<th scope="col" class="col-2">${VO.hit}</th>
				</tr>
			</thead>
		</table>
		<div class="border rounded my-1">
			<div class="my-2 mx-5">${VO.contents}</div>
			<c:forEach items="${VO.filesVOs}" var="f">
				<div class="my-2 mx-5">
					<a href="../resources/upload/board/${f.fileName}"> <img src="../resources/upload/board/${f.fileName}">
					</a>
					<a href="./fileDown?fileNum=${f.fileNum}">${f.fileName}</a>
				</div>
			</c:forEach>
			
		</div>


		<div class="d-flex justify-content-end mx-2">
			<a class="btn btn-primary mx-2" href="./update?num=${VO.num}">UPDATE</a>
			<a class="btn btn-primary mx-2" href="./delete?num=${VO.num}">DELETE</a>
		</div>
	</div>

	<c:import url="../temp/header_script.jsp"></c:import>
</body>
</html>