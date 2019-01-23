package com.example.shdemo.service;

import com.example.shdemo.domain.Boots;
import com.example.shdemo.domain.Club;
import com.example.shdemo.domain.Player;
import com.example.shdemo.domain.Title;

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

    Long addTitle(Title title);
    void deleteTitle(Title title);
    Long updateTitle(Title title);
    List<Title> getAllTitles();
    Title findTitleById(long id);

    void assignPlayerToClub(Player player, Club club);
    void removePlayerFromClub(Player player);

    void givePlayerBoots(Player player, Boots boots);
    void takePlayerBoots(Player player);

    void givePlayerTitle(Player player, Title title);
    void removePlayerTitle(Player player, Title title);
}
