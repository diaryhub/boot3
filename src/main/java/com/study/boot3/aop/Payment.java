package com.study.boot3.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Payment {
	
	
	@Around("execution(* com.study.boot3.aop.Transfer.*())")
	public Object cardCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		//join point 핵심 로직 메서드
		System.out.println("탑승 전 카드 체크");
		Object obj = joinPoint.proceed();
		System.out.println("하차 시 카드 체크");
		return obj;
	}
	
	@Before("execution(* com.study.boot3.board.BoardService.get*(..))")
	public void before() {
		System.out.println("before");
	}
	@After("execution(* com.study.boot3.board.BoardService.get*(..))")
	public void after() {
		System.out.println("AfterReturning+AfterThrowing");
	}
	@AfterReturning("execution(* com.study.boot3.board.BoardService.get*(..))")
	public void afterReturning() {
		System.out.println("afterReturning");
	}
	@AfterThrowing("execution(* com.study.boot3.board.BoardService.get*(..))")
	public void afterThrowing() {
		System.out.println("afterThrowing");
	}

	
	
}
