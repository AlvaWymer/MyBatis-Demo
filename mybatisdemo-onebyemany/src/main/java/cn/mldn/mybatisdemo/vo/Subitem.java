package cn.mldn.mybatisdemo.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Subitem implements Serializable {
	private Long sid ;
	private String title ;
	private Item item ;
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	@Override
	public String toString() {
		return "Subitem [sid=" + sid + ", title=" + title + ", item=" + item
				+ "]";
	}
	
}
