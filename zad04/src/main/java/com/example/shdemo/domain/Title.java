package com.example.shdemo.domain;

import javax.persistence.*;

@Entity
@NamedQueries( {
        @NamedQuery(name = "title.id", query = "SELECT t FROM Title WHERE t.id = :id"),
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
}
