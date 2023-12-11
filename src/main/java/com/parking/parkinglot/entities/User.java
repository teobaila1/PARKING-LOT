package com.parking.parkinglot.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    public User() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public Long getId() {
        return id;
    }
    @Basic
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    private Collection<Car> cars;
    @OneToMany (mappedBy = "owner")
    public Collection<Car> getCars() {
        return cars;
    }

    public void setCars(Collection<Car> cars) {
        this.cars = cars;
    }
}
