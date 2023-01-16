<%@page import="news.util.PagingManager"%>
<%@page import="java.util.List"%>
<%@page import="news.domain.Comments"%>
<%@page import="news.repository.CommentsDAO"%>
<%@page import="news.domain.News"%>
<%@page import="news.repository.NewsDAO"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%! NewsDAO dao = new NewsDAO();%>
<%! CommentsDAO cdao = new CommentsDAO();%>
<%! PagingManager pm = new PagingManager(); %>
<%
int news_idx = Integer.parseInt(request.getParameter("news_idx")); 
dao.updateHit(news_idx);
News news = dao.select(news_idx);
List<Comments> list = cdao.selectAllByFkey(news_idx);
pm.init(list, request);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/inc/header_link.jsp"%>
<title>뉴스내용</title>
<script type="text/javascript">

	let showCommentsList = function(result) {
		let cmList = JSON.parse(result);
		let innerhtml = "";
		for(let i = 0; i < cmList.length; i++){
			let cm = cmList[i];
			innerhtml += "<tr name='test'>";
			innerhtml += "<td class='col-5' name='gMsg'>"+cm.msg+"</td>";
			innerhtml += "<td class='col-1' name='gAuthor'>"+cm.author+"</td>";
			innerhtml += "<td class='col-2' name='gWritedate'>"+cm.writedate.substring(0,19)+"</td>";
			innerhtml += "<td class='col-1'><button type='button' class='btn btn-danger btn-sm' name='comDel' style='display:none' value='"+cm.comments_idx+"' onclick='del(this.value);'>삭제</button></td>";
			innerhtml += "</tr>";
		}
		$("#commentsList").html(innerhtml);
	}

	function addBt(){
		for(let i=0; i<$("tr[name='test']").length; i++ ){
			$($("tr[name='test']")[i]).on("mouseover", function() {
				$($("button[name='comDel']")[i]).show();
			});
			
			$($("tr[name='test']")[i]).on("mouseout", function() {
				$($("button[name='comDel']")[i]).hide();
			});
		}
	}

	function getComments() {
		let idx = $("input[name='news_idx']").val();
		$.ajax({
			type : "GET",
			url : "getComments.jsp?news_idx=" + idx,
			success : function(result, status, xhr) {
				showCommentsList(result);
				addBt();
			}				
		});
		
	}

	function del(comments_idx) {
		if(!confirm("댓글을 삭제할까요?")) return;
		$.ajax({
			type : "get",
			url : "delete_com.jsp?comments_idx="+comments_idx,
			success : function(result, status, xhr) {
				getComments();
			}					
		});
	}
	
 	function registComments() {
 		$.ajax({
 			type : "post",
 			url : "registComments.jsp",
 			data : {
 			 	msg : $("input[name='msg']").val(),
 				author : $("input[name='author']").val(),
 				news_idx : $("input[name='news_idx']").val() 
 			},
 			success : function(result, status, xhr) {
 				getComments();
			}
 		});
	} 

	$(function() {
		getComments();
		
		$($("button")[0]).click(function() { //수정버튼
			$("#form1").attr({
				"action" : "/news/update",
				"method" : "post"
			});
			$("#form1").submit();
		});
		
		$($("button")[1]).click(function() { //삭제버튼
			if(confirm("게시물을 삭제할까요?")){
				$("#form1").attr({
					"action" : "/news/delete",
					"method" : "post"
				});
				$("#form1").submit();
			}
		});
		
		$($("button")[2]).click(function() { //목록버튼
			location.href="/news/list.jsp";
		});
		
		$("#form2 button").click(function() {//댓글등록버튼
			registComments();
		});
	});
</script>
</head>
<body>
	<div class="container">
		<h2>뉴스내용</h2>
		<p></p>
		<form id="form1">
			<input type="hidden" name="news_idx" value="<%=news.getNews_idx()%>">
			<input type="hidden" name="commentsCnt" value="<%=list.size()%>">
			<div class="form-group">
				<label for="title">제목</label>
				<input type="text" class="form-control" id="title" name="title" value="<%=news.getTitle()%>">
			</div>
			<div class="form-group">
				<label for="writer">작성자</label>
				<input type="text" class="form-control" id="writer" name="writer" value="<%=news.getWriter()%>" readonly>
			</div>
			<div class="form-group">
				<label for="content">내용</label>
				<textarea class="form-control" rows="5" id="content" name="content"><%=news.getContent()%></textarea>
			</div>
			<button type="button" class="btn btn-warning">수정</button>
			<button type="button" class="btn btn-danger">삭제</button>
			<button type="button" class="btn btn-primary">목록</button>
		</form>
		<p>
		<form id="form2">
			<input type="hidden" name="news_idx2" value="<%=news.getNews_idx()%>">
				<label for="comments">댓글</label>
			<div class="form-group row">
				<div class="col-md-8">
				 	<input type="text" class="form-control" id="msg" name="msg" placeholder="댓글 입력">
				</div>
				<div class="col-md-3">
					<input type="text" class="form-control" id="author" name="author" placeholder="작성자 입력">
				</div>
				<div class="col-md-1">
					<button type="button" class="btn btn-warning">등록</button>
				</div>
			</div>
		</form>
		
			<table class="table table-hover" id="table2">
			    <thead>
			      <tr>
			        <th class="col-4">내용</th>
			        <th class="col-1">작성자</th>
			        <th class="col-2">등록일</th>
			      </tr>
			    </thead>
			    <tbody id="commentsList">
			    </tbody>
	  		</table>
  		
	</div>
</body>
</html>