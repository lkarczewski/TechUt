package com.example.jdbcdemo.service;

import java.util.List;

import com.example.jdbcdemo.domain.Club;

public interface ClubService {
	
	int addClub(Club club);
	int deleteClub(Club club);
	List<Club> getAllClubs();
	
	/* batch insert - transactional */
	public void addAllPersons(List<Club> persons);

}
