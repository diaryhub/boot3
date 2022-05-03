<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<div class="container my-5">
		<div class="row">
			<div class="col-4"></div>
			<form:form modelAttribute="memberVO" action="./join" method="post" class="col-4 border row"
				enctype="multipart/form-data">
				<div class="col"></div>
				<div class="col-6">
					<label>ID</label>
					<div>
						<form:input cssClass="form-control" path="id" id="id"/>
						<form:errors path="id"></form:errors>
					</div>
					<label>PW</label>
					<div>
						<form:password cssClass="form-control" path="pw" id="pw"/>
						<form:errors path="pw"></form:errors>
					</div>
					<label>PW CHECK</label>
					<div>
						<form:password cssClass="form-control" path="checkPw" id="checkPw"/>
						<form:errors path="checkPw"></form:errors>
					</div>
					<label>NAME</label>
					<div>
						<form:input cssClass="form-control" path="name" id="name"/>
						<form:errors path="name"></form:errors> 
					</div>
					<label>EMAIL</label>
					<div>
						<form:input cssClass="form-control" path="email" id="email"/>
						<form:errors path="email"></form:errors>
					</div>
					<label>PHONE</label>
					<div>
						<form:input cssClass="form-control" path="phone" id="phone"/>
					</div>
					<div style="height: 30px"></div>
					<input class="form-control" type="file" id="formFileMultiple"
						name="file">

					<div>
						<input class="form-check-input" type="checkbox" value="1" id="checkAll"> 
						<label class="form-check-label" for="checkAll"> checkbox-ALL</label> 
						<div></div>
						<input class="form-check-input check" id="check1" type="checkbox" value="1"> 
						<label class="form-check-label" for="check1"> checkbox-1 </label> 
						<div></div>
						<input class="form-check-input check"  id="check2" type="checkbox" value="2">
						<label class="form-check-label" for="check2"> checkbox-2 </label> 
						<div></div>
						<input class="form-check-input check" id="check3" type="checkbox" value="3"> 
						<label class="form-check-label" for="check3"> checkbox-3 </label>
					</div>
				</div>
				<div class="col"></div>
				+
				<div class="row justify-content-center">
					<div class="col-1 my-4">
						<button type="submit" class="btn btn-primary">JOIN</button>
					</div>
				</div>
			</form:form>
			<div class="col-4"></div>
		</div>
	</div>
	<c:import url="../temp/header_script.jsp"></c:import>
	<script type="text/javascript">
		$('#checkAll').click(function() {
			$(".check").prop("checked",$("#checkAll").prop("checked"));
		});
		
		$('.check').on("click",function(){
			let check = true;
			
			$('.check').each(function(idx,item){
				if(!$(item).prop("checked")){
					check=false;
				}
			})
			
			$("#checkAll").prop("checked",check);
			
		});
		
	</script>
</body>
</html>