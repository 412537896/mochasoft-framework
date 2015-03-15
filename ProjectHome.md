持久层: mybatis、mybatis-spring，mybatis物理分页（支持oracle和mysql），Log4jdbc在开发时查看实际执行的SQL
连接池：目前是dbcp，可更换其他
业务层：spring 数据源配置、数据源动态切换、事务管理、依赖注入、切面拦截
控制层：springmvc 控制配置  ，SpringMVC3.0 Restful
对外服务：
> SOAP WebService： JAX-WS2.0的注解 + Apache CXF 无疑是最成熟的
> Restful Service： JAX-RS 1.0 + Jersey/CXF，够标准。但直接使用Spring MVC能使架构更简单
展现层：JSP2.0且尽量使用JSP EL而不是taglib，万一要写taglib也用纯JSP来编写
布局： SiteMesh2
Javascript库： 随大流用了JQuery1.8.3
CSS框架： 最热火的Twitter Bootstrap，提供了简便的布局能力和基本的页面美化
JavaScript/CSS压缩工具: 还是随便选的YUI Compressor
表单验证: JQuery Validation Plugin这种客户端校验的客户体验更好
权限框架： SpringSecurity
缓存： 抽取cache接口，写EHcache和Memcached的实现，Client方面，比较稳健选择的还是Spymemcached
定时任务： Quartz更大的优势体现在保证集群中有且仅有一台服务器执行任务
电子邮件: Spring自带的Email封装挺好用的
日志管理: Slf4j作为入口，下面的实现还是选Log4j，后期考虑该做为作者的后作Logback
单元测试：junit4