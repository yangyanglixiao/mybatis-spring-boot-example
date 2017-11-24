package com.inspur.springboot.conf;

import javax.servlet.Servlet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
	FilterRegistrationBean registrationBean = new FilterRegistrationBean();
	registrationBean.setFilter(SpringBootDemoFilter());
	registrationBean.addUrlPatterns("/*");
	registrationBean.setName("filterDemo");
	registrationBean.setOrder(2);
	return registrationBean;
	
	}

	// @Bean
	// public ServletRegistrationBean servletRegistrationBean() {
	// ServletRegistrationBean servletRegistrationBean = new
	// ServletRegistrationBean();
	// servletRegistrationBean.setServlet(springBootDemoServlet());
	// servletRegistrationBean.addUrlMappings("/inspur");
	// return servletRegistrationBean;
	//
	// }

	// @Bean
	// public ServletListenerRegistrationBean<SpringBootDemoListener>
	// servletListenerRegistrationBean() {
	// ServletListenerRegistrationBean<SpringBootDemoListener>
	// servletListenerRegistrationBean = new
	// ServletListenerRegistrationBean<SpringBootDemoListener>();
	// servletListenerRegistrationBean.setListener(new SpringBootDemoListener());
	// return servletListenerRegistrationBean;
	// }

	// @Bean
	// public Filter SpringBootDemoFilter() {
	// return new SpringBootDemoFilter();
	// }

	@Bean
	public Servlet springBootDemoServlet() {
		return new SpringBootDemoServlet();
	}
}
