package cn.mldn.mybatisdemo.vo;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Item implements Serializable {
	private Long iid ;
	private String title ;
	private List<Subitem> subitems ;
	public Long getIid() {
		return iid;
	}
	public void setIid(Long iid) {
		this.iid = iid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Subitem> getSubitems() {
		return subitems;
	}
	public void setSubitems(List<Subitem> subitems) {
		this.subitems = subitems;
	}
	@Override
	public String toString() {
		return "Item [iid=" + iid + ", title=" + title + ", subitems="
				+ subitems + "]";
	}
}
