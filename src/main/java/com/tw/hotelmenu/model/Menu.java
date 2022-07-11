package com.tw.hotelmenu.model;

import javax.persistence.*;
import java.util.Objects;


import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="Menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Name;

    private double price;

    public Menu( String name, double price) {
        this.Name = name;
        this.price = price;
    }

    public Menu() {

    }

    public Menu(long i, String name, double price) {
        this.id=i;
        this.Name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu  = (Menu) o;
        return price == menu.price && Objects.equals(id, menu.id) && Objects.equals(Name, menu.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Name, price);
    }
}
