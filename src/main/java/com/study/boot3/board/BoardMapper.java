package com.study.boot3.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
	
	public BoardVO getDetail(BoardVO boardVO)throws Exception;
	
	public List<BoardVO> getList() throws Exception;
	
	public int setAdd(BoardVO boardVO) throws Exception;
	
	public int setUpdate(BoardVO boardVO) throws Exception;
	
	public int setDelete(BoardVO boardVO) throws Exception;
}
