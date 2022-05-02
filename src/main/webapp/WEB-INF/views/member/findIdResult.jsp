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
	rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../temp/header.jsp"></c:import>

		<div class="container">
			<h1>
			 <spring:message code="${member!=null? 'member.findId.success':'member.findId.failed'}" arguments="${member.id}"></spring:message>
			</h1>
		</div>
		
	<c:import url="../temp/header_script.jsp"></c:import>

</body>
</html>