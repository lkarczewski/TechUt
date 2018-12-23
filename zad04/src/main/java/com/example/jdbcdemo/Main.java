package com.example.jdbcdemo;

import com.example.jdbcdemo.domain.Club;
import com.example.jdbcdemo.service.ClubService;
import com.example.jdbcdemo.service.ClubServiceJDBC;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		ClubServiceJDBC service = new ClubServiceJDBC();
		
		List<Club> clubs = new ArrayList<>();
		Club getClub;
		List<Club> getClubs;
		
		Club legia = new Club("Legia Warszawa", "1916-01-01", true, 10000000);
		Club lks = new Club("ŁKS Łódź", "1908-01-01", true, 5000000);
		Club wisla = new Club("Wisła Kraków", "1906-01-01", true, 7500000);
		Club lech = new Club("Lech Poznań", "1922-01-01", true, 12000000);
		clubs.add(legia);
		clubs.add(lks);
		
		service.addClub(wisla);
		service.addClub(lech);
		service.addClubs(clubs);
		
		//service.deleteClubs();
	}
}
