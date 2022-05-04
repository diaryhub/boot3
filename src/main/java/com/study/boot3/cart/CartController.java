package com.study.boot3.cart;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.study.boot3.member.MemberVO;


//@Controller
@RestController
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/cart/{productNum}/{count}")
	//@ResponseBody//RestController가 선언되어 있으면 생략 가능
	public int setAdd(HttpSession session,@PathVariable Long productNum,@PathVariable Long count)throws Exception{
		System.out.println("productNum:"+productNum);
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		CartVO cartVO = new CartVO();
		cartVO.setProductNum(productNum);
		cartVO.setId(memberVO.getId());	
		cartVO.setCount(count);
		int result = cartService.setAdd(cartVO);
		System.out.println("result : "+result);
		//result 를 JSON 형태로 바꿔주는 라이브러리 사용
		return result;
	}
	
	@GetMapping("/cart/{pn}")
	//@ResponseBody
	public List<CartVO> getList(HttpSession session, @PathVariable Long pn) throws Exception{
		System.out.println(pn);
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		CartVO cartVO = new CartVO();
		cartVO.setId(memberVO.getId());
		List<CartVO> ar = cartService.getList(cartVO);
		System.out.println("ar.size : "+ar.size());
		System.out.println(ar);
		return ar;
	}
	
	
	//@GetMapping("/cart/{pn}")
	public ModelAndView getList(@PathVariable Long pn) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("PN : "+pn);
		return mv;
	}
	@DeleteMapping("/cart/{cartNum}")
	public ModelAndView setDelete(@PathVariable Long cartNum) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("CartNum : "+cartNum);
		return mv;
	}
	
	
}
