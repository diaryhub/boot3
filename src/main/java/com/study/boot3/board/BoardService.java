package com.study.boot3.board;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.study.boot3.util.FileManager;
import com.study.boot3.util.Pager;

//@Transactional(rollbackFor=Exception.class)
@Service
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Autowired
	private FileManager fileManager;
	
	public boolean setSummerFileDelete(String fileName)throws Exception{
		String [] file=fileName.split("/");
		fileName = fileName.substring(fileName.lastIndexOf("/")+1);
		System.out.println(fileName);
		System.out.println(file[file.length-1]);
		
		return fileManager.remove("/resources/upload/board/", file[file.length-1]);
	}
	
	public String setSummerFileUpload(MultipartFile files) throws Exception{
		String fileName = fileManager.fileSave(files, "resources/upload/board/");
		fileName = "/resources/upload/board/"+fileName;
		return fileName;
	}

	public BoardVO getDetail(BoardVO boardVO) throws Exception {
		return boardMapper.getDetail(boardVO);
	};

	public List<BoardVO> getList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makeNum(boardMapper.total(pager));
		return boardMapper.getList(pager);
	};
	
	@Transactional(rollbackFor = Exception.class)
	public int setAdd(BoardVO boardVO, MultipartFile[] files) throws Exception {
		System.out.println("insert 전 : " + boardVO.getNum());
		int result = boardMapper.setAdd(boardVO);
		System.out.println("insert 후 : " + boardVO.getNum());
		// 1. 파일을 하드디스크에 저장
		// 2. 저장된 정보를 DB에 저장
		
		for (MultipartFile f : files) {
			if(f.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.fileSave(f, "resources/upload/board/");
			BoardFilesVO boardFilesVO = new BoardFilesVO();
			boardFilesVO.setNum(boardVO.getNum());
			boardFilesVO.setFileName(fileName);
			boardFilesVO.setOriName(f.getOriginalFilename());
			result = boardMapper.setFileAdd(boardFilesVO);
			
			if(result<1) {
				throw new Exception();
			}
		}
		return result;
	};

	public int setUpdate(BoardVO boardVO) throws Exception {
		return boardMapper.setUpdate(boardVO);
	};

	public int setDelete(BoardVO boardVO) throws Exception {
		
		List<BoardFilesVO> ar = boardMapper.getFileList(boardVO);
		
		for(int i=0;i<ar.size();i++) {
			fileManager.remove("resources/upload/board/", ar.get(i).getFileName());
		}
		
		int result = boardMapper.setFileDelete(boardVO);
		result = boardMapper.setDelete(boardVO);
		return result;
	};

	public int setFileAdd(BoardFilesVO boardFilesVO) throws Exception {
		return boardMapper.setFileAdd(boardFilesVO);
	};


	public BoardFilesVO getFileDetail(BoardFilesVO boardFilesVO) throws Exception {
		return boardMapper.getFileDetail(boardFilesVO);
	};


}
