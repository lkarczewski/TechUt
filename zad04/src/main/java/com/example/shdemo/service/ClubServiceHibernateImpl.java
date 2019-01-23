package com.example.shdemo.service;

import com.example.shdemo.domain.Boots;
import com.example.shdemo.domain.Club;
import com.example.shdemo.domain.Player;

import com.example.shdemo.domain.Title;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ClubServiceHibernateImpl implements ClubService {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long addClub(Club club) {
        club.setId(null);
        return (Long)sessionFactory.getCurrentSession().save(club);
    }

    @Override
    public void deleteClub(Club club) {
        sessionFactory.getCurrentSession().delete(club);
    }

    @Override
    public Long updateClub(Club club) {
        return (Long)sessionFactory.getCurrentSession().save(club);
    }

    @Override
    public List<Club> getAllClubs() {
        return sessionFactory.getCurrentSession().getNamedQuery("club.all").list();
    }

    @Override
    public Club findClubById(long id) {
        return (Club)sessionFactory.getCurrentSession().getNamedQuery("club.id").setLong("id", id).uniqueResult();
    }

    @Override
    public Long addPlayer(Player player) {
        player.setId(null);
        return (Long)sessionFactory.getCurrentSession().save(player);
    }

    @Override
    public void deletePlayer(Player player) {
        sessionFactory.getCurrentSession().delete(player);
    }

    @Override
    public Long updatePlayer(Player player) {

        return (Long)sessionFactory.getCurrentSession().save(player);
    }

    @Override
    public List<Player> getAllPlayers() {
        return sessionFactory.getCurrentSession().getNamedQuery("player.all").list();
    }

    @Override
    public Player findPlayerById(long id) {
        return (Player)sessionFactory.getCurrentSession().getNamedQuery("player.id").setLong("id", id).uniqueResult();
    }

    @Override
    public Long addBoots(Boots boots) {
        boots.setId(null);
        return (Long)sessionFactory.getCurrentSession().save(boots);
    }

    @Override
    public void deleteBoots(Boots boots) {
        sessionFactory.getCurrentSession().delete(boots);
    }

    @Override
    public Long updateBoots(Boots boots) {
        return (Long)sessionFactory.getCurrentSession().save(boots);
    }

    @Override
    public List<Boots> getAllBoots() {
        return sessionFactory.getCurrentSession().getNamedQuery("boot.all").list();
    }

    @Override
    public Boots findBootsById(long id) {
        return (Boots)sessionFactory.getCurrentSession().getNamedQuery("boot.id").setLong("id", id).uniqueResult();
    }

    @Override
    public Long addTitle(Title title) {
        title.setId(null);
        return (Long)sessionFactory.getCurrentSession().save(title);
    }

    @Override
    public void deleteTitle(Title title) {
        sessionFactory.getCurrentSession().delete(title);
    }

    @Override
    public Long updateTitle(Title title) {
        return (Long)sessionFactory.getCurrentSession().save(title);
    }

    @Override
    public List<Title> getAllTitles() {
        return sessionFactory.getCurrentSession().getNamedQuery("title.all").list();
    }

    @Override
    public Title findTitleById(long id) {
        return (Title)sessionFactory.getCurrentSession().getNamedQuery("title.id").setLong("id", id).uniqueResult();
    }

    @Override
    public void assignPlayerToClub(Player player, Club club) {

        if(player.getClub() == null) {
            player.setClub(club);
        }
        else return;

        sessionFactory.getCurrentSession().update(player);
    }

    @Override
    public void removePlayerFromClub(Player player) {

        if(player.getClub() != null) {
            player.setClub(null);
        }
        else return;

        sessionFactory.getCurrentSession().update(player);
    }

    @Override
    public void givePlayerBoots(Player player, Boots boots) {
        if(player.getBoots() == null) {
            player.setBoots(boots);
        }
        else return;

        sessionFactory.getCurrentSession().update(player);
    }

    @Override
    public void takePlayerBoots(Player player) {
        if(player.getBoots() != null) {
            player.setBoots(null);
        }
        else return;

        sessionFactory.getCurrentSession().update(player);
    }

    @Override
    public void givePlayerTitle(Player player, Title title) {
        player = (Player)getSessionFactory().getCurrentSession().get(Player.class, player.getId());
        title = (Title)getSessionFactory().getCurrentSession().get(Title.class, title.getId());

        if(player != null && title != null) {
            List<Title> playerTitles = player.getTitles();
            if(!playerTitles.contains(title)) {
                playerTitles.add(title);
            }
            player.setTitles(playerTitles);
            updatePlayer(player);
            sessionFactory.getCurrentSession().update(player);
        }
    }

    @Override
    public void removePlayerTitle(Player player, Title title) {
        player = (Player)getSessionFactory().getCurrentSession().get(Player.class, player.getId());
        title = (Title)getSessionFactory().getCurrentSession().get(Title.class, title.getId());

        if(player != null && title != null) {
            List<Title> playerTitles = player.getTitles();
            if(playerTitles.contains(title)) {
                playerTitles.remove(title);
            }
            else return;
            player.setTitles(playerTitles);
            updatePlayer(player);
            sessionFactory.getCurrentSession().update(player);
        }
    }
}
