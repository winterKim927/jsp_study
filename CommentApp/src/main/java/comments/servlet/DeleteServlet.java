package comments.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import news.repository.CommentsDAO;
import news.repository.NewsDAO;
import news.util.ResponseMsg;

public class DeleteServlet extends HttpServlet{
	CommentsDAO dao = new CommentsDAO();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		
		String news_idx = req.getParameter("news_idx");
		int comments_idx = Integer.parseInt(req.getParameter("comments_idx"));
		int result = dao.delete(comments_idx);
		if(result > 0) {
			out.print(ResponseMsg.getMsgURL("삭제완료", "/news/content.jsp?news_idx="+news_idx));
		} else {
			out.print(ResponseMsg.getMsgBack("삭제실패"));
		}
	}
}
