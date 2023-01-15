<%@page import="news.domain.News"%>
<%@page import="news.domain.Comments"%>
<%@page import="java.util.List"%>
<%@page import="news.repository.CommentsDAO"%>
<%@ page language="java" contentType="text/html;charset=utf-8" %>
<%! CommentsDAO dao = new CommentsDAO(); %>
<%
	request.setCharacterEncoding("utf-8");
	String msg = request.getParameter("msg");
	String author = request.getParameter("author");
	int news_idx = Integer.parseInt(request.getParameter("news_idx"));
	
	Comments comments = new Comments();
	News news = new News();
	news.setNews_idx(news_idx);
	comments.setMsg(msg);
	comments.setAuthor(author);
	comments.setNews(news);
	int result = dao.insert(comments);
%>