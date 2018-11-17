package com.example.jdbcdemo.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.example.jdbcdemo.domain.Club;

public interface ClubService {
	
	Connection getConnection();
	void addClub(Club club) throws SQLException;
	void deleteClub(Club club) throws SQLException;
	void deleteAllClubs();
	List<Club> getAllClubs();
	
	/* batch insert - transactional */
	//public void addAllPersons(List<Club> persons);

}
