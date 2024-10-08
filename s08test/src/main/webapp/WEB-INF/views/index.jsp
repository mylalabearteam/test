<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>index</h1>
		
		<ul>
		<c:if test="${sessionId==null }">
			<li><a href="/member/login">login</a></li>
			<li><a href="/member/join">join</a></li>
		</c:if>
		<c:if test="${sessionId!=null }">
			<li>${sessionName }님 환영합니다 </li>
			<li><a href="/member/updateInfo">mypage</a></li>
			<li><a href="/member/mlist">mlist</a></li>
			<li><a href="/member/logout">logout</a></li>
		</c:if>
			<li><a href="/board/blist">blist</a></li>
		</ul>
		
	</body>
</html>