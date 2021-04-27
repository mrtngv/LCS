package com.example.offices.entities;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;
@Entity
@Table(
        name= "packages"
)
public class Package {

    private Long id;
    private String fromLocation;
    private String toLocation;
    private boolean toOffice;
    private double weight;
    private String clientSending;
    private String officeEmployee;
    private String clientReceiving;
    private String deliveryEmployee;
    private boolean deliveredOrNot;
    private double price;

    public Package() {
    }

    public Package(Long id, String fromLocation, String toLocation, boolean toOffice, double weight, String clientSending, String officeEmployee, String clientReceiving, String deliveryEmployee, boolean deliveredOrNot, double price) {
        this.id = id;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.toOffice = toOffice;
        this.weight = weight;
        this.clientSending = clientSending;
        this.officeEmployee = officeEmployee;
        this.clientReceiving = clientReceiving;
        this.deliveryEmployee = deliveryEmployee;
        this.deliveredOrNot = deliveredOrNot;
        this.price = price;
    }

    public Package(String fromLocation, String toLocation, boolean toOffice, double weight, String clientSending, String officeEmployee, String clientReceiving, String deliveryEmployee, boolean deliveredOrNot, double price) {
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.toOffice = toOffice;
        this.weight = weight;
        this.clientSending = clientSending;
        this.officeEmployee = officeEmployee;
        this.clientReceiving = clientReceiving;
        this.deliveryEmployee = deliveryEmployee;
        this.deliveredOrNot = deliveredOrNot;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Column(name = "fromLocation", nullable = false)
    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }


    @Column(name = "toLocation", nullable = false)
    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }


    @Column(name = "toOffice", nullable = false)
    public boolean isToOffice() {
        return toOffice;
    }

    public void setToOffice(boolean toOffice) {
        this.toOffice = toOffice;
    }


    @Column(name = "weight", nullable = false)
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    @Column(name = "clientSending", nullable = false)
    public String getClientSending() {
        return clientSending;
    }

    public void setClientSending(String clientSending) {
        this.clientSending = clientSending;
    }


    @Column(name = "officeEmployee", nullable = false)
    public String getOfficeEmployee() {
        return officeEmployee;
    }

    public void setOfficeEmployee(String officeEmployee) {
        this.officeEmployee = officeEmployee;
    }


    @Column(name = "clientReceiving", nullable = false)
    public String getClientReceiving() {
        return clientReceiving;
    }

    public void setClientReceiving(String clientReceiving) {
        this.clientReceiving = clientReceiving;
    }


    @Column(name = "deliveryEmployee", nullable = false)
    public String getDeliveryEmployee() {
        return deliveryEmployee;
    }

    public void setDeliveryEmployee(String deliveryEmployee) {
        this.deliveryEmployee = deliveryEmployee;
    }


    @Column(name = "deliveredOrNot", nullable = false)
    public boolean isDeliveredOrNot() {
        return deliveredOrNot;
    }

    public void setDeliveredOrNot(boolean deliveredOrNot) {
        this.deliveredOrNot = deliveredOrNot;
    }


    @Column(name = "price", nullable = false)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public static Comparator<Package> compareByClientSendingName = new Comparator<Package>() {
        @Override
        public int compare(Package p1, Package p2) {
            return p1.clientSending.compareTo(p2.clientSending);
        }
    };
    
    
    
    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", fromLocation='" + fromLocation + '\'' +
                ", toLocation='" + toLocation + '\'' +
                ", toOffice=" + toOffice +
                ", weight=" + weight +
                ", clientSending='" + clientSending + '\'' +
                ", officeEmployee='" + officeEmployee + '\'' +
                ", clientReceiving='" + clientReceiving + '\'' +
                ", deliveryEmployee='" + deliveryEmployee + '\'' +
                ", deliveredOrNot=" + deliveredOrNot +
                ", price=" + price +
                '}';
    }
}