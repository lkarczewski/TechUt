package com.example.jdbcdemo.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.example.jdbcdemo.domain.Club;

public interface ClubService {
	
	Connection getConnection();
	boolean addClub(Club club) throws SQLException;
	boolean addClubs(List<Club> clubs) throws SQLException;
	boolean deleteClub(Club club) throws SQLException;
	boolean deleteClubs();
	List<Club> getAllClubs();
	boolean deleteClubs(List<Club> clubs);
	boolean selectClubById(long id);
	boolean selectClubByName(String name);
	Club getClubById(long id);
	Club getClubByName(String name);
	boolean deleteClubById(long id);
	boolean deleteClubByName(String name);
	List<Club> getClubsAssets(double min, double max);
	
	
	/* batch insert - transactional */
	//public void addAllPersons(List<Club> persons);

}
