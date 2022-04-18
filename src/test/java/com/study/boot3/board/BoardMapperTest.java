package com.study.boot3.board;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.boot3.util.Pager;

@SpringBootTest
class BoardMapperTest {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	void getListTest()throws Exception{
		Pager pager = new Pager();
		pager.makeRow();
		List<BoardVO> ar = boardMapper.getList(pager);
		assertEquals(10, ar.size());
	}
	
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
		int result=0;
	for(int i=0;i<100;i++) {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("title"+i);
		boardVO.setWriter("writer"+i);
		boardVO.setContents("contents"+i);
		boardVO.setCategory(1);
		result = boardMapper.setAdd(boardVO);
		if(i%10==0) {
			Thread.sleep(1000);
		}
	}
		assertNotEquals(0, result);
		
	}
	//@Test
	void updateTest() throws Exception{
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(5L);
		boardVO.setTitle("title update");
		boardVO.setContents("contents update");
		int result = boardMapper.setUpdate(boardVO);
		assertNotEquals(0, result);
		
	}
	
	//@Test
	void deleteTest() throws Exception{
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(5L);
		int result = boardMapper.setDelete(boardVO);
		assertNotEquals(0, result);
	}
	
	//@Test
	void fileListTest() throws Exception{
			List<BoardFilesVO> ar = boardMapper.getFileList();
			assertNotNull(ar);
		}
	
	//@Test
	void fileDetailTest()throws Exception{
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(1L);
		BoardFilesVO boardFilesVO = boardMapper.getFileDetail(boardVO);
		assertNotNull(boardFilesVO);
	}
	
	//@Test
	void fileAddTest()throws Exception{
		BoardFilesVO boardFilesVO = new BoardFilesVO();
		boardFilesVO.setNum(3L);
		boardFilesVO.setFileName("fileName");
		boardFilesVO.setOriName("oriName");
		int result = boardMapper.setFileAdd(boardFilesVO);
		assertNotEquals(0, result);
	}
	
	//@Test
	void fileDeleteTest()throws Exception{
		BoardFilesVO boardFilesVO = new BoardFilesVO();
		boardFilesVO.setFileNum(1L);
		int result = boardMapper.setFileDelete(boardFilesVO);
		assertNotEquals(0, result);
	}
	
}
