package com.logistics.Office;
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

    @Size(max = 20)
    @Column(name = "weekdayHours")
    private String weekdayHours;

    @Size(max = 20)
    @Column(name = "saturdayHours")
    private String saturdayHours;

    @Size(max = 20)
    @Column(name = "sundayHours")
    private String sundayHours;

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

    public String getWeekdayHours() {
        return weekdayHours;
    }

    public void setWeekdayHours(String weekdayHours) {
        this.weekdayHours = weekdayHours;
    }

    public String getSaturdayHours() {
        return saturdayHours;
    }

    public void setSaturdayHours(String saturdayHours) {
        this.saturdayHours = saturdayHours;
    }

    public String getSundayHours() {
        return sundayHours;
    }

    public void setSundayHours(String sundayHours) {
        this.sundayHours = sundayHours;
    }

    public Office(String name, String city, String location, String weekdayHours, String saturdayHours, String sundayHours) {
        this.name = name;
        this.city = city;
        this.location = location;
        this.weekdayHours = weekdayHours;
        this.saturdayHours = saturdayHours;
        this.sundayHours = sundayHours;
    }

    public Office(String name, String city, String location) {
        this.name = name;
        this.city = city;
        this.location = location;
        this.weekdayHours = "09:00-19:00";
        this.saturdayHours = "09:00-13:00";
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
                ", weekdayHours='" + weekdayHours + '\'' +
                ", saturdayHours='" + saturdayHours + '\'' +
                ", sundayHours='" + sundayHours + '\'' +
                '}';
    }



}