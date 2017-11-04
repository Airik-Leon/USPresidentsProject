package com.skilldistillery.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skilldistillery.data.President;
import com.skilldistillery.data.PresidentDAO;
import com.skilldistillery.data.USPresidentDAOImpl;

public class USPresidentsTests {
	PresidentDAO dao; 
	@Before
	public void setUp() throws Exception {
		dao = new USPresidentDAOImpl();
	}

	@After
	public void tearDown() throws Exception {
		dao = null; 
	}

	@Test
	public void testPositiveLoadOfPresidents() {
		assertEquals(dao.getListPresidents().size(), 45); 
	}
	@Test
	public void testListHasOnlyOneParty() {
		List<President> test = dao.getPresidentsByParty("Federalist");
		for (President president : test) {
			assertTrue(president.getParty().equals("Federalist")); 
		}
	}
}
