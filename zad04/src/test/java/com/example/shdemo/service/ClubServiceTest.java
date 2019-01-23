package com.example.shdemo.service;

import com.example.shdemo.domain.Boots;
import com.example.shdemo.domain.Club;
import com.example.shdemo.domain.Player;

import com.example.shdemo.domain.Title;
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

	private final String BOOTS_BRAND_1 = "Adidas";
	private final String BOOTS_MODEL_1 = "Predator";
	private final int BOOTS_SIZE_1 = 43;
	private final String BOOTS_BRAND_2 = "Nike";
	private final String BOOTS_MODEL_2 = "Tiempo";
	private final int BOOTS_SIZE_2 = 45;

	private final String TITLE_NAME_1 = "UEFA Champions League";
	private final int TITLE_YEAR_1 = 1993;
	private final String TITLE_NAME_2 = "FIFA World Cup";
	private final int TITLE_YEAR_2 = 1998;
	private final String TITLE_NAME_3 = "Premier League";
	private final int TITLE_YEAR_3 = 2004;

	//TESTY DLA CLUB

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
		assertEquals(1, clubService.getAllClubs().size());
		clubService.deleteClub(club);
		assertEquals(0, clubService.getAllClubs().size());
	}

	@Test
	public void updateClubTest() {
		Club club = new Club();
		club.setName(CLUB_NAME_1);
		club.setDateOfFoundation(CLUB_DOF_1);
		club.setChampion(CLUB_CHAMPION_1);
		club.setAssets(CLUB_ASSETS_1);

		clubService.addClub(club);
		Club retrievedClub = clubService.findClubById(club.getId());
		assertEquals(CLUB_NAME_1, retrievedClub.getName());

		club.setName(CLUB_NAME_2);
		club.setDateOfFoundation(CLUB_DOF_2);
		club.setChampion(CLUB_CHAMPION_2);
		club.setAssets(CLUB_ASSETS_2);
		clubService.updateClub(club);
		retrievedClub = clubService.findClubById(club.getId());

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

	//TESTY DLA PLAYER

	@Test
	public void addPlayerTest() {
		Player player = new Player();
		player.setFirstName(PLAYER_FIRST_NAME_1);
		player.setLastName(PLAYER_LAST_NAME_1);
		player.setNationality(PLAYER_NATIONALITY_1);

		clubService.addPlayer(player);

		Player retrievedPlayer = clubService.findPlayerById(player.getId());
		assertEquals(PLAYER_FIRST_NAME_1, retrievedPlayer.getFirstName());
		assertEquals(PLAYER_LAST_NAME_1, retrievedPlayer.getLastName());
		assertEquals(PLAYER_NATIONALITY_1, retrievedPlayer.getNationality());
	}

	@Test
	public void deletePlayerTest() {
		Player player = new Player();
		player.setFirstName(PLAYER_FIRST_NAME_1);
		player.setLastName(PLAYER_LAST_NAME_1);
		player.setNationality(PLAYER_NATIONALITY_1);

		clubService.addPlayer(player);
		assertEquals(1, clubService.getAllPlayers().size());
		clubService.deletePlayer(player);
		assertEquals(0, clubService.getAllPlayers().size());
	}

	@Test
	public void updatePlayerTest() {
		Player player = new Player();
		player.setFirstName(PLAYER_FIRST_NAME_1);
		player.setLastName(PLAYER_LAST_NAME_1);
		player.setNationality(PLAYER_NATIONALITY_1);
		clubService.addPlayer(player);
		Player retrievedPlayer = clubService.findPlayerById(player.getId());
		assertEquals(PLAYER_FIRST_NAME_1, retrievedPlayer.getFirstName());

		player.setFirstName(PLAYER_FIRST_NAME_2);
		player.setLastName(PLAYER_LAST_NAME_2);
		player.setNationality(PLAYER_NATIONALITY_2);
		clubService.updatePlayer(player);
		retrievedPlayer = clubService.findPlayerById(player.getId());

		assertEquals(PLAYER_FIRST_NAME_2, retrievedPlayer.getFirstName());
		assertEquals(PLAYER_LAST_NAME_2, retrievedPlayer.getLastName());
		assertEquals(PLAYER_NATIONALITY_2, retrievedPlayer.getNationality());
	}

	@Test
	public void getAllPlayersTest() {
		Player player1 = new Player(PLAYER_FIRST_NAME_1, PLAYER_LAST_NAME_1, PLAYER_NATIONALITY_1);
		Player player2 = new Player(PLAYER_FIRST_NAME_2, PLAYER_LAST_NAME_2, PLAYER_NATIONALITY_2);

		clubService.addPlayer(player1);
		clubService.addPlayer(player2);

		assertEquals(2, clubService.getAllPlayers().size());
	}

	//TESTY DLA BOOTS

	@Test
	public void addBootsTest() {
		Boots boots = new Boots();
		boots.setBrand(BOOTS_BRAND_1);
		boots.setModel(BOOTS_MODEL_1);
		boots.setSize(BOOTS_SIZE_1);
		clubService.addBoots(boots);

		Boots retrievedBoots = clubService.findBootsById(boots.getId());
		assertEquals(BOOTS_BRAND_1, retrievedBoots.getBrand());
		assertEquals(BOOTS_MODEL_1, retrievedBoots.getModel());
		assertEquals(BOOTS_SIZE_1, retrievedBoots.getSize());
	}

	@Test
	public void deleteBootsTest() {
		Boots boots = new Boots();
		boots.setBrand(BOOTS_BRAND_1);
		boots.setModel(BOOTS_MODEL_1);
		boots.setSize(BOOTS_SIZE_1);
		clubService.addBoots(boots);

		assertEquals(1, clubService.getAllBoots().size());
		clubService.deleteBoots(boots);
		assertEquals(0, clubService.getAllBoots().size());
	}

	@Test
	public void updateBootsTest() {
		Boots boots = new Boots();
		boots.setBrand(BOOTS_BRAND_1);
		boots.setModel(BOOTS_MODEL_1);
		boots.setSize(BOOTS_SIZE_1);
		clubService.addBoots(boots);

		Boots retrievedBoots = clubService.findBootsById(boots.getId());
		boots.setBrand(BOOTS_BRAND_2);
		boots.setModel(BOOTS_MODEL_2);
		boots.setSize(BOOTS_SIZE_2);
		clubService.updateBoots(boots);
		retrievedBoots = clubService.findBootsById(boots.getId());

		assertEquals(BOOTS_BRAND_2, retrievedBoots.getBrand());
		assertEquals(BOOTS_MODEL_2, retrievedBoots.getModel());
		assertEquals(BOOTS_SIZE_2, retrievedBoots.getSize());
	}

	@Test
	public void getAllBootsTest() {
		Boots boots1 = new Boots(BOOTS_BRAND_1, BOOTS_MODEL_1, BOOTS_SIZE_1);
		Boots boots2 = new Boots(BOOTS_BRAND_2, BOOTS_MODEL_2, BOOTS_SIZE_2);

		clubService.addBoots(boots1);
		clubService.addBoots(boots2);

		assertEquals(2, clubService.getAllBoots().size());
	}

	//TESTY DLA TITLE

	@Test
	public void addTitleTest() {
		Title title = new Title();
		title.setName(TITLE_NAME_1);
		title.setYear(TITLE_YEAR_1);
		clubService.addTitle(title);
		Title retrievedTitle = clubService.findTitleById(title.getId());

		assertEquals(TITLE_NAME_1, retrievedTitle.getName());
		assertEquals(TITLE_YEAR_1, retrievedTitle.getYear());
	}

	@Test
	public void deleteTitleTest() {
		Title title = new Title();
		title.setName(TITLE_NAME_1);
		title.setYear(TITLE_YEAR_1);
		clubService.addTitle(title);

		assertEquals(1, clubService.getAllTitles().size());
		clubService.deleteTitle(title);
		assertEquals(0, clubService.getAllTitles().size());
	}

	@Test
	public void updateTitleTest() {
		Title title = new Title();
		title.setName(TITLE_NAME_1);
		title.setYear(TITLE_YEAR_1);
		clubService.addTitle(title);

		Title retrievedTitle = clubService.findTitleById(title.getId());
		title.setName(TITLE_NAME_2);
		title.setYear(TITLE_YEAR_2);
		clubService.updateTitle(title);
		retrievedTitle = clubService.findTitleById(title.getId());

		assertEquals(TITLE_NAME_2, retrievedTitle.getName());
		assertEquals(TITLE_YEAR_2, retrievedTitle.getYear());
	}

	@Test
	public void getAllTitlesTest() {
		Title title1 = new Title(TITLE_NAME_1, TITLE_YEAR_1);
		Title title2 = new Title(TITLE_NAME_2, TITLE_YEAR_2);

		clubService.addTitle(title1);
		clubService.addTitle(title2);

		assertEquals(2, clubService.getAllTitles().size());
	}

	//TESTY RELACJI

	@Test
	public void assignPlayerToClubTest() {
		Club club = new Club(CLUB_NAME_1, CLUB_DOF_1, CLUB_CHAMPION_1, CLUB_ASSETS_1);
		Player player = new Player(PLAYER_FIRST_NAME_1, PLAYER_LAST_NAME_1, PLAYER_NATIONALITY_1);

		clubService.addClub(club);
		clubService.addPlayer(player);
		clubService.assignPlayerToClub(player, club);
		Player retrievedPlayer = clubService.findPlayerById(player.getId());

		assertEquals(club, retrievedPlayer.getClub());
	}

	@Test
	public void removePlayerFromClubTest() {
		Club club = new Club(CLUB_NAME_1, CLUB_DOF_1, CLUB_CHAMPION_1, CLUB_ASSETS_1);
		Player player = new Player(PLAYER_FIRST_NAME_1, PLAYER_LAST_NAME_1, PLAYER_NATIONALITY_1);

		clubService.addClub(club);
		clubService.addPlayer(player);
		clubService.assignPlayerToClub(player, club);
		clubService.removePlayerFromClub(player);
		Player retrievedPlayer = clubService.findPlayerById(player.getId());

		assertEquals(null, retrievedPlayer.getClub());
	}

	@Test
	public void givePlayerBootsTest() {
		Player player = new Player(PLAYER_FIRST_NAME_1, PLAYER_LAST_NAME_1, PLAYER_NATIONALITY_1);
		Boots boots = new Boots(BOOTS_BRAND_1, BOOTS_MODEL_1, BOOTS_SIZE_1);

		clubService.addPlayer(player);
		clubService.addBoots(boots);
		clubService.givePlayerBoots(player, boots);
		Player retrievedPlayer = clubService.findPlayerById(player.getId());

		assertEquals(boots, retrievedPlayer.getBoots());
	}

	@Test
	public void takePlayerBootsTest() {
		Player player = new Player(PLAYER_FIRST_NAME_1, PLAYER_LAST_NAME_1, PLAYER_NATIONALITY_1);
		Boots boots = new Boots(BOOTS_BRAND_1, BOOTS_MODEL_1, BOOTS_SIZE_1);

		clubService.addPlayer(player);
		clubService.addBoots(boots);
		clubService.givePlayerBoots(player, boots);
		clubService.takePlayerBoots(player);
		Player retrievedPlayer = clubService.findPlayerById(player.getId());

		assertEquals(null, retrievedPlayer.getBoots());
	}

	@Test
	public void givePlayerTitle() {
		Player player = new Player(PLAYER_FIRST_NAME_1, PLAYER_LAST_NAME_1, PLAYER_NATIONALITY_1);
		Title title = new Title(TITLE_NAME_1, TITLE_YEAR_1);

		clubService.addPlayer(player);
		clubService.addTitle(title);
		clubService.givePlayerTitle(player, title);
		Player retrievedPlayer = clubService.findPlayerById(player.getId());

		assertEquals(1, retrievedPlayer.getTitles().size());
	}

	/*@Test
	public void removePlayerTitle() {
		Player player = new Player(PLAYER_FIRST_NAME_1, PLAYER_LAST_NAME_1, PLAYER_NATIONALITY_1);
		Title title = new Title(TITLE_NAME_1, TITLE_YEAR_1);

		clubService.addPlayer(player);
		clubService.addTitle(title);
		clubService.givePlayerTitle(player, title);
		clubService.removePlayerTitle(player, title);
		Player retrievedPlayer = clubService.findPlayerById(player.getId());

		assertEquals(0, retrievedPlayer.getTitles().size());
	}*/
}
