package com.mjs.domain;

import java.util.List;

public class InvitationQuery {
	private int count; // 总记录数
	private List<Invitation> list; // 一页的数据
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<Invitation> getList() {
		return list;
	}
	public void setList(List<Invitation> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "InvitationQuery [count=" + count + ", list=" + list + "]";
	}
	
}
