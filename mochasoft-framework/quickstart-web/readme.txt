现状：
	持久层:
		mybatis
		mybatis-spring
		mybatis物理分页（支持oracle和mysql）
		Log4jdbc在开发时查看实际执行的SQL
		连接池：目前是dbcp，可更换其他
	业务层：
		spring 数据源配置、数据源动态切换、事务管理、依赖注入、切面拦截
	控制层：
		springmvc 控制配置  ，SpringMVC3.0 Restful
	对外服务：
		计划做：SOAP WebService： JAX-WS2.0的注解 + Apache CXF 无疑是最成熟的
		计划做：Restful Service： JAX-RS 1.0 + Jersey/CXF，够标准。但直接使用Spring MVC能使架构更简单
	展现层：
		Template：JSP2.0且尽量使用JSP EL而不是taglib，万一要写taglib也用纯JSP来编写
		布局： SiteMesh2
		Javascript Library： 随大流用了JQuery1.8.3
		CSS Framework： 最热火的Twitter Bootstrap，提供了简便的布局能力和基本的页面美化
		JavaScript/CSS Compressor: 还是随便选的YUI Compressor
		Validation: JQuery Validation Plugin这种客户端校验的客户体验更好
		
	Security Framework： SpringSecurity
	
	Cache：
		计划做：抽取cache接口，写EHcache和Memcached的实现，Client方面，比较稳健选择的还是Spymemcached
	Schedule： 
		计划做：Quartz更大的优势体现在保证集群中有且仅有一台服务器执行任务	
	JSON: 
		Jackson的功能更加丰富到匪夷所思
	Email: 
		计划做：Spring自带的Email封装挺好用的
	Logging: 
		Slf4j作为入口，下面的实现还是选Log4j，后期考虑该做为作者的后作Logback
	Test:
		junit4
		
	开发工具：已提供

           
待办：
	鉴权改造        王洪恩	DefaultSecurityMetadataSource  url匹配这里可以做很多事情
	分类导航	       尹维   
	国际化支持(springMvc)  姚峰
	Cache：				      姚峰 	
		计划做：抽取cache接口，写EHcache和Memcached的实现，Client方面，比较稳健选择的还是Spymemcached
	2.配置信息 数据库存储       姚峰
		需求：1）容器启动时自动加载
			  2）容器运行时可刷新加载  一项 或 全部
			  3）后面考虑不存在本地内存，存入Memcached
			  
	对外服务：				陈娟宝
		计划做：SOAP WebService： JAX-WS2.0的注解 + Apache CXF 无疑是最成熟的
		计划做：Restful Service： JAX-RS 1.0 + Jersey/CXF，够标准。但直接使用Spring MVC能使架构更简单
	
	Email: 					何明望
		计划做：Spring自带的Email封装挺好用的	
	
	Schedule： 				陈娟宝
		计划做：Quartz更大的优势体现在保证集群中有且仅有一台服务器执行任务	
	
	4.页面改造  UI会议后再定	何明望
	
	5.日志拦截器
	异常	
	
	文档：					何明旺、王洪恩、姚峰、陈娟宝
		开发框架使用手册
		sample功能说明
		JavaDoc	
		培训教程
		开发规范
-------------------------------2-28----------------------------------------		
	Jenkins做持续集成, Sonar做代码质量检查
	提高：代码生成工具，从SpringMVC Service  Mapper  XML一体化
     
project是父工程，定义依赖版本
core是打算 写一些  service和 dao层的 父类
springmvc是最基础的springmvc+spring+mybatis
quickstart-web是在 springmvc之上 加了springsecurity
并准备把人员组织、鉴权、导航整理到这个工程中
      