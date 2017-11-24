package com.inspur.springboot.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
// @EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	// @Override
	// public void addResourceHandlers(ResourceHandlerRegistry registry) {
	// registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	// }

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("/queryuser");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		super.addViewControllers(registry);
	}

	// @Override
	// public void addInterceptors(InterceptorRegistry registry) {
	// registry.addInterceptor(new Interceptor());
	// }

}
