package comments.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import news.domain.Comments;
import news.domain.News;
import news.repository.CommentsDAO;
import news.util.ResponseMsg;

public class RegistServlet extends HttpServlet{
CommentsDAO dao = new CommentsDAO();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		
		int news_idx = Integer.parseInt(req.getParameter("news_idx"));
		String msg = req.getParameter("msg");
		String author = req.getParameter("author");
		
		Comments c = new Comments();
		News news = new News();
		news.setNews_idx(news_idx);
		c.setNews(news);
		c.setMsg(msg);
		c.setAuthor(author);
		int result = dao.insert(c);
		if(result>0) {
			out.print(ResponseMsg.getMsgURL("댓글 등록 성공", "/news/content.jsp?news_idx="+news_idx));
		} else {
			out.print(ResponseMsg.getMsgBack("댓글 등록 실패"));
		}
	}
}
