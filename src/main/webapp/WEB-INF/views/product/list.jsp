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
				<h4 style="text-transform: capitalize;">Product List</h4>
			</div>
		</div>
		<div class="row mt-4">

			<c:forEach items="${list}" var="f">
				<div class="card" style="width: 18rem;">
					<img src="../resources/upload/product/${f.filesVOs[0].fileName}"
						class="card-img-top">
					<div class="card-body">
						<h5 class="card-title">${f.productName}</h5>
						<p class="card-text">${f.productPrice}</p>
						<a href="./detail?productNum=${f.productNum}" class="btn btn-primary">Go somewhere</a>
					</div>
				</div>

			</c:forEach>

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
			<form class="d-flex">
				<div class="btn-group">
					<button type="button" class="btn btn-danger dropdown-toggle"
						data-bs-toggle="dropdown" aria-expanded="false">Action</button>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item">Action</a></li>
						<li><a class="dropdown-item">Another action</a></li>
						<li><a class="dropdown-item">Something else here</a></li>
					</ul>
				</div>
				<input class="form-control me-2" type="search" placeholder="Search"
					aria-label="Search" name="search" style="width: 20%">
				<button class="btn btn-outline-success" type="submit">Search</button>
			</form>
		</div>

	</div>

	<c:import url="../temp/header_script.jsp"></c:import>
</body>
</html>