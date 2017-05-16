package cn.mldn.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import cn.mldn.util.MyBatisSessionFactory;
import cn.mldn.vo.News;
import junit.framework.TestCase;

public class TestDynamicNews {
	@Test
	public void testLists() {
		Set<Long> allIds = new HashSet<Long>(); // 保存所有要查询的id数据
		allIds.add(1L);
		allIds.add(2L);
		allIds.add(3L);
		List<News> all = MyBatisSessionFactory.getSession().selectList(
				"cn.mldn.mapping.NewsNS.findByIds", allIds.toArray());
		System.out.println(all);
	}

	@Test
	public void testEdit() {
		News vo = new News();
		vo.setNid(2L);
		vo.setTitle("我必须被更新");
		vo.setNote("一起更新了");
		int count = MyBatisSessionFactory.getSession()
				.update("cn.mldn.mapping.NewsNS.doUpdate2", vo);
		MyBatisSessionFactory.getSession().commit();
		MyBatisSessionFactory.close();
		System.out.println(vo);
		TestCase.assertEquals(count, 1);
	}
	@Test
	public void testAll() {
		Map<String, Object> param = new HashMap<String, Object>();
		// param.put("column", "nid") ;
		// param.put("data", 10L) ;
		param.put("column", "title");
		param.put("data", "Hello");
		List<News> all = MyBatisSessionFactory.getSession().selectList(
				"cn.mldn.mapping.NewsNS.findAllByNidAndTitle", param);
		System.out.println(all);
		TestCase.assertTrue(all.size() > 0);
	}

}
