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
.car_img{width:80px; height:60px;border:0px;}
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
	<c:if test="${not empty param.country}">
	$("#country :eq(${param.country eq '수입'?0:1})").prop("selected",true);
	</c:if>
});//ready
</script>
</head>
<body>

<form action="http://localhost/spring_mvc/mybatis/day0526/join.do" method="get">
<label>제조국 선택</label>
<select name="country" id="country" class="inputBox">
	<c:forEach var="country" items="${country }">
		<option value="${country }"><c:out value="${country }"/></option>
	</c:forEach>
</select>
<input type="radio" name="searchFlag" value="전체" checked="checked"/>모든 차량
<input type="radio" name="searchFlag" value="최근" ${searchFlag eq '최근'?" checked='checked'":""}/>최근 차량


<input type="submit" value="전송" class="btn btn-success"/>
</form>
<c:if test="${ empty carList and not empty param.country}">
제조국이 <c:out value="${param.country }"/>인 차량은 검색되지 않습니다.<br/>
	<img src="http://localhost/spring_mvc/common/images/error.jpg" width="250"/><br/>
</c:if>

<c:if test="${ not empty carList }">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>이미지</th>
				<th>제조사</th>
				<th>차량명</th>
				<th>연식</th>
				<th>옵션</th>
				<th>가격</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="carData" items="${carList }">
		<c:set var="i" value="${i+1}"/>
			<tr>
				<td><c:out value="${i }"/></td>
				<td><img src="http://localhost/spring_mvc/common/car_img/${carData.car_img}" class="car_img"/></td>
				<td><c:out value="${carData.maker}"/></td>
				<td><c:out value="${carData.model}"/></td>
				<td><c:out value="${carData.car_year}"/></td>
				<td><c:out value="${carData.car_option}"/></td>
				<td><c:out value="${carData.price}"/></td>
			</tr>
		</c:forEach>	
		</tbody>
	</table>
</c:if>
<a href="http://localhost/spring_mvc/mybatis/mybatis_index.do">메뉴</a>
</body>
</html>





