package com.study.boot3.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.boot3.util.Pager;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	public BoardVO getDetail(BoardVO boardVO)throws Exception{
		return boardMapper.getDetail(boardVO);
	};
	
	public List<BoardVO> getList(Pager pager) throws Exception{
		return boardMapper.getList(pager);
	};
	
	public int setAdd(BoardVO boardVO) throws Exception{
		return boardMapper.setAdd(boardVO);
	};
	
	public int setUpdate(BoardVO boardVO) throws Exception{
		return boardMapper.setUpdate(boardVO);
	};
	
	public int setDelete(BoardVO boardVO) throws Exception{
		return boardMapper.setDelete(boardVO);
	};
	
	public int setFileAdd(BoardFilesVO boardFilesVO)throws Exception{
		return boardMapper.setFileAdd(boardFilesVO);
	};
	
	public int setFileDelete(BoardFilesVO boardFilesVO)throws Exception{
		return boardMapper.setFileDelete(boardFilesVO);
	};
	
	public BoardFilesVO getFileDetail(BoardVO boardVO)throws Exception{
		return boardMapper.getFileDetail(boardVO);
	};
	
	public List<BoardFilesVO> getFileList()throws Exception{
		return boardMapper.getFileList();
	};
}
