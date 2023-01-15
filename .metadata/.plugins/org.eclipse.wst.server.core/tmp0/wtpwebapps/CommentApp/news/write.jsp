<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/inc/header_link.jsp"%>
<title>글쓰기</title>
<script type="text/javascript">
	$(function() {
		$($("button")[0]).click(function() {
			$("#form1").attr({
				"action" : "/news/regist",
				"method" : "post"
			});
			$("#form1").submit();
		});
	});
</script>
</head>
<body>
	<div class="container">
		<h2>글쓰기</h2>
		<p></p>
		<p>새로운 뉴스를 작성해주세요</p>
		<form id="form1">
			<div class="form-group">
				<label for="title">제목</label>
				<input type="text" class="form-control" id="title" name="title">
			</div>
			<div class="form-group">
				<label for="writer">작성자</label>
				<input type="text" class="form-control" id="writer" name="writer">
			</div>
			<div class="form-group">
				<label for="content">내용 :</label>
				<textarea class="form-control" rows="5" id="content" name="content"></textarea>
			</div>
			<button type="button" class="btn btn-primary">작성완료</button>
			<button type="button" class="btn btn-primary">목록</button>
		</form>
	</div>
</body>
</html>