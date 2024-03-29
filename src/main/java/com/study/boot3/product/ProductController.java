package com.study.boot3.product;

import java.net.BindException;
import java.util.InputMismatchException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.study.boot3.member.MemberVO;
import com.study.boot3.util.Pager;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("manage")
	public ModelAndView manage(HttpSession session, Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		pager.setId(memberVO.getId());
		List<ProductVO> ar = productService.list(pager);
		mv.setViewName("product/manage");
		mv.addObject("list", ar);
		return mv;
	}

	@GetMapping("list")
	public ModelAndView list(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<ProductVO> ar = productService.list(pager);
		mv.addObject("list", ar);
		mv.setViewName("product/list");
		return mv;
	}

	@GetMapping("add")
	public void add(@ModelAttribute ProductVO productVO) throws Exception {
	}

	@GetMapping("ajaxList")
	public ModelAndView getAjaxList(Pager pager, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		pager.setId(memberVO.getId());
		List<ProductVO> ar = productService.list(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("common/productList");
		return mv;
	}

	@PostMapping("add")
	public ModelAndView add(@Valid ProductVO productVO, BindingResult bindingResult, HttpSession session,
			MultipartFile[] files) throws Exception {
		ModelAndView mv = new ModelAndView();
		if (bindingResult.hasErrors()) {
			mv.setViewName("product/add");
			return mv;
		}
		if (files != null) {
			for (MultipartFile f : files) {
				System.out.println(f.getOriginalFilename());
				System.out.println(f.getSize());
			}
		}
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		productVO.setId(memberVO.getId());
		int result = productService.add(productVO, files);
		mv.setViewName("common/result");
		mv.addObject("result", result);

		return mv;
	}

	@GetMapping("detail")
	public ModelAndView detail(ProductVO productVO) throws Exception {
		// 모든 구매자가 보는 페이지

		ModelAndView mv = new ModelAndView();
		productVO = productService.detail(productVO);
		mv.addObject("vo", productVO);
		mv.setViewName("product/detail");
		return mv;
	}

	@GetMapping("manageDetail")
	public ModelAndView manageDetail(ProductVO productVO) throws Exception {
		// 판매자가 보는 페이지
		ModelAndView mv = new ModelAndView();
		productVO = productService.detail(productVO);
		mv.addObject("vo", productVO);
		mv.setViewName("product/manageDetail");
		return mv;
	}

	@GetMapping("update")
	public ModelAndView update(ProductVO productVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		productVO = productService.detail(productVO);
		mv.addObject("vo", productVO);
		mv.setViewName("product/update");
		return mv;
	}

	@PostMapping("update")
	public ModelAndView update(ProductVO productVO, MultipartFile[] files) throws Exception {
		ModelAndView mv = new ModelAndView();
		if (files != null) {
			for (MultipartFile f : files) {
				System.out.println(f.getOriginalFilename());
				System.out.println(f.getSize());
			}
		}
		int result = productService.update(productVO, files);
		if (result > 0) {
			mv.setViewName("redirect:./manage");
		} else {
			mv.setViewName("common/getResult");
			mv.addObject("msg", "업데이트 실패");
			mv.addObject("path", "./manageDetail?productNum=" + productVO.getProductNum());
		}
		return mv;
	}

	@PostMapping("fileDelete")
	public ModelAndView setFileDelete(ProductFilesVO productFilesVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = productService.fileDelete(productFilesVO);
		mv.setViewName("common/result");
		mv.addObject("result", result);
		return mv;
	}

	@GetMapping("delete")
	public ModelAndView delete(ProductVO productVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = productService.delete(productVO);
		if (result > 0) {
			mv.setViewName("redirect:./manage");
		} else {
			mv.setViewName("common/getResult");
			mv.addObject("msg", "삭제 실패");
			mv.addObject("path", "./manage");
		}
		return mv;
	}

	// 예외처리 메서드 ******************************************
	/*
	 @ExceptionHandler(BindException.class) public ModelAndView ex1() {
	 ModelAndView mv = new ModelAndView(); System.out.println("예외발생");
	 mv.setViewName("error/error");
	  
	 return mv; }
	  
	 @ExceptionHandler(NullPointerException.class) public ModelAndView ex2() {
	 ModelAndView mv = new ModelAndView();
	 System.out.println("Null Pointer 예외발생"); mv.setViewName("error/error");
	  
	 return mv; }
	 
	 @ExceptionHandler(Exception.class) public ModelAndView ex3() { ModelAndView
	 mv = new ModelAndView(); System.out.println("Exception 예외발생");
	 mv.setViewName("error/error");
	  
	 return mv; }
	  
	 @ExceptionHandler(Throwable.class) public ModelAndView ex4() { ModelAndView
	 mv = new ModelAndView(); System.out.println("Throwable 예외발생");
	 mv.setViewName("error/error");
	  
	 return mv; }
	 */

}
