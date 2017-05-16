package cn.mldn.mybatisdemo.base;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import cn.mldn.mybatisdemo.vo.Member;
import cn.mldn.mybatisdemo.vo.Role;
import cn.mldn.util.MyBatisSessionFactory;

public class TestMember {
	@Test
	public void testEdit() {
		Member vo = new Member();
		vo.setMid("hello-1");
		vo.setName("叛逆的世界");
		Long rid[] = new Long[]{6L, 7L, 8L};
		// 1、首先一定要保证Member类的信息要保存在member表中，必须保存了才可以追加角色关系
		if (MyBatisSessionFactory.getSession()
				.insert("cn.mldn.mapping.MemberNS.doUpdate", vo) > 0) {
			if (MyBatisSessionFactory.getSession().delete(
					"cn.mldn.mapping.RoleNS.doRemoveRoleByMember",
					vo.getMid()) > 0) {	// 删除已有的member_role对应处理关系后进行新的角色信息添加
				for (int x = 0; x < rid.length; x++) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("mid", vo.getMid());
					map.put("rid", rid[x]);
					MyBatisSessionFactory.getSession().insert(
							"cn.mldn.mapping.RoleNS.doCreateMemberRole", map);
				}
			}
		}
		MyBatisSessionFactory.getSession().commit();
	}

	@Test
	public void testGet() {
		Member member = MyBatisSessionFactory.getSession()
				.selectOne("cn.mldn.mapping.MemberNS.findById", "mldn");
		System.out.println(member);
		List<Role> allRoles = MyBatisSessionFactory.getSession()
				.selectList("cn.mldn.mapping.RoleNS.findAllByMember", "mldn");
		System.out.println(allRoles);
		List<String> allFlags = MyBatisSessionFactory.getSession().selectList(
				"cn.mldn.mapping.RoleNS.findAllFlagByMember", "mldn");
		Set<String> set = new HashSet<String>();
		set.addAll(allFlags);
		System.out.println(set);
	}

	@Test
	public void testAdd() {
		Member vo = new Member();
		vo.setMid("hello-1");
		vo.setName("世界和平");
		Long rid[] = new Long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L};
		// 1、首先一定要保证Member类的信息要保存在member表中，必须保存了才可以追加角色关系
		if (MyBatisSessionFactory.getSession()
				.insert("cn.mldn.mapping.MemberNS.doCreate", vo) > 0) {
			for (int x = 0; x < rid.length; x++) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("mid", vo.getMid());
				map.put("rid", rid[x]);
				MyBatisSessionFactory.getSession().insert(
						"cn.mldn.mapping.RoleNS.doCreateMemberRole", map);
			}
		}
		MyBatisSessionFactory.getSession().commit();
	}
}
