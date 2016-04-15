package com.mjs.utils;

import java.io.Serializable;
import java.util.List;

import com.mjs.domain.Invitation;
import com.mjs.domain.Person;

public class InvitationPage implements Serializable{

	private final int PAGESIZE = 10;

	private List<Invitation> records;
	private int pagenum; // 用户要看的页码即当前页码
	private int totalpage; // 总页数
	private int startIndex; // 每页开始记录的索引
	private int totalrecords; // 总记录条数

	// 显示的页码
	private int startPage;
	private int endPage;

	public InvitationPage(int pagenum, int totalrecords) {
		this.pagenum = pagenum;
		this.totalrecords = totalrecords;

		// 计算每页开始记录的索引
		startIndex = (pagenum - 1) * PAGESIZE;
		// 计算总页数
		totalpage = totalrecords % PAGESIZE == 0 ? totalrecords / PAGESIZE
				: (totalrecords / PAGESIZE + 1);
		if(totalrecords <= PAGESIZE){
			totalpage = 1;
		}
		// 显示的页码
		if (totalpage <= 9) {
			startPage = 1;
			endPage = totalpage;
		} else {
			startPage = pagenum - 4;
			endPage = pagenum + 4;
			if (startPage < 1) {
				startPage = 1;
				endPage = 9;
			}
			if (endPage > totalpage) {
				endPage = totalpage;
				startPage = totalpage - 8;
			}
		}
	}

	public int getPAGESIZE() {
		return PAGESIZE;
	}

	public List<Invitation> getRecords() {
		return records;
	}

	public void setRecords(List<Invitation> records) {
		this.records = records;
	}

	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getTotalrecords() {
		return totalrecords;
	}

	public void setTotalrecords(int totalrecords) {
		this.totalrecords = totalrecords;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

}
