package cn.mldn.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.mldn.util.MyBatisSessionFactory;
import cn.mldn.vo.News;

public class TestFirstCache {
	@Test
	public void testGet() {
		// 直接返回一个News的处理对象
		SqlSession sessionA = MyBatisSessionFactory.getSessionFactory()
				.openSession();
		News voA = sessionA.selectOne("cn.mldn.mapping.NewsNS.findById", 2L);
		MyBatisSessionFactory.getSession().clearCache();
		System.out.println(voA);
		sessionA.close();
		System.out.println("====================================");
		SqlSession sessionB = MyBatisSessionFactory.getSessionFactory()
				.openSession();
		News voB = sessionB.selectOne("cn.mldn.mapping.NewsNS.findById", 2L);
		System.out.println(voB);
		sessionB.close();
	}

}
