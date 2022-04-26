package com.study.boot3.aop;

import org.springframework.stereotype.Component;

@Component
public class Transfer {
	
	public void bus() {
		System.out.println("Bus 탑승");
	}
	
	public void subway() {
		System.out.println("지하철 탑승");
	}
	
}
