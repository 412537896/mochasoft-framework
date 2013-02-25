package com.mochasoft.fk.security.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 * <strong>Title : DatabasePasswordService </strong>. <br>
 * <strong>Description : 将数据库中Mocha_Secu_Users表的password字段明文密码用MD5编码
 * ，是工具类.</strong> <br>
 * <strong>Create on : 2013-1-22 下午12:52:08 </strong>. <br>
 * <p>
 * <strong>Copyright (C) Mocha Software Co.,Ltd.</strong> <br>
 * </p>
 * @author wanghe wanghe@mochasoft.com.cn <br>
 * @version <strong>FrameWork v0.8</strong> <br>
 * <br>
 * <strong>修改历史: .</strong> <br>
 * 修改人 修改日期 修改描述<br>
 * -------------------------------------------<br>
 * <br>
 * <br>
 */
public class DatabasePasswordService extends JdbcDaoSupport {
	@Autowired
	private IUserService service;
	
	@Transactional
	public void secureDatabase() {
		getJdbcTemplate().query("select user_id, password from mocha_secu_user", new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				String username = rs.getString(1);
				String password = rs.getString(2);
				service.changePassword(username, password);
			}			
		});
	}
}
