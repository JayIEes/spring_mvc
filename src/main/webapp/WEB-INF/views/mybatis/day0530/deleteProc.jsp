<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--공통 CSS-->
<link rel="stylesheet" type="text/css" href="http://211.63.89.143/spring_mvc/common/CSS/main_20220321.css">
<style type="text/css">

</style>
<!-- jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

<script type="text/javascript">
$(function(){
	$("#btn").click(function(){
		$("#frm").submit();
	})
});//ready
</script>
</head>
<body>

<form action="http://localhost/spring_mvc/mybatis/day0530/deleteProc.do" method="get" id="frm">
	<label>삭제 번호 입력</label>
	번호<input type="text" name="num" class="inputBox" id="num"><br/>
	
	<input type="button" value="전송" class="btn btn-success" id="btn"/>
</form>

<c:if test="${ not empty param.num}">
	<c:choose>
		<c:when test="${removeVO.row_cnt ge 1 }">
			<c:out value="${removeVO.num}"/>번 님의 정보가 삭제되었습니다.
		</c:when>
		<c:otherwise>
			<c:out value="${removeVO.num}"/>번 님의 정보가 변경되지 않았습니다.<br/>
			<c:out value="${removeVO.result_msg}"/>
		</c:otherwise>
	</c:choose>
</c:if>
<a href="http://localhost/spring_mvc/mybatis/mybatis_index.do">메뉴</a>
</body>
</html>





