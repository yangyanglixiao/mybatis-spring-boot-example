// package com.inspur.springboot.conf;
//
// import javax.servlet.ServletContext;
// import javax.servlet.ServletException;
// import javax.servlet.ServletRegistration.Dynamic;
//
// import org.springframework.web.WebApplicationInitializer;
// import
// org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
// import org.springframework.web.servlet.DispatcherServlet;
//
// public class WebInitializer implements WebApplicationInitializer {
//
// @Override
// public void onStartup(ServletContext servletContext) throws ServletException
// {
// // TODO Auto-generated method stub
// AnnotationConfigWebApplicationContext ctx = new
// AnnotationConfigWebApplicationContext();
//
// Dynamic servlet = servletContext.addServlet("dispatcher", new
// DispatcherServlet());// 注册SpringMVC的DispatcherServlet
// servlet.addMapping("/");
// servlet.setLoadOnStartup(1);
// // ctx.register(annotatedClasses);//注册自己的配置类
// // ctx.setServletContext(servletContext);//和当前的ServletContext关联
//
// }
//
// }
