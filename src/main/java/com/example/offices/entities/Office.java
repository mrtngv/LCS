package com.example.offices.entities;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;

@Entity
@Table(
        name= "offices"
)
public class Office {
    private Long id;
    private String location;
    private String city;

    public Office(Long id, String location, String city) {
        this.id = id;
        this.location = location;
        this.city = city;
    }

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
/*
    public static Comparator<Office> compareByCityName = new Comparator<Office>() {
        @Override
        public int compare(Office o1, Office o2) {
            return o1.city.compareTo(o2.city);
        }
    };

    public static Comparator<Office> compareByCityNameDescending = new Comparator<Office>(){
        @Override
        public int compare(Office o1, Office o2) {

            return o1.city.compareTo(o2.city)*-1;
        }
    };*/


    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
