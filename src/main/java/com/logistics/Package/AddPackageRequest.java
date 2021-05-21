package com.logistics.Package;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class AddPackageRequest {
    @NotBlank
    @Size(max = 50)
    private String senderFirstName;

    @NotBlank
    @Size(max = 50)
    private String senderLastName;

    @NotBlank
    @Size(min = 6, max = 13)
    private String senderTelephoneNumber;

    @NotBlank
    @Size(max = 50)
    private String senderEmail;

    @NotBlank
    private boolean isFirm = false;

    @Size(max = 100)
    private String firmName = "";

    @NotBlank
    private boolean fromOffice = true;

    @NotBlank
    @Size(max = 50)
    private String fromAddress;

    @NotBlank
    @Size(max = 50)
    private String receiverFirstName;

    @NotBlank
    @Size(max = 50)
    private String receiverLastName;

    @NotBlank
    @Size(min = 6, max = 13)
    private String receiverTelephoneNumber;

    @NotBlank
    @Size(max = 50)
    private String receiverEmail;

    @NotBlank
    private boolean toOffice = true;

    @NotBlank
    @Size(max = 50)
    private String toAddress;

    @Enumerated(EnumType.STRING)
    private EPackageStatus ePackageStatus;

    @NotBlank
    private EPackageType ePackageType;

    @NotBlank
    private EPayMethod ePayMethod;

    @NotBlank
    private double weight;

    @NotBlank
    private boolean isFragile = false;

    @Size(max = 50)
    public String comment = "";

    @NotBlank
    private boolean isReturnToOffice = false;

    @Size(max = 100)
    private String returnLocation = "";

    @NotBlank
    private LocalDate dateOfDelivery;

    public String getSenderFirstName() {
        return senderFirstName;
    }

    public void setSenderFirstName(String senderFirstName) {
        this.senderFirstName = senderFirstName;
    }

    public String getSenderLastName() {
        return senderLastName;
    }

    public void setSenderLastName(String senderLastName) {
        this.senderLastName = senderLastName;
    }

    public String getSenderTelephoneNumber() {
        return senderTelephoneNumber;
    }

    public void setSenderTelephoneNumber(String senderTelephoneNumber) {
        this.senderTelephoneNumber = senderTelephoneNumber;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public boolean isFirm() {
        return isFirm;
    }

    public void setFirm(boolean firm) {
        isFirm = firm;
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public boolean isFromOffice() {
        return fromOffice;
    }

    public void setFromOffice(boolean fromOffice) {
        this.fromOffice = fromOffice;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getReceiverFirstName() {
        return receiverFirstName;
    }

    public void setReceiverFirstName(String receiverFirstName) {
        this.receiverFirstName = receiverFirstName;
    }

    public String getReceiverLastName() {
        return receiverLastName;
    }

    public void setReceiverLastName(String receiverLastName) {
        this.receiverLastName = receiverLastName;
    }

    public String getReceiverTelephoneNumber() {
        return receiverTelephoneNumber;
    }

    public void setReceiverTelephoneNumber(String receiverTelephoneNumber) {
        this.receiverTelephoneNumber = receiverTelephoneNumber;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public boolean isToOffice() {
        return toOffice;
    }

    public void setToOffice(boolean toOffice) {
        this.toOffice = toOffice;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public EPackageStatus getePackageStatus() {
        return ePackageStatus;
    }

    public void setePackageStatus(EPackageStatus ePackageStatus) {
        this.ePackageStatus = ePackageStatus;
    }

    public EPackageType getePackageType() {
        return ePackageType;
    }

    public void setePackageType(EPackageType ePackageType) {
        this.ePackageType = ePackageType;
    }

    public EPayMethod getePayMethod() {
        return ePayMethod;
    }

    public void setePayMethod(EPayMethod ePayMethod) {
        this.ePayMethod = ePayMethod;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isFragile() {
        return isFragile;
    }

    public void setFragile(boolean fragile) {
        isFragile = fragile;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isReturnToOffice() {
        return isReturnToOffice;
    }

    public void setReturnToOffice(boolean returnToOffice) {
        isReturnToOffice = returnToOffice;
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
