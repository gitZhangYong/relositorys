package com.zy.bean;

import java.util.List;

/**
 * 一个用于封装了分页的数据 包含
 * 							该页的学生集合数据
 * 							总的记录数
 * 							总的页数
 * 							当前页数
 * 							每页显示的数据数
 * @author zy
 *
 */
//T表示泛型
public class PageBean <T>{
	private  int currentPage;//当前页
	private int totalPage;//总页数
	private int totalSize;//总的记录数
	private int pageSize;//每页的记录数
	private List <T> list;//当前学生集合
	
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pafeSize) {
		this.pageSize = pafeSize;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}