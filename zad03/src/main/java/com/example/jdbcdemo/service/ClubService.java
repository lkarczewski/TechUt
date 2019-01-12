package com.example.jdbcdemo.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.example.jdbcdemo.domain.Club;

public interface ClubService {
	
	//Connection getConnection();
	boolean addClub(Club club);
	boolean addClubs(List<Club> clubs) throws SQLException;
	boolean deleteClubById(long id);
	boolean deleteClubByName(String name);
	boolean deleteAllClubs();
	boolean deleteClubList(List<Club> clubs);
	Club getClubById(long id);
	Club getClubByName(String name);
	List<Club> getAllClubs();
	List<Club> getClubsByAssetsInRange(double min, double max, String order);
	List<Club> getClubsSortedByDate(String order);
}
