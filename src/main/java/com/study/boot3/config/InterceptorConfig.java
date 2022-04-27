package com.study.boot3.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.study.boot3.interceptor.AdminInterceptor;
import com.study.boot3.interceptor.MemberInterceptor;
import com.study.boot3.interceptor.SellerInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{

	@Autowired
	private SellerInterceptor sellerInterceptor;
	
	@Autowired
	private AdminInterceptor adminInterceptor;
	
	@Autowired
	private MemberInterceptor memberInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//적용할 interceptor를 registry에 등록
		
		registry.addInterceptor(sellerInterceptor)
		//interceptor를 사용할 URL
				.addPathPatterns("/product/manage")
		//추가할 URL
		//		.addPathPatterns("")
		//제외할 URL
		//		.excludePathPatterns("")
				;
		registry.addInterceptor(adminInterceptor)
				.addPathPatterns("/admin/manage");
				
		registry.addInterceptor(memberInterceptor)
				.addPathPatterns("/board/*")
				.excludePathPatterns("/board/list");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	
}
