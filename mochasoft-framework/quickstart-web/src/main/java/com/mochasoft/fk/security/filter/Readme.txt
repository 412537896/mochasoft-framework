流程
	1）容器启动(DefaultSecurityMetadataSource：loadResourceDefine加载系统资源与权限列表)
	2）用户发出请求
	3）过滤器拦截(FilterSecurityInterceptor:doFilter)
	4）取得请求资源所需权限(DefaultSecurityMetadataSource:getAttributes)
	5）匹配用户拥有权限和请求权限(DefaultAccessDecisionManager:decide)
	6）登录
	7）验证并授权(DefaultUserDetailService:loadUserByUsername)
	8）重复4,5
	
Spring Security主要是由一下几部分组成的：
	SecurityContextHolder，提供几种访问SecurityContext的方式。
	SecurityContext，保存Authentication信息，和请求对应的安全信息。
	HttpSessionContextIntegrationFilter，为了在不同请求使用，把SecurityContext保存到 HttpSession里。
	Authentication，展示Spring Security特定的主体。
	GrantedAuthority，反应，在应用程序范围你，赋予主体的权限。
	UserDetails，通过你的应用DAO，提供必要的信息，构建Authentication对象。
	UserDetailsService，创建一个 UserDetails，传递一个 String类型的用户名（或者证书ID或其他）。
	现在，你应该对这种重复使用的组件有一些了解了。 让我们贴近看一下验证的过程。