package com.pactera.web.common;

public class Pagination {
	private static final int pageSzie = 5;
	private int recordCount = 0;
	private int pageNo = 0;
	private int pageCount = 0;

	// private int startPos = 0;
	// private int endPos = 0;

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

//	public int getStartPos() {
//		final int pageSize = this.getPageSize();
//		final int pageNo = this.getPageNo();
//		int startPos = pageSize * (pageNo - 1);
//		return startPos < 0 ? 0 : startPos;
//	}
//
//	public int getEndPos() {
//		final int pageSize = this.getPageSize();
//		final int pageNo = this.getPageNo();
//		int endPos = pageSize * pageNo;
//		return endPos >= recordCount ? recordCount : endPos;
//	}

	public int getPageCount() {
		return recordCount % pageSzie > 0 ? recordCount / pageSzie + 1 : recordCount / pageSzie;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageNo() {
		return pageNo < 1 ? 1 : pageNo >= getPageCount() ? getPageCount() : pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSzie;
	}

	public String toString() {
		return "[recordCount = " + recordCount + ", pageCount = " + pageCount + ", pageSzie = " + pageSzie
				+ ", pageNo = " + pageNo + "]";
	}
}
