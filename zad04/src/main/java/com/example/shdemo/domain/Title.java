package com.example.shdemo.domain;

import javax.persistence.*;

@Entity
@NamedQueries( {
        @NamedQuery(name = "title.id", query = "SELECT t FROM Title t WHERE t.id = :id"),
        @NamedQuery(name = "title.all", query = "SELECT t FROM Title t")
})

public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private int year;

    public Title() { }

    public Title(String name, int year) {
        this.name = name;
        this.year = year;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
