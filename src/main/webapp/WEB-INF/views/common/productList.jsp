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
				<th scope="col">Sale</th>

			</tr>
		</thead>
		<tbody>
<c:forEach items="${list}" var="vo">
			<tr>
				<th scope="row">${vo.productNum}</th>
				<c:choose>
				<c:when test="${member.id==vo.id}">
				<td class="detail" data-num="${vo.productNum}">${vo.productName}</a></td>
				</c:when>
				<c:otherwise>
				<td>${vo.productName}</td>
				</c:otherwise>
				</c:choose>
				<td>${vo.productPrice}</td>
				<td>${vo.productCount}</td>
				<td>${vo.sale==1? '판매중':'판매종료'}</td>
			</tr>

</c:forEach>
		</tbody>
	</table>

<nav aria-label="Page navigation example">
	<ul class="pagination">
		<li class="page-item"><a data-pn="${pager.pre? pager.startNum-1:1}" id="pre" class="page-link pager"
			href="#">&lt;</a></li>
		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			<li class="page-item"><a data-pn="${i}" id="list${i}" class="page-link pager"
				href="#">${i}</a></li>
		</c:forEach>
		<li class="page-item"><a data-pn="${pager.next? pager.lastNum+1:lastNum}" id="next" class="page-link pager"
			href="#">&gt;</a></li>
	</ul>
</nav>