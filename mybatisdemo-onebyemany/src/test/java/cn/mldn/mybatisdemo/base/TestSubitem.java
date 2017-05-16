package cn.mldn.mybatisdemo.base;

import java.util.List;

import org.junit.Test;

import cn.mldn.mybatisdemo.vo.Item;
import cn.mldn.mybatisdemo.vo.Subitem;
import cn.mldn.util.MyBatisSessionFactory;

public class TestSubitem {
	@Test
	public void testAllSubitem() {
		List<Subitem> all = MyBatisSessionFactory.getSession()
				.selectList("cn.mldn.mapping.SubitemNS.findAllByItem", 1L);
		System.out.println(all);
	}

	@Test
	public void testInsert() {
		Subitem sub = new Subitem();
		sub.setTitle("U盘");
		Item item = new Item();
		item.setIid(2L);
		sub.setItem(item); // 设置关系，多对一
		System.out.println(MyBatisSessionFactory.getSession()
				.insert("cn.mldn.mapping.SubitemNS.doCreate", sub));
		MyBatisSessionFactory.getSession().commit();
		MyBatisSessionFactory.close();
	}
}
