package com.mjs.domain;

import java.util.List;

public class PersonQuery {
	private int count; // 总记录数
	private List<Person> list; // 一页的数据
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<Person> getList() {
		return list;
	}
	public void setList(List<Person> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "PersonQuery [count=" + count + ", list=" + list + "]";
	}
	
}
