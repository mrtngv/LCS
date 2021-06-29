package com.logistics.Office;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Comparator;


@Entity
@Table(
        name= "offices"
)
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 25)
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Size(max = 25)
    @Column(name = "city", nullable = false)
    private String city;

    @NotNull
    @Size(max = 50)
    @Column(name = "location", nullable = false)
    private String location;

    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "office_working_hours",
            joinColumns = @JoinColumn(
                    name = "office_id",
                    referencedColumnName = "office_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "officeWorkingHours_id",
                    referencedColumnName = "officeWorkingHours_id"
            ))
    private OfficeWorkingHours officeWorkingHours;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Office(String name, String city, String location) {
        this.name = name;
        this.city = city;
        this.location = location;
        this.officeWorkingHours = new OfficeWorkingHours();
    }

    public Office() {
    }

    public static Comparator<Office> compareByCityName = new Comparator<Office>() {
        @Override
        public int compare(Office o1, Office o2) {
            return o1.city.compareTo(o2.city);
        }
    };

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", location='" + location + '\'' +
                ", workingHours='" + officeWorkingHours + '\'' +
                '}';
    }



}