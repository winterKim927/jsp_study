<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="news.domain.Comments"%>
<%@page import="java.util.List"%>
<%@page import="news.repository.CommentsDAO"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%! CommentsDAO dao = new CommentsDAO();%>
<%
	int news_idx = Integer.parseInt(request.getParameter("news_idx"));
	List<Comments> list = dao.selectAllByFkey(news_idx);
	Gson gson = new Gson();
	String result = gson.toJson(list);
	out.print(result);
%>