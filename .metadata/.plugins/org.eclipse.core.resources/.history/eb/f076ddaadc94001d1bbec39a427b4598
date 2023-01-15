package news.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import news.domain.Comments;
import news.mybatis.MybatisConfig;

public class CommentsDAO {
	MybatisConfig config = MybatisConfig.getInstance();
	
	public int insert(Comments comments) {
		SqlSession session = config.getSqlSession();
		int result = session.insert("Comments.insert", comments);
		session.commit();
		config.release(session);
		return result;
	}
	
	public List selectAllByFkey(int news_idx) {
		SqlSession session = config.getSqlSession();
		List<Comments> list = session.selectList("Comments.selectAllByFkey", news_idx);
		config.release(session);
		return list;
	}
	
	public int update(Comments comments) {
		SqlSession session = config.getSqlSession();
		int result = session.update("Comments.update", comments);
		session.commit();
		config.release(session);
		return result;
	}
	
	public int delete(int comments_idx) {
		SqlSession session = config.getSqlSession();
		int result = session.delete("Comments.delete", comments_idx);
		session.commit();
		config.release(session);
		return result;
	}
	
	public int deleteAllbyNews(int news_idx) {
		SqlSession session = config.getSqlSession();
		int result = session.delete("Comments.deleteAllbyNews", news_idx);
		session.commit();
		config.release(session);
		return result;
	}
}
