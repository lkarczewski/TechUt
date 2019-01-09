package com.example.shdemo.service;

import com.example.shdemo.domain.Club;
import com.example.shdemo.domain.Player;

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
        return (Player) sessionFactory.getCurrentSession().getNamedQuery("player.id").setLong("id", id).uniqueResult();
    }

    @Override
    public void assignPlayerToClub(long playerId, long clubId) {
        Player player = findPlayerById(playerId);
        Club club = findClubById(clubId);

        if(player.getClub() == null) {
            player.setClub(club);
        }
        else return;

        sessionFactory.getCurrentSession().update(player);
    }

    @Override
    public void removePlayerFromClub(long playerId) {
        Player player = findPlayerById(playerId);

        if(player.getClub() != null) {
            player.setClub(null);
        }
        else return;

        sessionFactory.getCurrentSession().update(player);
    }
}
