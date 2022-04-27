<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	alert("${msg}");
	location.href="${path}";
	
	//서버로 요청하는 방식 5가지 
	//서버 요청 필수 요소 : url, method
	//1. 웹 브라우저의 주소창에 직접 주소 입력
	//2. HTML의 a태그
	//3. form태그
	//4. JS에서 location객체의 href 속성 
	//5. ajax로 요청
</script>
