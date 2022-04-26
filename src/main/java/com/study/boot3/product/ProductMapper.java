package com.study.boot3.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.boot3.util.Pager;

@Mapper
public interface ProductMapper {

	public List<ProductVO> list(Pager pager) throws Exception;
	
	public int add(ProductVO productVO) throws Exception;
	
	public int fileAdd(ProductFilesVO productFilesVO)throws Exception;
	
	public ProductVO detail (ProductVO productVO)throws Exception;
	
	public Long total(Pager pager) throws Exception;
}
