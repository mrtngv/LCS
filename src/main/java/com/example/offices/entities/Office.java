package com.example.offices.entities;

import javax.persistence.*;

@Entity
@Table(
        name= "offices"
)
public class Office {
    private Long id;
    private String location;
    private String city;

    public Office() {
    }

    public Office(String location, String city) {
        this.location = location;
        this.city = city;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="location", nullable = false)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name="city", nullable = false)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
