package com.study.boot3.board;


import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardMapperTest {
	
	@Autowired
	private BoardMapper boardMapper;
	
	//@Test
	void test() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(3L);
		boardVO = boardMapper.getDetail(boardVO);
		System.out.println(boardVO.toString());
		assertNotNull(boardVO);
	}
	
	//@Test
	void addTest() throws Exception{
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("title");
		boardVO.setWriter("writer");
		boardVO.setContents("contents");
		boardVO.setCategory(1);
		int result = boardMapper.setAdd(boardVO);
		assertNotEquals(0, result);
		
	}
	//@Test
	void updateTest() throws Exception{
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(4L);
		boardVO.setTitle("title update");
		boardVO.setContents("contents update");
		int result = boardMapper.setUpdate(boardVO);
		assertNotEquals(0, result);
		
	}
	
	@Test
	void deleteTest() throws Exception{
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(4L);
		int result = boardMapper.setDelete(boardVO);
		assertNotEquals(0, result);
	}
	
	
	
}
