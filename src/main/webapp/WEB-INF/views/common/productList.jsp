<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<table class="border table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Name</th>
				<th scope="col">Price</th>
				<th scope="col">Count</th>

			</tr>
		</thead>
		<tbody>
<c:forEach items="${list}" var="vo">
			<tr>
				<th scope="row">${vo.productNum}</th>
				<td>${vo.productName}</td>
				<td>${vo.productPrice}</td>
				<td>${vo.productCount}</td>
			</tr>

</c:forEach>
		</tbody>
	</table>

<nav aria-label="Page navigation example">
	<ul class="pagination">
		<li class="page-item"><a data-pn="${pager.pre? pager.startNum-1:0}" id="pre" class="page-link pager"
			href="#">&lt;</a></li>
		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			<li class="page-item"><a data-pn="${i}" id="list${i}" class="page-link pager"
				href="#">${i}</a></li>
		</c:forEach>
		<li class="page-item"><a data-pn="${pager.next? pager.lastNum+1:0}" id="next" class="page-link pager"
			href="#">&gt;</a></li>
	</ul>
</nav>