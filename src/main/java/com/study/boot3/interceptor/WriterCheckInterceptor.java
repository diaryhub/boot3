package com.study.boot3.interceptor;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.study.boot3.board.BoardMapper;
import com.study.boot3.board.BoardVO;
import com.study.boot3.member.MemberVO;

@Component
public class WriterCheckInterceptor implements HandlerInterceptor {

	@Autowired
	private BoardMapper boardMapper;

//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//			
//		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
//		Map<String, Object> map = modelAndView.getModel();
//		BoardVO boardVO = (BoardVO)map.get("vo");
//		
//		if(!boardVO.getWriter().equals(memberVO.getId())) {
//			//modelAndView.setViewName("redirect:./list");
//			modelAndView.addObject("msg", "작성자만 가능");
//			modelAndView.addObject("path", "./list");
//			modelAndView.setViewName("common/getResult");
//		}
//		
//	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String method = request.getMethod();
		System.out.println(method);
		
		boolean check = false;
		String num = request.getParameter("num");
		System.out.println(num);
		MemberVO memberVO = (MemberVO) request.getSession().getAttribute("member");
		if (memberVO != null) {
			BoardVO boardVO = new BoardVO();
			boardVO.setNum(Long.parseLong(num));
			boardVO = boardMapper.getDetail(boardVO);
			System.out.println(boardVO.getWriter());
			System.out.println(memberVO.getId());
			if(boardVO.getWriter().equals(memberVO.getId())) {				
				check = true;
			}
			
		}
		
		if(!check) {
			request.setAttribute("msg", "권한이 없습니다.");
			request.setAttribute("path", "../board/list");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/getResult.jsp");
			view.forward(request, response);
			
		}
		
		return check;
	}

}
