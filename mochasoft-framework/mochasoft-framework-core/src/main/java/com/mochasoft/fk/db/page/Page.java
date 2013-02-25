package com.mochasoft.fk.db.page;

import com.mochasoft.fk.constant.DataConstant;

/**
 * <strong>Title : Page </strong>. <br>
 * <strong>Description : 分页信息对象，用于数据库物理分页.</strong> <br>
 * <strong>Create on : 2013-2-6 下午4:54:17 </strong>. <br>
 * <p>
 * <strong>Copyright (C) Mocha Software Co.,Ltd.</strong> <br>
 * </p>
 * @author wanghe wanghe@mochasoft.com.cn <br>
 * @version <strong>FrameWork v0.8</strong> <br>
 * <br>
 * <strong>修改历史: .</strong> <br>
 * 修改人 修改日期 修改描述<br>
 * -------------------------------------------<br>
 * <br>
 * <br>
 */
public class Page implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private int pageSize = DataConstant.DEFAULT_PAGE_SIZE; 	//每页多少条
	private int currentPage; // 当前页
	private long totalRows; // 总数据数
	private int pageStartRow; // 每页的起始行数
	private boolean pagination = false; // 是否分页
	
	public Page(int currentPage) {
		this.currentPage = currentPage;
		this.pagination = true;
		initPageStartRow();
	}

	public Page(int currentPage, int pageSize) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.pagination = true;
		initPageStartRow();
	}
	
	public Page(int currentPage, int pageSize, long totalRows) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalRows = totalRows;
		this.pagination = true;
		initPageStartRow();
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public long getTotalRows() {
		return totalRows;
	}
	
	public void setTotalRows(long totalRows) {
		this.totalRows = totalRows;
	}
	
	public boolean isPagination() {
		return pagination;
	}

	public int getPageStartRow() {
		return pageStartRow;
	}
	
	private void initPageStartRow() {
		this.pageStartRow = this.pageSize * (this.currentPage - 1);
	}
	
}
