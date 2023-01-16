package news.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import news.domain.News;
import news.mybatis.MybatisConfig;

public class NewsDAO {
	MybatisConfig config = MybatisConfig.getInstance();
	
	public int insert(News news) {
		SqlSession session = config.getSqlSession();
		int result = session.insert("News.insert", news);
		session.commit();
		config.release(session);
		return result;
	}
	
	public List selectAll() {
		SqlSession session = config.getSqlSession();
		List list = session.selectList("News.selectAll");
		config.release(session);
		return list;
	}
	
	public List selectByKeyword(Map map) {
		SqlSession session = config.getSqlSession();
		List list = session.selectList("selectByKeyword", map);
		config.release(session);
		return list;
	}
	
	public News select(int news_idx) {
		SqlSession session = config.getSqlSession();
		News news = session.selectOne("News.select", news_idx);
		config.release(session);
		return news;
	}
	
	public int update(News news) {
		SqlSession session = config.getSqlSession();
		int result = session.update("News.update", news);
		session.commit();
		config.release(session);
		return result;
	}
	
	public int delete(int news_idx) {
		SqlSession session = config.getSqlSession();
		int result = session.delete("News.delete", news_idx);
		session.commit();
		config.release(session);
		return result;
	}
	
	public int updateHit(int news_idx) {
		SqlSession session = config.getSqlSession();
		int result = session.update("News.updateHit", news_idx);
		session.commit();
		config.release(session);
		return result;
	}
}


