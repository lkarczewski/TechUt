package com.example.shdemo.service;

import com.example.shdemo.domain.Club;
import com.example.shdemo.domain.Player;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml"})
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional

public class ClubServiceTest {
	@Autowired
	ClubService clubService;

	private final String CLUB_NAME_1 = "Olympique Marsylia";
	private final String CLUB_DOF_1 = "31-01-1899";
	private final boolean CLUB_CHAMPION_1 = true;
	private final double CLUB_ASSETS_1 = 60000000;

	@Test
	public void addClubTest() {
		Club club = new Club();
		club.setName(CLUB_NAME_1);
		club.setDateOfFoundation(CLUB_DOF_1);
		club.setChampion(CLUB_CHAMPION_1);
		club.setAssets(CLUB_ASSETS_1);

		assertEquals(CLUB_NAME_1, club.getName());
		assertEquals(CLUB_DOF_1, club.getDateOfFoundation());
		assertEquals(CLUB_CHAMPION_1, club.isChampion());
		//assertEquals(CLUB_ASSETS_1, club.getAssets());
	}
}
