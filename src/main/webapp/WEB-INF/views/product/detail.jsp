<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
	<c:import url="../temp/detail.jsp"></c:import>
	
	<div class="container">
		<h1> <spring:message code="product.detail.info" arguments="${vo.productPrice}; ${vo.productCount}" argumentSeparator=";">
		</spring:message> </h1>
	</div>
	
	<div class="container">
	<div class="d-flex justify-content-end mx-2">
			<a class="btn btn-primary mx-2" href="#">BUY</a>
			<button class="btn btn-info mx-2" id="cart" data-pn="${vo.productNum}">CART</button>
		</div>
	</div>
	
	<c:import url="../temp/header_script.jsp"></c:import>
	<script type="text/javascript" src="../js/cart.js"></script>
</body>
</html>