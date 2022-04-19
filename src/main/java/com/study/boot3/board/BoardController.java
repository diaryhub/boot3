package com.study.boot3.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.study.boot3.util.Pager;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
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
	public String add(BoardVO boardVO)throws Exception{
		int result = boardService.setAdd(boardVO);
		return "redirect:./list";
		
	}
	
	@GetMapping("delete")
	public String delete(BoardVO boardVO)throws Exception{
		int result = boardService.setDelete(boardVO);
		return "redirect:./list";
	}
	
}
