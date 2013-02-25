package com.mochasoft.example.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import com.mochasoft.example.entity.Team;
import com.mochasoft.fk.test.spring.SpringTransactionalTestCase;

@DirtiesContext
public class TeamMybatisDaoTest extends SpringTransactionalTestCase {

	@Autowired
	private TeamMybatisDao teamDao;

	@Test
	public void getTeamWithDetail() throws Exception {
		Team team = teamDao.getWithDetail(1L);
		assertEquals("Dolphin", team.getName());
		assertEquals("Admin", team.getMaster().getName());
		assertEquals(5, team.getUserList().size());
	}

}
