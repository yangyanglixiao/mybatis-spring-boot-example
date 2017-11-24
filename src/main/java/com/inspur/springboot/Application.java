package com.inspur.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.inspur.springboot.test.TestBean;

@Controller
// @RestController
// @EnableWebMvc
@SpringBootApplication
@ServletComponentScan
@MapperScan(basePackages = "com.inspur.springboot.mapper")
public class Application extends WebMvcConfigurerAdapter {
	@Autowired
	private TestBean testBean;

	private Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// @Override
	// public void run(String... args) throws Exception {
	// logger.info("服务启动完成!");
	// }

	// @RequestMapping("/")
	public String home() {
		return "queryuser";
		// String aa = testBean.getProductName() + ": " + testBean.getProductDate() + ":
		// " + testBean.productHeight + ": "
		// + testBean.getProductWidth();
		// String aa = testBean.getName() + ": " + testBean.getAge();
		// return aa;
	}
}
