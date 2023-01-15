<%@page import="news.repository.CommentsDAO"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%! 
	CommentsDAO dao = new CommentsDAO();
%>
<%
	response.setCharacterEncoding("utf-8");
	int idx = Integer.parseInt(request.getParameter("comments_idx"));
	int result = dao.delete(idx);
	if(result>0){
		out.print("댓글 삭제 성공");
	}
%>