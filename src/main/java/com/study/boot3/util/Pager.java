package com.study.boot3.util;

import lombok.Data;

@Data
public class Pager {

	// DB에서 한 페이지 조회 갯수
	private Integer perPage;
	// DB에서 조죄할 시작 인덱스 
	private Integer startRow;
	
	private String search;
	
	// 페이지 번호 (파라미터 값)
	private Integer pn;
	
	public void makeRow() {
		// pn :1 perPage:10 startRow:0
		// pn :2 perPage:10 startRow:10
		// pn :3 perPage:10 startRow:20
		startRow = this.getPerPage()*(this.getPn()-1);
		
		
	}
	
	public String getSearch() {
		if(search==null) {
			search="";
		}
		return search;
	}
	
	public Integer getPn() {
		if(pn == null || pn<1) {
			pn = 1;
		}
		return pn;
	}
	
	public Integer getPerPage() {
		if (perPage == null || perPage < 1) {
			perPage = 10;
		}
		return perPage;
	}

}
