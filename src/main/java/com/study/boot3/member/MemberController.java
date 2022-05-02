package com.study.boot3.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("join")
	public void join() throws Exception{}
	
	@PostMapping("join")
	public ModelAndView join(MemberVO memberVO, String roleName ,MultipartFile file) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = memberService.join(memberVO,roleName,file);
		mv.setViewName("redirect:./join");
		if(0<result) {
		mv.setViewName("redirect:../");
		}
		return mv;
	}
	
	@GetMapping("login")
	public void login() throws Exception{}
	
	@PostMapping("login")
	public ModelAndView login(MemberVO memberVO, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		memberVO = memberService.login(memberVO);
		mv.setViewName("redirect:./login");
		if(memberVO!=null) {			
		session.setAttribute("member", memberVO);
		mv.setViewName("redirect:../");
		}
		return mv;
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:../";
	}
	
	@GetMapping("mypage")
	public ModelAndView mypage(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		memberVO = memberService.mypage(memberVO);
		mv.addObject("vo", memberVO);
		mv.setViewName("member/mypage");
		return mv;
	}
	
	@GetMapping("update")
	public ModelAndView update(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		memberVO = memberService.mypage(memberVO);
		mv.addObject("vo", memberVO);
		mv.setViewName("member/update");
		return mv;
	}
	
	@PostMapping("update")
	public ModelAndView update(MemberVO memberVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = memberService.update(memberVO);
		mv.setViewName("redirect:./update");
		if(0<result) {
		mv.setViewName("redirect:./mypage");
		}
		return mv;
	}
	
	@GetMapping("delete")
	public ModelAndView delete(HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberVO memberVO=(MemberVO)session.getAttribute("member");
		int result = memberService.delete(memberVO);
		session.invalidate();
		mv.setViewName("redirect:../");
		return mv;
	}
	
	@GetMapping("findId")
	public void findId()throws Exception {}
	
	@PostMapping("findId")
	public ModelAndView findId(MemberVO memberVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		memberVO = memberService.findId(memberVO);
		mv.setViewName("member/findIdResult");
		mv.addObject("member", memberVO);
		return mv;
		
	}
	
}
