package cn.mldn.mybatisdemo.base;

import org.junit.Test;

import cn.mldn.mybatisdemo.vo.Item;
import cn.mldn.util.MyBatisSessionFactory;

public class TestItem {
	@Test
	public void testGet() {
		Item item = MyBatisSessionFactory.getSession()
				.selectOne("cn.mldn.mapping.ItemNS.findById", 1L);
		System.out.println(item);
	}
	@Test
	public void testList() {
		MyBatisSessionFactory.getSession()
				.selectList("cn.mldn.mapping.ItemNS.findAll");
	}
}
