package com.study.boot3.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.study.boot3.member.MemberVO;
import com.study.boot3.member.RoleVO;

@Component
public class MemberInterceptor implements HandlerInterceptor {

	@Value("${member.role.member}")
	private String roleName;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		boolean check = false;
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		if (memberVO!=null) {
			for (RoleVO roleVO : memberVO.getRoleVOs()) {
				if (roleVO.getRoleName().equals(roleName)) {
					check = true;
				}
			}
		}

		if (!check) {
			request.setAttribute("msg", "권한없음");
			request.setAttribute("path", "../board/list");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/getResult.jsp");
			view.forward(request, response);
		}

		return check;
	}

}
