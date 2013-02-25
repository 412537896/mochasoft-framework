package com.mochasoft.example.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import com.mochasoft.example.entity.Team;
import com.mochasoft.example.mapper.TeamMapper;
import com.mochasoft.fk.test.spring.SpringTransactionalTestCase;

@DirtiesContext
public class TeamMapperTest extends SpringTransactionalTestCase {

	@Autowired
	private TeamMapper teamDao;

	@Test
	public void getTeamWithDetail() throws Exception {
		Team team = teamDao.getWithDetail(1L);
		assertEquals("Dolphin", team.getName());
		assertEquals("Admin", team.getMaster().getName());
		assertEquals(5, team.getUserList().size());
	}

}
