package com.study.boot3.product;

import java.util.List;

import lombok.Data;

@Data
public class ProductVO {
	
	private Long productNum;
	private String productName;
	private Long productPrice;
	private Long productCount;
	private String productDetail;
	private List<ProductFilesVO> filesVOs;
	private String id;
	private Integer sale;
}