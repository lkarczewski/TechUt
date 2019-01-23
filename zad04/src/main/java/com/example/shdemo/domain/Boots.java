package com.example.shdemo.domain;

import javax.persistence.*;

@Entity
@NamedQueries( {
        @NamedQuery(name = "boot.id", query = "SELECT b FROM Boots b WHERE b.id = :id"),
        @NamedQuery(name = "boot.all", query = "SELECT b FROM Boots b")
})

public class Boots {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String brand;

    @Column
    private String model;

    @Column
    private int size;

    public Boots() { }

    public Boots(String brand, String model, int size) {
        this.brand = brand;
        this.model = model;
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
