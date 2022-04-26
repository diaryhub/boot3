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
		<form action="./add" method="post" class="border row"
			enctype="multipart/form-data">

			<div class="row">
				<div class="col"></div>
				<div class="col-8">
					<label class="mt-5">Product Name</label>
					<div class="justify-content-center my-2">
						<input id="productName" name="productName" class="form-control"
							style="width: 100%">

					</div>
					<label class="my-2">Product Price</label>
					<div class="justify-content-center">
						<input id="productPrice" name="productPrice" class="form-control"
							style="width: 100%">
					</div>
					<label class="my-2">Product Count</label>
					<div class="justify-content-center">
						<input id="productCount" name="productCount" class="form-control"
							style="width: 100%">
					</div>
					<label class="my-2">Detail</label>
					<div class="justify-content-center">
						<textarea id="summernote" name="productDetail"
							class="form-control" style="width: 100%;"></textarea>
					</div>
						<div id="fileResult"></div>
					 <div class="justify-content-end my-3 d-block">
						<button id="fileAdd" type="button" class="btn btn-danger d-block">FILE-ADD</button>
					</div>
				</div>
				<div class="col"></div>
			</div>

			<div class="row justify-content-center">
				<div class="col-1 my-4">
					<button type="button" id="add" class="btn btn-primary">ADD</button>
				</div>
			</div>
		</form>

	</div>

	<script type="text/javascript">

	
		//list ajax url: ajaxList, Get
		let pn=1;
		getList(pn);
		$('#summernote').summernote({
			height : 400
		});

		let count = 0;
		$("#fileAdd").click(
			function() {
				if (count > 4) {
					alert('최대 5개만 가능');
					return;
				}
				let result = '<div class="input-group mt-2">';
				result = result + '<input class="form-control files" type="file" name="files">';
				result = result + '<button class="btn btn-outline-secondary del" type="button">delete</button>';
				result = result + '</div>';
				$("#fileResult").append(result);
				count++;
			});

		$('#fileResult').on("click", ".del", function() {
			$(this).parent().remove();
			count--;
		});

		$('#add').click(function() {
			let formData = new FormData();
			let productName = $('#productName').val();
			let productPrice = $('#productPrice').val();
			let productCount = $('#productCount').val();
			let productDetail = $('#summernote').summernote("code");
			
			$('.files').each(function(idx,item){
				console.log(idx);				//index 번호
				console.log(item);				//<input type="file">
				console.log(item.files);		//input 태그의 file List
				console.log(item.files[0]);		//file List중 첫번째 파일
				console.log(item.files[0].name); //file List중 첫번째 파일의 이름
				console.log(item.files.length);
				//formData.append("파라미터명",값);
				formData.append("files",item.files[0]);
			});
			
			formData.append("productName",productName);
			formData.append("productPrice",productPrice);
			formData.append("productCount",productCount);
			formData.append("productDetail",productDetail);
			
			 $.ajax({
				method : "POST",
				url : "./add",
				processData:false,
				contentType:false,
				data : formData
			 /* {
					productName : productName,
					productPrice : productPrice,
					productCount : productCount,
					productDetail : productDetail
					
				} */,
				success : function(data) {
					if (data.trim() == '1') {
						alert("상품 등록 완료");
						$('#productName').val("");
						$('#productPrice').val("");
						$('#productCount').val("");
						$('#summernote').val("");
						getList();
					} else {
						alert("상품 등록 실패");
					}
				},
				error : function() {
					alert("에러");
				}
			}); 

		});
		function getList(pn) {

			$.ajax({
				method : "GET",
				url : "./ajaxList",
				data: {
					pn:pn,
					perPage:5
					},
				success : function(data) {
					$("#list").html(data.trim());
				},
				error : function() {
					alert("에러");
				}
			});

		};
		
		$("#list").on("click",".pager",function(){
			let checkPn=$(this).attr("data-pn");
			if(checkPn>0){
				pn=checkPn;
				getList(checkPn);
			}
			else{
				alert("마지막페이지입니다.");
			}
		});
	</script>

</body>
</html>







