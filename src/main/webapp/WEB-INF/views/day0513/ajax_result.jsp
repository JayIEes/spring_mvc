<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%out.println(request.getAttribute("data"));
//<c:out을 사용하면 ""가 코드값으로 출력되어 JavaScript에서 Parsing할 수 없다.
// escapeXml="false"를 사용하여 코드값을 문자열로 출력되도록 만들어야 한다.
%>
<%-- <c:out value="${data }" escapeXml="false"/> --%>