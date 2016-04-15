package com.mjs.domain;

import java.util.List;

public class LeaveQuery {
	private int count; // 总记录数
	private List<Leave> list; // 一页的数据
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<Leave> getList() {
		return list;
	}
	public void setList(List<Leave> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "LeaveQuery [count=" + count + ", list=" + list + "]";
	}
	
}
