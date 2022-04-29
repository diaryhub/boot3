package com.study.boot3.util;

import lombok.Data;

@Data
public class Pager {
	
	private String id;
	// DB에서 한 페이지 조회 갯수
	private Integer perPage;
	// DB에서 조죄할 시작 인덱스 
	private Integer startRow;
	
	private String kind;
	private String search;
	
	private Long startNum;
	private Long lastNum;
	
	private boolean pre;
	private boolean next;
	
	// 페이지 번호 (파라미터 값)
	private Integer pn;
	
	public void makeRow() {
		// pn :1 perPage:10 startRow:0
		// pn :2 perPage:10 startRow:10
		// pn :3 perPage:10 startRow:20
		startRow = this.getPerPage()*(this.getPn()-1);
		
		
	}
	
	public void makeNum(Long totalCount) {
		Long totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage()!=0) {
			totalPage++;
		}
		Long perBlock=10L;
		
		Long totalBlock = totalPage/perBlock;
		if(totalPage%perBlock!=0) {
			totalBlock++;
		}
		
		Long curBlock = this.getPn()/10L;
		if(this.getPn()%perBlock!=0) {
			curBlock++;
		}
		
		startNum=(curBlock-1)*perBlock+1;
		lastNum=curBlock*perBlock;
		
		pre = false;
		next = false;
		
		if(totalBlock>curBlock) {
			next=true;
		}
		if(curBlock>1) {
			pre=true;
		}
		
		if(curBlock==totalBlock) {
			this.lastNum=totalPage;
		}
		
		
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
