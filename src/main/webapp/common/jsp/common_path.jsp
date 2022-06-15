<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String protocol=application.getInitParameter("protocol");
String serverName=application.getInitParameter("serverName");
String commonCss=application.getInitParameter("commonCss");
String commonImages=application.getInitParameter("commonImages");

pageContext.setAttribute("protocol1", protocol);
pageContext.setAttribute("serverName1",serverName );
pageContext.setAttribute("commonCss1",commonCss );
pageContext.setAttribute("commonImages1", commonImages);
%> 

<c:set var="commUrl" value="${protocol1}${serverName1 }"/>
<c:set var="commCss" value="${protocol1}${serverName1 }${commonCss1}"/>
<c:set var="commImg" value="${protocol1}${serverName1 }${commonImages1 }"/>
${commUrl}<br/>
${commCss}<br/>
${commImg}

