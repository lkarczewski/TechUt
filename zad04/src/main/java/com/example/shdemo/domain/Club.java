package com.example.shdemo.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries( {
        @NamedQuery(name = "club.id", query = "SELECT c FROM Club c WHERE c.id = :id"),
        @NamedQuery(name = "club.all", query = "SELECT c FROM Club c")
})
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String dateOfFoundation;

    @Column
    private boolean isChampion;

    @Column
    private double assets;

    @OneToMany
    private List<Player> players;

    public Club() { }

    public Club(String name, String dateOfFoundation, boolean isChampion, double assets) {
        this.name = name;
        this.dateOfFoundation = dateOfFoundation;
        this.isChampion = isChampion;
        this.assets = assets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfFoundation() {
        return dateOfFoundation;
    }

    public void setDateOfFoundation(String dateOfFoundation) {
        this.dateOfFoundation = dateOfFoundation;
    }

    public boolean isChampion() {
        return isChampion;
    }

    public void setChampion(boolean champion) {
        isChampion = champion;
    }

    public double getAssets() {
        return assets;
    }

    public void setAssets(double assets) {
        this.assets = assets;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
