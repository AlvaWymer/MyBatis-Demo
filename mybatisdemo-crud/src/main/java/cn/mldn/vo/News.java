package cn.mldn.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class News implements Serializable {
	private Long nid ;
	private String my_title ;
	private String note ;
	public Long getNid() {
		return nid;
	}
	public void setNid(Long nid) {
		this.nid = nid;
	}
	public void setMy_title(String my_title) {
		this.my_title = my_title;
	}
	public String getMy_title() {
		return my_title;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "News [nid=" + nid + ", title=" + my_title + ", note=" + note + "]";
	}
}
