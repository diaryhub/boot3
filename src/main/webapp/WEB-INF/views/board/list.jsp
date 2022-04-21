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
	<div class="container mt-4">
		<div class="row mt-4">
			<div class="alert alert-primary" role="alert">
				<h4 style="text-transform: capitalize;">List</h4>
			</div>
		</div>
		<div class="row mt-4">
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Title</th>
						<th scope="col">writer</th>
						<th scope="col">hit</th>
						<th scope="col">regDate</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="f">
						<tr>
							<th scope="row" class="col-2">${f.num}</th>
							<td class="col-6"><a href="./detail?num=${f.num}">${f.title}</a></td>
							<td class="col">${f.writer}</td>
							<td class="col">${f.hit}</td>
							<td class="col">${f.regDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<nav aria-label="Page navigation example">
				<ul class="pagination">
						<li class="page-item"><a class="page-link"
							href="./list?pn=${pager.pre?pager.startNum-1:1}&kind=${kind}&search=${search}">&lt;</a></li>
					<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
						<li class="page-item"><a class="page-link"
							href="./list?pn=${i}&kind=${kind}&search=${search}">${i}</a></li>
					</c:forEach>
					<li class="page-item"><a class="page-link"
						href="./list?pn=${pager.next? pager.lastNum+1:pager.lastNum}&kind=${kind}&search=${search}">&gt;</a></li>
				</ul>
			</nav>
		</div>
		<div class="row justify-content-end">
			<a type="button" class="btn btn-primary col-1" href="./add">WRITE</a>
		</div>

	</div>

	<c:import url="../temp/header_script.jsp"></c:import>
</body>
</html>