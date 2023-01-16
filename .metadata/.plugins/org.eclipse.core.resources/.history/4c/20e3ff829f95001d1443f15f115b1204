<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="news.domain.News"%>
<%@page import="news.repository.NewsDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="news.util.PagingManager"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%! PagingManager pm = new PagingManager(); %>
<%! NewsDAO dao = new NewsDAO(); %>
<%
List<News> list = dao.selectAll();
pm.init(list, request);
int curPos = pm.getCurPos();
int num = pm.getNum();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>탱고뉴스!</title>
<%@ include file="/inc/header_link.jsp"%>
<script type="text/javascript">

	function search() {
		let json = {
			"category" : $("#category").val(),
			"keyword" : $("#keyword").val()
		}
		$.ajax({
			type : "post",
			url : "search_list.jsp",
			data : json,
			success : function(result, status, xhr) {
				searchList = JSON.parse(result);
				console.log(searchList);
			}
		});
	}

	$(function() {
		$("#writeNews").click(function() {
			location.href="/news/write.jsp";
		});
		
		$("#bt_search").click(function() {
			search();
		});
	});
</script>
</head>
<body>
	<div class="container mt-3">
		<h2>뉴스!</h2>
		<table class="table mt-3 border">
			<thead class="thead-dark">
				<tr>
					<th>No</th>
					<th>제목</th>
					<th>작성자</th>
					<th>등록일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (int i = 1; i <= pm.getPageSize(); i++) {
					if(num<1) break;
					News news = list.get(curPos++);
				%>
				<tr>
					<td><%=num--%></td>
					<td><a href="/news/content.jsp?news_idx=<%=news.getNews_idx()%>"><%=news.getTitle()%></a>
					<%if(news.getCommentsList().size()!=0){ 
					%>
					[<%=news.getCommentsList().size()%>]
					<%} %>
					</td>
					<td><%=news.getWriter()%></td>
					<td><%=news.getContent()%></td>
					<td><%=news.getHit()%></td>
				</tr>
				<%
				}
				%>
				<tr>
					<td colspan="5">
						<ul class="pagination justify-content-center">
							<%if(pm.getFirstPage()-1 > 0){ %>
							<li class="page-item"><a class="page-link" href="?currentPage=<%=pm.getFirstPage()-1%>">Prev</a></li>
							<%}%>
							<%for(int i=pm.getFirstPage(); i<=pm.getLastPage(); i++){
									if(i>pm.getTotalPage()) break;
								%>
							<li class="page-item"><a class="page-link" href="?currentPage=<%=i%>"><%=i%></a></li>
							<%}
								if(pm.getLastPage()+1 < pm.getTotalPage()){
							%>
							<li class="page-item"><a class="page-link" href="?currentPage=<%=pm.getLastPage()+1%>">Next</a></li>
							<%} %>
						</ul>
					</td>
				</tr>
				<tr>
					<td colspan="5">
						<button type="button" class="btn btn-warning" id="writeNews">글쓰기</button>
					</td>
				</tr>
			</tbody>
		</table>
		<div class="row" style="float: right">
			<div class="input-group mb-3">
				<select class="input-group-text" id="category">
					<option value="title">제목</option>
					<option value="writer">작성자</option>
				</select>
				<input type="text" style="width:300px" class="form-control" id="keyword">
				<button class="btn btn-warning" id="bt_search">검색</button>
			</div>
		</div>
	</div>
</body>
</html>
