package com.study.boot3.product;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductMapperTest {

	@Autowired
	private ProductMapper productMapper;
	
	//@Test
	void listTest()throws Exception {
		
		//List<ProductVO> ar = productMapper.list();
		//assertNotNull(ar);
	}
	
	//@Test
	void addTest() throws Exception{
		ProductVO productVO = new ProductVO();
		productVO.setProductName("add1");
		productVO.setProductPrice(1000L);
		productVO.setProductCount(1L);
		productVO.setProductDetail("add1");
		int result = productMapper.add(productVO);
		assertNotEquals(0, result);
	}
	
	@Test
	void fileAddTest() throws Exception{
		ProductFilesVO productFilesVO = new ProductFilesVO();
		productFilesVO.setProductNum(2L);
		productFilesVO.setFileName("addFile");
		productFilesVO.setOriName("addFile");
		int result = productMapper.fileAdd(productFilesVO);
		assertNotEquals(0, result);
	}

}
