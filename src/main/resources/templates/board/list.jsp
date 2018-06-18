<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link
	href="${pageContext.servletContext.contextPath}/assets/css/board.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="board">
				<form id="search_form"
					action="${pageContext.servletContext.contextPath}/board"
					method="post">
					<input type="text" id="keyword" name="keyword" value="${param.keyword}">
                    <input type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>

					<c:forEach items="${boardList}" var="board" varStatus="status">
						<tr>
							<td>${totCount - (curPage-1)*10 - status.index}</td>
							<c:choose>
								<c:when test='${board["depth"] > 0}'>
									<td
										style='text-align:left; padding-left:${20*(board["depth"]-1)}px;'>
										<img
										src="${pageContext.servletContext.contextPath}/assets/images/reply.png" />
										<a
										href='${pageContext.servletContext.contextPath}/board/view?no=${board["no"]}&page=${curPage}&keyword=${param.keyword}'>${board["title"]}</a>
									</td>
								</c:when>
								<c:otherwise>
									<td style="text-align: left; padding-left:0;"><a
										href='${pageContext.servletContext.contextPath}/board/view?no=${board["no"]}&page=${curPage}&keyword=${param.keyword}'>${board["title"]}</a>
									</td>
								</c:otherwise>
							</c:choose>
							<td>${board["name"]}</td>
							<td>${board["views"]}</td>
							<td>${board["reg_date"]}</td>
							<td><c:if
									test='${not empty authUser and board["user_no"] == authUser.no}'>
									<a href='${pageContext.servletContext.contextPath}/board/delete?no=${board["no"]}&userNo=${board["user_no"]}&page=${curPage}&keyword=${param.keyword}' class="del">삭제</a>
								</c:if></td>
						</tr>
					</c:forEach>
				</table>
				<div class="pager">
					<ul>
						<c:if test="${curPage != 1}">
							<li><a
								href="${pageContext.servletContext.contextPath}/board?page=${(curPage-1)<1?1:(curPage-1)}&keyword=${param.keyword}">◀</a></li>
						</c:if>
						<fmt:parseNumber var="sPage" value="${(curPage-1)/10}"
							integerOnly="true" />
						<c:forEach begin="${sPage*10 + 1}"
							end="${(sPage*10 + 10)<=endPage?(sPage*10 + 10):endPage}"
							var="page">
							<c:choose>
								<c:when test="${page == curPage}">
									<li class="selected">${page}</li>
								</c:when>
								<c:otherwise>
									<li><a
										href="${pageContext.servletContext.contextPath}/board?page=${page}&keyword=${param.keyword}">${page}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${curPage != endPage}">
							<li><a
								href="${pageContext.servletContext.contextPath}/board?page=${(curPage+1)>endPage?endPage:(curPage+1)}&keyword=${param.keyword}">▶</a></li>
						</c:if>
					</ul>
				</div>
				<c:if test="${not empty authUser}">
					<div class="bottom">
						<a href="${pageContext.servletContext.contextPath}/board/write"
							id="new-book">글쓰기</a>
					</div>
				</c:if>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp">
			<c:param name="menu" value="board"></c:param>
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>