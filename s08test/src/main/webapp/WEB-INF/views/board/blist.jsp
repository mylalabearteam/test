<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>list.jsp</title>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
		<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
		<style type="text/css">
		*{margin:0; padding:0;}
		div{width:1000px; margin: 30px auto; text-align:center;}
		h1{margin-bottom: 30px;}
		table,th,td{border: 1px solid black; border-collapse:collapse; 
				font-size: 16px;}
		th,td { width: 200px; height: 40px;}
		button{width:200px; height: 60px; margin-top: 30px;}
		</style>
		<link rel="stylesheet" href="/css/main.css">
		<link rel="stylesheet" href="/css/list.css">
	</head>
	<body>
		<div><h1>게시판</h1>
			<table>
				<colgroup>
					<col width="12%">	
					<col width="40%">
					<col width="18%">
					<col width="18%">
					<col width="12%">
				</colgroup>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			<c:forEach var ="b" items="${list.content }">
				<tr>
					<td> ${b.bno } </td>
					<td><a href="/board/bview?bno=${b.bno }"> ${b.btitle }</a></td>
					<td> ${b.member.id }</td>
					<td> ${b.bdate } </td>
					<td> ${b.bhit }</td>
				</tr>			 
			</c:forEach>

				
			</table>
			
			<ul class="page-num">
<c:if test="${nowPage>1}"><a href="blist?page=0"><li class="first"></li></a></c:if>
<c:if test="${nowPage==1}"><li class="first"></li></c:if>
<c:if test="${nowPage>1}"><a href="blist?page=${nowPage-2}"><li class="prev"></li></a></c:if>
<c:if test="${nowPage==1}"><li class="prev"></li></c:if>
<c:forEach var="num" begin="${startPage}" end="${endPage}" step="1">
<c:if test="${nowPage==num}">
<li class="num on"><div>${num}</div></li>
</c:if>
<c:if test="${nowPage!=num}">
<li class="num"><a href="blist?page=${num-1}"><div>${num}</div></a></li>
</c:if>
</c:forEach>
<c:if test="${nowPage<maxPage}"><a href="blist?page=${nowPage}"><li 
class="next"></li></a></c:if>
<c:if test="${nowPage==maxPage }"><li class="next"></li></c:if>
<c:if test="${nowPage<maxPage }"><a href="blist?page=${maxPage-1}"><li 
class="last"></li></a></c:if>
<c:if test="${nowPage==maxPage }"><li class="last"></li></c:if>
</ul>
			
			
			
			
			
			
			<a href = "/board/bwrite"><button type="button">글쓰기</button></a>
			<a href = "/index"><button type="button">홈으로</button></a>
		</div>
	
	</body>
</html>