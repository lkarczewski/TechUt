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
	
//	private final String PLAYER_FIRST_NAME_1 = "";
//	private final String PLAYER_LAST_NAME_1 = "";
//	private final String PLAYER_NATIONALITY_1 = "";
//	private final Club PLAYER_CLUB_1;
	

	@Test
	public void addClubTest() {
		
		List<Club> retrievedClubs = clubService.getAllClubs();
		
		for (Club club : retrievedClubs) {
			if (club.getName().equals(CLUB_NAME_1)) {
				clubService.deleteClub(club);
			}
		}
		
		Club club = new Club();
		club.setName(CLUB_NAME_1);
		club.setDateOfFoundation(CLUB_DOF_1);
		club.setChampion(CLUB_CHAMPION_1);
		club.setAssets(CLUB_ASSETS_1);
		
		clubService.addClub(club);
		
		Club retrievedClub = clubService.findClubById(club.getId());
		assertEquals(CLUB_NAME_1, retrievedClub.getName());
		assertEquals(CLUB_DOF_1, retrievedClub.getDateOfFoundation());
		assertEquals(CLUB_CHAMPION_1, retrievedClub.isChampion());
		assertEquals(CLUB_ASSETS_1, retrievedClub.getAssets(), 0);
	}
	
	@Test
}
