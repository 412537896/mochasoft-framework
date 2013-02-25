package com.mochasoft.fk.security.filter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import com.mochasoft.fk.security.entity.IUserDetails;
import com.mochasoft.fk.security.entity.User;
import com.mochasoft.fk.security.entity.UserDetailsImpl;
import com.mochasoft.fk.security.service.IRoleUserService;

//2
public class DefaultUserDetailServiceImpl extends JdbcDaoImpl implements UserDetailsService {
	@Autowired
	private IRoleUserService roleUserService;
//	@Autowired
//	private UserCache userCache;
	private String adminNames = "admin";
	
	
	
	private static final String ROLE_USER  = "普通用户角色";
	private static final String ROLE_ADMIN = "系统管理角色";
	
	//登录验证
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(usersByUsernameQuery == null) {
			usersByUsernameQuery = "SELECT A.USER_ID,A.PASSWORD,A.STATUS,A.USERNAME FROM MOCHA_SECU_USER A WHERE A.USER_ID = ?";
		}
		User user = new UsersByUsernameMapping(userDataSource, usersByUsernameQuery).findObject(username);
		if (user == null) {
			throw new UsernameNotFoundException("用户" + username + "不存在。");
		}
		Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(user);
		
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		//封装成spring security的user
		IUserDetails userdetail = new UserDetailsImpl(user.getUserId(), user.getPassword(), 
				user.getStatus() == 1 ? true : false, 
				accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuths);
		userdetail.setName(user.getUsername());
		return userdetail;
	}
	
	//取得用户的角色列表
	private Set<GrantedAuthority> obtionGrantedAuthorities(User user) {
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		List<String> roleNames = roleUserService.selectByUserId(user.getUserId());
		for(String roleName : roleNames) {
			authSet.add(new SimpleGrantedAuthority(roleName));
		}
		if ((authSet == null) || (authSet.size() == 0)) {
			authSet.add(new SimpleGrantedAuthority(ROLE_USER));
			if (this.adminNames.equals(user.getUserId())) {
				authSet.add(new SimpleGrantedAuthority(ROLE_ADMIN));
			}
		}
		return authSet;
	}
	
	private DataSource userDataSource;
	private String usersByUsernameQuery;
	public DataSource getUserDataSource() {
		return userDataSource;
	}

	public void setUserDataSource(DataSource userDataSource) {
		this.userDataSource = userDataSource;
	}
	public String getUsersByUsernameQuery() {
		return usersByUsernameQuery;
	}

	public void setUsersByUsernameQuery(String usersByUsernameQuery) {
		this.usersByUsernameQuery = usersByUsernameQuery;
	}


	protected class UsersByUsernameMapping extends MappingSqlQuery<User>  {
		protected UsersByUsernameMapping(DataSource ds, String sql) {
			super(ds, sql);
			declareParameter(new SqlParameter(Types.VARCHAR));
			compile();
		}
		@Override
		public User findObject(String username) throws DataAccessException {
			return super.findObject(username);
		}
		@Override
	    protected User mapRow(ResultSet rs, int rownum) throws SQLException {
	      String userId = rs.getString("USER_ID");
	      String password = rs.getString("PASSWORD");
	      short status = rs.getShort("STATUS");
	      String username = rs.getString("USERNAME");
	      return new User(userId,password,status,username);
	    }
	 }
}
