package com.example.shdemo.service;

import com.example.shdemo.domain.Boots;
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

    Long addBoots(Boots boots);
    void deleteBoots(Boots boots);
    Long updateBoots(Boots boots);
    List<Boots> getAllBoots();
    Boots findBootsById(long id);

    void assignPlayerToClub(Player player, Club club);
    void removePlayerFromClub(Player player);

    void givePlayerBoots(Player player, Boots boots);
    void takePlayerBoots(Player player);
}
