<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<title>Hello, world!</title>
</head>
<body>
	<c:import url="../temp/header.jsp"></c:import>
	<div class="container">

		<h1>ERROR!!!</h1>
		<h1>${message}</h1>
	</div>

	<c:import url="../temp/header_script.jsp"></c:import>
</body>
</html>


















