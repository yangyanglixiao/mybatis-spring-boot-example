package com.inspur.springboot.conf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Interceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse reponse, Object Handler) throws Exception {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>进入拦截器<<<<<<<<<<<<<<<<<<");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println(">>>>>>>>>>>>出拦截器<<<<<<<<<<<<<<<<<<<<<<");
	}
}
