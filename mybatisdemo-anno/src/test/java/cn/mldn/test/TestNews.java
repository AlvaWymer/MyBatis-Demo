package cn.mldn.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.mldn.dao.INewsDAO;
import cn.mldn.util.MyBatisSessionFactory;
import cn.mldn.vo.News;
import junit.framework.TestCase;

public class TestNews {

	@Test
	public void testSplit() {
		long currentPage = 5;
		int lineSize = 2;
		String keyWord = "饿";
		INewsDAO dao = MyBatisSessionFactory.getSession()
				.getMapper(INewsDAO.class);
		System.out.println(dao.findAllSplit((currentPage - 1) * lineSize,
				lineSize, "title", "%" + keyWord + "%"));
	}

	@Test
	public void testAdd() {
		News vo = new News();
		vo.setTitle("中午肚子饿了么？");
		vo.setNote("继续好好上课吧，别想太多了，不下课，好好学习，天天向上。");
		// 取得DAO接口
		INewsDAO dao = MyBatisSessionFactory.getSession()
				.getMapper(INewsDAO.class);
		System.out.println(dao.doCreate(vo));
		MyBatisSessionFactory.getSession().commit();
		MyBatisSessionFactory.close();
		System.out.println(vo);
	}

}
