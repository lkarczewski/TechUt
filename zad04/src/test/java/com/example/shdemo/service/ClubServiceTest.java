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
	
	private final String CLUB_NAME_2 = "FC Metz";
	private final String CLUB_DOF_2 = "01-01-1919";
	private final boolean CLUB_CHAMPION_2 = false;
	private final double CLUB_ASSETS_2 = 5000000;
	
	private final String PLAYER_FIRST_NAME_1 = "Didier";
	private final String PLAYER_LAST_NAME_1 = "Deschamps";
	private final String PLAYER_NATIONALITY_1 = "Francja";
	
	private final String PLAYER_FIRST_NAME_2 = "Robert";
	private final String PLAYER_LAST_NAME_2 = "Pires";
	private final String PLAYER_NATIONALITY_2 = "Francja";
	

	@Test
	public void addClubTest() {
		
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
	public void deleteClubTest() {
		
		Club club = new Club();
		club.setName(CLUB_NAME_1);
		club.setDateOfFoundation(CLUB_DOF_1);
		club.setChampion(CLUB_CHAMPION_1);
		club.setAssets(CLUB_ASSETS_1);
		
		clubService.addClub(club);
		assertEquals(1,clubService.getAllClubs().size());
		clubService.deleteClub(club);
		assertEquals(0, clubService.getAllClubs().size());
	}
	
	@Test
	public void updateClubTest() {
		
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
		retrievedClub.setName(CLUB_NAME_2);
		retrievedClub.setDateOfFoundation(CLUB_DOF_2);
		retrievedClub.setChampion(CLUB_CHAMPION_2);
		retrievedClub.setAssets(CLUB_ASSETS_2);
		
		assertEquals(CLUB_NAME_2, retrievedClub.getName());
		assertEquals(CLUB_DOF_2, retrievedClub.getDateOfFoundation());
		assertEquals(CLUB_CHAMPION_2, retrievedClub.isChampion());
		assertEquals(CLUB_ASSETS_2, retrievedClub.getAssets(), 0);
	}
	
	@Test
	public void getAllClubsTest() {
		
		Club club1 = new Club(CLUB_NAME_1, CLUB_DOF_1, CLUB_CHAMPION_1, CLUB_ASSETS_1);
		Club club2 = new Club(CLUB_NAME_2, CLUB_DOF_2, CLUB_CHAMPION_2, CLUB_ASSETS_2);
		
		clubService.addClub(club1);
		clubService.addClub(club2);
		
		assertEquals(2, clubService.getAllClubs().size());
	}
	
	/*@Test
	public void addPlayer() {
		
		Player player = new Player();
		player.setFirstName(PLAYER_FIRST_NAME_1);
		player.setLastName(PLAYER_LAST_NAME_1);
		player.setNationality(PLAYER_NATIONALITY_1);
		
		clubService.addPlayer(player);
		
		Player retruev = clubService.findClubById(club.getId());
		assertEquals(CLUB_NAME_1, retrievedClub.getName());
		assertEquals(CLUB_DOF_1, retrievedClub.getDateOfFoundation());
		assertEquals(CLUB_CHAMPION_1, retrievedClub.isChampion());
		assertEquals(CLUB_ASSETS_1, retrievedClub.getAssets(), 0);
	}*/
}
