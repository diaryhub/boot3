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
	<div class="container">
		<c:import url="../common/productList.jsp"></c:import>
		<form action="./manage" id="frm">
			<input type="hidden" name="pn" id="pn" value="${pager.pn}">
		</form>
		<a type="button" class="btn btn-primary col-1" href="./add">ADD</a>
		
	</div>



	<c:import url="../temp/header_script.jsp"></c:import>


	<script type="text/javascript">
		$('.pager').click(function() {
			let pn = $(this).attr("data-pn");
			$('#pn').val(pn);
			$('#frm').submit();
		});
		
		$('.detail').click(function(){
			let num = $(this).attr("data-num");
			location.href="./manageDetail?productNum="+num;
		});
		
	</script>

</body>
</html>