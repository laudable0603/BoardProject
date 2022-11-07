<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
	$(document).ready(function(){
		
	});
</script>
</head>
<body>
	<div>	
		<a href="${contextPath}/free/insert.do">작성하러가기</a>
	</div>
	
	<hr>
	
	<div>
		<table border="1">
			<thead>
				<tr>
					<td>게시글번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>조회수</td>
					<td>삭제</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${frees}" var="f">
					<tr>
						<td>${f.freeNo}</td>
						<td><a id="link_detail" onclick="link_detail(${f.freeNo})" >${f.title}</a></td>
						<td>${f.writer}</td>
						<td>${f.hit}</td>
						<td>
							<a id="link_remove" onclick="link_remove(${f.freeNo})">X</a>
							<script>
								function link_detail(freeNo){
									location.href = '${contextPath}/free/detail.do?freeNo=' + freeNo;
								}
								function link_remove(freeNo){
									if(confirm('게시글을 삭제할까요?')){
										location.href = '${contextPath}/free/remove.do?freeNo=' + freeNo;
									}
								}
							</script>
						</td>
					</tr>
				</c:forEach>
			</tbody>		
		</table>
	</div>

	
	
	
	
	
</body>
</html>