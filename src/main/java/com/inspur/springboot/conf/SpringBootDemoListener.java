package com.inspur.springboot.conf;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//@WebListener
public class SpringBootDemoListener implements ServletContextListener {
	private Log log = LogFactory.getLog(SpringBootDemoListener.class);

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		log.info("IndexListener contextInitialized");
		System.out.println("Hello Listener");
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {

	}
}
