package com.example.sportClub.service;

import java.util.List;

import com.example.sportClub.domain.SportClub;

public interface SportClubManager {

	public int addSportClub(SportClub sportClub);
	public int deleteSportClubById(long id);
	public int getSportClubByName(String name);
	public void deleteAllSportClubs();
	public List<SportClub> getAllSportClubs();
	
}
