<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<c:import url="../temp/header_script.jsp"></c:import>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- include summerNote CSS/JS -->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>



<title>Insert title here</title>
</head>
<body>
	<c:import url="../temp/header.jsp"></c:import>
	<div class="container my-5">
		<div class="row" id="list"></div>
		<form action="./update" method="post" class="border row"
			enctype="multipart/form-data">
			<input type="hidden" name="productNum" value="${vo.productNum}">
			<div class="row">
				<div class="col"></div>
				<div class="col-8">
					<label class="mt-5">Product Name</label>
					<div class="justify-content-center my-2">
						<input id="productName" name="productName" class="form-control"
							style="width: 100%" value="${vo.productName}">

					</div>
					<label class="my-2">Product Price</label>
					<div class="justify-content-center">
						<input id="productPrice" name="productPrice" class="form-control"
							style="width: 100%" value="${vo.productPrice}">
					</div>
					<label class="my-2">Product Count</label>
					<div class="justify-content-center">
						<input id="productCount" name="productCount" class="form-control"
							style="width: 100%" value="${vo.productCount}">
					</div>
					<label class="my-2">Detail</label>
					<div class="justify-content-center">
						<textarea id="contents" name="productDetail" class="form-control"
							style="width: 100%;"></textarea>
					</div>
					<div class="form-check">
						<input id="sale1" name="sale" value="1" class="form-check-input"
							${vo.sale eq 1? 'checked':''} type="radio"> <label
							id="sale1" class="my-2 form-check-label" for="flexRadioDefault1">판매</label>
					</div>
					<div class="form-check">
						<input id="sale2" name="sale" value="0" class="form-check-input"
							${vo.sale eq 0? 'checked':''} type="radio"> <label
							id="sale2" class="my-2 form-check-label" for="flexRadioDefault1">판매중지</label>
					</div>

					<div class="justify-content-end my-3 d-block">
						<button id="fileAdd" type="button" class="btn btn-danger d-block">FILE-ADD</button>
					</div>
					<div>
						<c:forEach items="${vo.filesVOs}" var="f">
							<h4>${f.oriName}
								<button class="btn btn-outline-secondary del" type="button"
									data-num="${f.fileNum}">DELETE</button>
							</h4>
						</c:forEach>
					</div>
					<div id="fileResult"></div>

				</div>
				<div class="col"></div>
			</div>

			<div class="row justify-content-center">
				<div class="col-1 my-4">
					<button type="submit" id="update" class="btn btn-primary">UPDATE</button>
				</div>
			</div>
		</form>

	</div>
	<script src="../js/fileAdd.js"></script>
	<script src="../js/summernote.js"></script>
	<script type="text/javascript">
			summernoteInit('contents','${vo.productDetail}');
			fileAddInit(${vo.filesVOs.size()});
			fileDeleteInit();
		</script>

</body>
</html>