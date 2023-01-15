package news.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import news.repository.CommentsDAO;
import news.repository.NewsDAO;
import news.util.ResponseMsg;

public class DeleteServlet  extends HttpServlet{
	NewsDAO dao;
	CommentsDAO cdao;
	public DeleteServlet() {
		dao = new NewsDAO();
		cdao = new CommentsDAO();
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		
		int news_idx = Integer.parseInt(req.getParameter("news_idx"));
		int commentsCnt = Integer.parseInt(req.getParameter("commentsCnt"));
		int result = 0;
		if(commentsCnt > 0) {
			result = cdao.deleteAllbyNews(news_idx);
			if(result == 0) {
				out.print(ResponseMsg.getMsgBack("코멘트 삭제실패"));
				return;
			}
		}
		result = dao.delete(news_idx);
		if(result > 0) {
			out.print(ResponseMsg.getMsgURL("삭제완료", "list.jsp"));
		} else {
			out.print(ResponseMsg.getMsgBack("삭제실패"));
		}
		
//		if(commentsCnt > 0) {
//		result = cdao.deleteAllbyNews(news_idx);
//		if (result > 0 ) {
//			result = dao.delete(news_idx);
//			if(result > 0) {
//				out.print(ResponseMsg.getMsgURL("삭제완료", "list.jsp"));
//			} else {
//				out.print(ResponseMsg.getMsgBack("삭제실패"));
//			}
//		} else {
//			out.print(ResponseMsg.getMsgBack("코멘트 삭제실패"));
//		}
//	} else {
//		result = dao.delete(news_idx);
//		if(result > 0) {
//			out.print(ResponseMsg.getMsgURL("삭제완료", "list.jsp"));
//		} else {
//			out.print(ResponseMsg.getMsgBack("삭제실패"));
//		}
//	}
		
	}
}
