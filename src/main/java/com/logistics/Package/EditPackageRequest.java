package com.logistics.Package;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class EditPackageRequest {
    @NotBlank
    private Long id;

    @NotBlank
    @Size(min = 6, max = 13)
    private String senderTelephoneNumber;

    @NotBlank
    @Size(min = 6, max = 13)
    private String receiverTelephoneNumber;

    @NotBlank
    @Size(min = 2, max = 25)
    private String toCity;

    @NotBlank
    @Size(max = 50)
    private String toAddress;

    @NotBlank
    @Size(min = 2, max = 25)
    private String alternativeCity;

    @NotBlank
    @Size(max = 100)
    private String returnLocation;

    private boolean toOffice;

    private boolean returnToOffice;

    public boolean getToOffice() {
        return toOffice;
    }

    public void setToOffice(boolean toOffice) {
        this.toOffice = toOffice;
    }

    public boolean getReturnToOffice() {
        return returnToOffice;
    }

    public void setReturnToOffice(boolean returnToOffice) {
        this.returnToOffice = returnToOffice;
    }

    @NotBlank
    private LocalDate dateOfDelivery;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenderTelephoneNumber() {
        return senderTelephoneNumber;
    }

    public void setSenderTelephoneNumber(String senderTelephoneNumber) {
        this.senderTelephoneNumber = senderTelephoneNumber;
    }

    public String getReceiverTelephoneNumber() {
        return receiverTelephoneNumber;
    }

    public void setReceiverTelephoneNumber(String receiverTelephoneNumber) {
        this.receiverTelephoneNumber = receiverTelephoneNumber;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getAlternativeCity() {
        return alternativeCity;
    }

    public void setAlternativeCity(String alternativeCity) {
        this.alternativeCity = alternativeCity;
    }

    public String getReturnLocation() {
        return returnLocation;
    }

    public void setReturnLocation(String returnLocation) {
        this.returnLocation = returnLocation;
    }

    public LocalDate getDateOfDelivery() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(LocalDate dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }
}
