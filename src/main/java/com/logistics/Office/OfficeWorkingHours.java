package com.logistics.Office;

import javax.persistence.*;

@Entity
@Table(
        name= "working_hours"
)
public class OfficeWorkingHours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="monday", columnDefinition = "varchar(255) default 09:00-15:00")
    private String monWorkingHour;

    @Column(name="tuesday", columnDefinition = "varchar(255) default 09:00-15:00")
    private String tueWorkingHour;

    @Column(name="wednesday", columnDefinition = "varchar(255) default 09:00-15:00")
    private String wedWorkingHour;

    @Column(name="thursday", columnDefinition = "varchar(255) default 09:00-15:00")
    private String thuWorkingHour;

    @Column(name="friday", columnDefinition = "varchar(255) default 09:00-15:00")
    private String friWorkingHour;

    @OneToOne(mappedBy = "officeWorkingHours")
    private Office office;

    public OfficeWorkingHours() {
    }

    public void setMonWorkingHour(String monWorkingHour) {
        this.monWorkingHour = monWorkingHour;
    }

    public void setTueWorkingHour(String tueWorkingHour) {
        this.tueWorkingHour = tueWorkingHour;
    }

    public void setWedWorkingHour(String wedWorkingHour) {
        this.wedWorkingHour = wedWorkingHour;
    }

    public void setThuWorkingHour(String thuWorkingHour) {
        this.thuWorkingHour = thuWorkingHour;
    }

    public void setFriWorkingHour(String friWorkingHour) {
        this.friWorkingHour = friWorkingHour;
    }

    public String getMonWorkingHour() {
        return monWorkingHour;
    }

    public String getTueWorkingHour() {
        return tueWorkingHour;
    }

    public String getWedWorkingHour() {
        return wedWorkingHour;
    }

    public String getThuWorkingHour() {
        return thuWorkingHour;
    }

    public String getFriWorkingHour() {
        return friWorkingHour;
    }


    @Override
    public String toString() {
        return "OfficeWorkingHours{" +
                "id=" + id +
                ", monWorkingHour='" + monWorkingHour + '\'' +
                ", tueWorkingHour='" + tueWorkingHour + '\'' +
                ", wedWorkingHour='" + wedWorkingHour + '\'' +
                ", thuWorkingHour='" + thuWorkingHour + '\'' +
                ", friWorkingHour='" + friWorkingHour + '\'' +
                '}';
    }
}
