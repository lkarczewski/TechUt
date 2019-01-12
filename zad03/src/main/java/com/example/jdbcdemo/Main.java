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
		List<Club> clubList = new ArrayList<>();

		clubList.add(new Club("Lechia Gdańsk","01-01-1945",false,20000000));
		clubList.add(new Club("Legia Warszawa", "01-03-1916", true, 40000000));
		clubList.add(new Club("Lech Poznań", "01-08-1920", true, 35000000));
		clubList.add(new Club("Jagiellonia Białystok", "30-05-1920", false, 15000000));
		clubList.add(new Club("Pogoń Szczecin", "21-04-1948", false, 5000000));
		clubList.add(new Club("Piast Gliwice", "18-06-1945", false, 6000000));
		clubList.add(new Club("Korona Kielce", "10-07-1973", false, 8000000));
		clubList.add(new Club("Wisła Kraków", "01-01-1906", true, 0));
	}
}
