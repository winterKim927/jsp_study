package news.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConfig {
	private static MybatisConfig instance = new MybatisConfig(); 
	SqlSessionFactory factory;
	
	public MybatisConfig() {
		String resource = "news/mybatis/config.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static MybatisConfig getInstance() {
		return instance;
	}
	
	public SqlSession getSqlSession() {
		return factory.openSession();
	}
	
	public void release(SqlSession session) {
		if(session != null) {
			session.close();
		}
	}
}
