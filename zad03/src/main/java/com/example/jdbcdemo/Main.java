package com.example.jdbcdemo;

import com.example.jdbcdemo.domain.Club;
import com.example.jdbcdemo.service.ClubService;
import com.example.jdbcdemo.service.ClubServiceJDBC;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws SQLException {

		ClubServiceJDBC clubService = new ClubServiceJDBC();

		Club c1 = new Club("Lechia Gdańsk","1945-01-01",false,20000000);
		Club c2 = new Club("Legia Warszawa", "1916-03-01", true, 40000000);
		Club c3 = new Club("Lech Poznań", "1920-08-01", true, 35000000);
		Club c4 = new Club("Jagiellonia Białystok", "1920-05-30", false, 15000000);
		System.out.println("Add club test1: " + c1 + ": " + clubService.addClub(c1));
		System.out.println("Add club test2: " + c2 + ": " + clubService.addClub(c2));
		System.out.println("Add club test3: " + c3 + ": " + clubService.addClub(c3));
		System.out.println("Add club test4: " + c4 + ": " + clubService.addClub(c4));

		List<Club> clubList = new ArrayList<>();
		clubList.add(new Club("Pogoń Szczecin", "1948-04-21", false, 7000000));
		clubList.add(new Club("Piast Gliwice", "1945-06-18", false, 6000000));
		clubList.add(new Club("Korona Kielce", "1973-07-10", false, 8000000));
		clubList.add(new Club("Wisła Kraków", "1906-01-01", true, 0));
		System.out.println("Add list of clubs test: " + clubService.addClubs(clubList));

		System.out.println("Get club by id test: " + clubService.getClubById(7));
		System.out.println("Get club by name test: " + clubService.getClubByName("Wisła Kraków"));
		System.out.println("Get all clubs test: " + clubService.getAllClubs());
		System.out.println("Get clubs by assets in range test: " + clubService.getClubsByAssetsInRange(5000000,10000000));

		/*System.out.println("Delete club by id test: " + clubService.deleteClubById(2));
		System.out.println("Delete club by name test: " + clubService.deleteClubByName(c3.getName()));
		System.out.println("Delete club list test: " + clubService.deleteClubList(clubList));
		System.out.println("Delete all clubs test: " + clubService.deleteAllClubs());*/
	}
}
