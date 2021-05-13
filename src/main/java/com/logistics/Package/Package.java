package com.logistics.Package;

import javax.persistence.*;

@Entity
@Table(
        name="packages"
)
public class Package {
    private Long id;
    private String fromUser;
    private String fromAddress;
    private String toUser;
    private String toAddress;
    private boolean isFragile;
    private double weight;
    private double defaultShipping = 4;
    private double price = defaultShipping;
    private String state = "Package is requested";

    public Package() {
    }

    public Package(String fromUser, String fromAddress, String toUser, String toAddress, boolean isFragile, double weight) {
        this.fromUser = fromUser;
        this.fromAddress = fromAddress;
        this.toUser = toUser;
        this.toAddress = toAddress;
        this.isFragile = isFragile;
        this.weight = weight;

        if(isFragile) price += 1;
        if(weight>=1 && weight<=5) {
            price+=1;
        } else if (weight>5){
            price+=2;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    @Column(name="fromUser", nullable = false)
    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    @Column(name="fromAddress", nullable = false)
    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    @Column(name="toUser", nullable = false)
    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    @Column(name="toAddress", nullable = false)
    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    @Column(name="isFragile", nullable = false)
    public boolean isFragile() {
        return isFragile;
    }

    public void setFragile(boolean fragile) {
        isFragile = fragile;
    }

    @Column(name="weight", nullable = false)
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Column(name="shippingPrice", nullable = false)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public double getDefaultShipping() {
//        return defaultShipping;
//    }
//
//    public void setDefaultShipping(double defaultShipping) {
//        this.defaultShipping = defaultShipping;
//    }

    @Column(name="state", nullable = false)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", fromUser='" + fromUser + '\'' +
                ", fromAddress='" + fromAddress + '\'' +
                ", toUser='" + toUser + '\'' +
                ", toAddress='" + toAddress + '\'' +
                ", isFragile=" + isFragile +
                ", weight=" + weight +
                ", price=" + price +
                ", state='" + state + '\'' +
                '}';
    }
}
