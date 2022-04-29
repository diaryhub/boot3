package com.study.boot3.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.study.boot3.util.Pager;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@PostMapping("summerFileUpload")
	public ModelAndView setSummerFileUpload(MultipartFile files) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println(files.getOriginalFilename());
		System.out.println(files.getSize());
		String fileName = boardService.setSummerFileUpload(files);
		mv.addObject("result", fileName);
		mv.setViewName("common/result");
		return mv;
	}
	
	@GetMapping("summerFileDelete")
	public ModelAndView setSummerFileDelete(String fileName)throws Exception{
		ModelAndView mv = new ModelAndView();
		boolean result = boardService.setSummerFileDelete(fileName);
		mv.setViewName("common/result");
		mv.addObject("result", result);
		return mv;
	}
	
	
	@GetMapping("fileDown")
	public ModelAndView getFileDown(BoardFilesVO boardFilesVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardFilesVO = boardService.getFileDetail(boardFilesVO);
		//속셩명은 fileDown 클래스에서 사용하는 이름과 동일
		mv.addObject("fileVO", boardFilesVO);
		mv.addObject("board", "board/");
		//Bean(클래스)의 이름과 동일하게
		mv.setViewName("fileDown");
		return mv;
	}
	
	@GetMapping("list")
	public ModelAndView list(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardVO> ar = boardService.getList(pager);
		mv.addObject("list", ar);
		mv.addObject("pager",pager);
		mv.setViewName("board/list");
		return mv;
	}
	
	@GetMapping("detail")
	public ModelAndView detail(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardVO = boardService.getDetail(boardVO);
		mv.addObject("VO", boardVO);
		mv.setViewName("board/detail");
		return mv;
	}
	
	@GetMapping("add")
	public void add()throws Exception{}
	
	@PostMapping("add")
	public String add(BoardVO boardVO,MultipartFile[] files)throws Exception{
		int result = boardService.setAdd(boardVO,files);
		return "redirect:./list";
		
	}
	
	@GetMapping("update")
	public void update(BoardVO boardVO, Model model)throws Exception{
		boardVO = boardService.getDetail(boardVO);
		model.addAttribute("vo", boardVO);
	}
	
	@PostMapping("update")
	public String update(BoardVO boardVO)throws Exception{
		int result = boardService.setUpdate(boardVO);
		return "redirect:./list";
	}
	
	@GetMapping("delete")
	public String delete(BoardVO boardVO)throws Exception{
		int result = boardService.setDelete(boardVO);
		return "redirect:./list";
	}
	
}
