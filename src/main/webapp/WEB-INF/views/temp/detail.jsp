<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col" class="col-2">${vo.productNum}</th>
					<th scope="col" class="col-4">${vo.productName}</th>
					<th scope="col" class="col-2">${vo.productPrice}</th>
					<th scope="col" class="col-2">${vo.productCount}</th>
				</tr>
			</thead>
		</table>
		<div class="border rounded my-1">
			<c:forEach items="${vo.filesVOs}" var="f">
				<div class="my-2 mx-5">
					<a href="../resources/upload/product/${f.fileName}"> <img src="../resources/upload/product/${f.fileName}">
					</a>
				</div>
			</c:forEach>
			<div class="my-2 mx-5">${vo.productDetail}</div>
			
		</div>


		
	</div>
