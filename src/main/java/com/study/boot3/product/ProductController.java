package com.study.boot3.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.study.boot3.util.Pager;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("manage")
	public ModelAndView manage()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product/manage");
		return mv;
	}
	
	@GetMapping("list")
	public ModelAndView list(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		List<ProductVO> ar = productService.list(pager);
		mv.addObject("list", ar);
		mv.setViewName("product/list");
		return mv;
	}
	
	@GetMapping("add")
	public void add() throws Exception{
	}
	
	@GetMapping("ajaxList")
	public ModelAndView getAjaxList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		List<ProductVO> ar = productService.list(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("common/productList");
		return mv;
	}
	
	@PostMapping("add")
	public ModelAndView add(ProductVO productVO,MultipartFile [] files) throws Exception{
		ModelAndView mv = new ModelAndView();
		for(MultipartFile f:files) {
			System.out.println(f.getOriginalFilename());
			System.out.println(f.getSize());
		}
		int result = productService.add(productVO, files);
		mv.setViewName("common/result");
		mv.addObject("result", result);
		
		return mv;
	}
	
	@GetMapping("detail")
	public ModelAndView detail(ProductVO productVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		productVO = productService.detail(productVO);
		mv.addObject("VO", productVO);
		mv.setViewName("product/detail");
		return mv;
	}
	
}














