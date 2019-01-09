package com.example.shdemo.domain;

import javax.persistence.*;

@Entity
@NamedQueries( {
        @NamedQuery(name = "player.id", query = "SELECT p FROM Player p WHERE p.id = :id"),
        @NamedQuery(name = "player.all", query = "SELECT p FROM Player p")
})

public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String nationality;

    @ManyToOne
    private Club club;

    public Player() { }

    public Player(String firstName, String lastName, String nationality, Club club) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.club = club;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
