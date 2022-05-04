package com.study.boot3.exception;

import java.net.BindException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionController {

	//@ExceptionHandler(BindException.class)
	public ModelAndView ex1() {
		ModelAndView mv = new ModelAndView();
		System.out.println("예외발생");
		mv.addObject("msg", "접근 불가");
		mv.addObject("path", "../");
		mv.setViewName("common/getResult");

		return mv;
	}

	//@ExceptionHandler(NullPointerException.class)
	public ModelAndView ex2() {
		ModelAndView mv = new ModelAndView();
		System.out.println("Null Pointer 예외발생");
		
		mv.addObject("msg", "접근 불가");
		mv.addObject("path", "../");
		mv.setViewName("common/getResult");
		return mv;
	}

	//@ExceptionHandler(Exception.class)
	public ModelAndView ex3(Exception e) {
		ModelAndView mv = new ModelAndView();
		System.out.println("Exception 예외발생");
		mv.setViewName("error/error");

		return mv;
	}

	@ExceptionHandler(Throwable.class)
	public ModelAndView ex4() {
		ModelAndView mv = new ModelAndView();
		System.out.println("Throwable 예외발생");
		mv.setViewName("error/error");

		return mv;
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView ex5() {
		ModelAndView mv = new ModelAndView();
		System.out.println("404 예외발생");
		mv.addObject("message", "Page를 찾을 수 없습니다.");
		mv.setViewName("error/error");
		
		return mv;
	}

}
