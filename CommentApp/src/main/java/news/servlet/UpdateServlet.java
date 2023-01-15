package news.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import news.domain.News;
import news.repository.NewsDAO;
import news.util.ResponseMsg;

public class UpdateServlet extends HttpServlet {
	NewsDAO dao = new NewsDAO();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		
		int news_idx = Integer.parseInt(req.getParameter("news_idx"));
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		
		News news = new News();
		news.setNews_idx(news_idx);
		news.setTitle(title);
		news.setWriter(writer);
		news.setContent(content);
		
		int result = dao.update(news);
		if(result>0) {
			out.print(ResponseMsg.getMsgURL("수정성공", "list.jsp"));
		} else {
			out.print(ResponseMsg.getMsgBack("수정실패"));;
		}
	}
}
