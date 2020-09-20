package com.yc.crbook.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor{

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(request.getSession().getAttribute("loginedUser")==null) {
			response.sendRedirect("http://127.0.0.1/login.html");
			//返回false只是让请求不能到达控制器
			return false;
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	

}
