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
	
	@PostMapping("add")
	public ModelAndView add(ProductVO productVO,MultipartFile [] files) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = productService.add(productVO, files);
		mv.setViewName("redirect:./add");
		if(result>0) {
		mv.setViewName("redirect:./list");
		}
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














