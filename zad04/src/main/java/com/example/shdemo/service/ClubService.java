package com.example.shdemo.service;

import com.example.shdemo.domain.Club;
import com.example.shdemo.domain.Player;

import java.util.List;

public interface ClubService {

    Long addClub(Club club);
    void deleteClub(Club club);
    Long updateClub(Club club);
    List<Club> getAllClubs();
    Club findClubById(long id);

    Long addPlayer(Player player);
    void deletePlayer(Player player);
    Long updatePlayer(Player player);
    List<Player> getAllPlayers();
    Player findPlayerById(long id);

    void assignPlayerToClub(long playerId, long clubId);
    void removePlayerFromClub(long playerId);
}
