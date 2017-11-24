### Spring Boot基础案例： 
- 前端使用thymeleaf引擎，同时在webapp中使用jsp（目的是为了SpringBoot应用jsp页面，可以在eclipse中正常访问，但是打成jar不可访问，原因：内嵌Tomcat不支持jsp同时jar包中jsp的路径不符合SpringBoot要求。解决：可以通过maven插件将jsp页面打到指定目录）；
- 后端使用Mybatis、pagehelper、通用mapper。利用通用mapper提供的crud完成；
- 只是个测试案例，测试了thymeleaf引擎、jsp、数据库、分页插件、通用mapper等内容。冗余测试内容未删除，布局较乱٩(๑❛ᴗ❛๑)۶