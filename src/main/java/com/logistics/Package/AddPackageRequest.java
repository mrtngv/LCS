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
    @Size(min = 2, max = 25)
    private String fromCity;

    @NotBlank
    @Size(min = 2, max = 25)
    private String toCity;

    @Size(min = 2, max = 25)
    private String alternativeCity;

    @NotBlank
    @Size(max = 50)
    private String senderEmail;

    @NotBlank
    private boolean isFirm;

    @Size(max = 100)
    private String firmName = "";

    @NotBlank
    private boolean toFirm;

    @Size(max = 100)
    private String toFirmName = "";

    @NotBlank
    private boolean fromOffice;

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
    private boolean toOffice;

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
    private boolean returnToOffice;

    private double cashOnDelivery;

    private String IBAN;

    private boolean isCashOnDelivery;

    private String BIC;

    private String bank;

    private String bankAccountOwner;

    private boolean returnCashToOffice;

    private String returnCashCity;

    public String getReturnCashCity() {
        return returnCashCity;
    }

    public void setReturnCashCity(String returnCashCity) {
        this.returnCashCity = returnCashCity;
    }

    public String getReturnCashAddress() {
        return returnCashAddress;
    }

    public void setReturnCashAddress(String returnCashAddress) {
        this.returnCashAddress = returnCashAddress;
    }

    private String returnCashAddress;

    public double getCashOnDelivery() {
        return cashOnDelivery;
    }

    public void setCashOnDelivery(double cashOnDelivery) {
        this.cashOnDelivery = cashOnDelivery;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public boolean getIsCashOnDelivery() {
        return isCashOnDelivery;
    }

    public void setIsCashOnDelivery(boolean cashOnDelivery) {
        isCashOnDelivery = cashOnDelivery;
    }

    public String getBIC() {
        return BIC;
    }

    public void setBIC(String BIC) {
        this.BIC = BIC;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankAccountOwner() {
        return bankAccountOwner;
    }

    public void setBankAccountOwner(String bankAccountOwner) {
        this.bankAccountOwner = bankAccountOwner;
    }

    public boolean getReturnCashToOffice() {
        return returnCashToOffice;
    }

    public void setReturnCashToOffice(boolean returnCashToOffice) {
        this.returnCashToOffice = returnCashToOffice;
    }

    public boolean getToFirm() {
        return toFirm;
    }

    public void setToFirm(boolean toFirm) {
        this.toFirm = toFirm;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getAlternativeCity() {
        return alternativeCity;
    }

    public void setAlternativeCity(String alternativeCity) {
        this.alternativeCity = alternativeCity;
    }

    public String getToFirmName() {
        return toFirmName;
    }

    public void setToFirmName(String toFirmName) {
        this.toFirmName = toFirmName;
    }

    public LocalDate getDateOfSending() {
        return dateOfSending;
    }

    public void setDateOfSending(LocalDate dateOfSending) {
        this.dateOfSending = dateOfSending;
    }

    @NotBlank
    private boolean isFragile;

    @Size(max = 50)
    public String comment = "";

    @Size(max = 100)
    private String returnLocation = "";

    @NotBlank
    private LocalDate dateOfDelivery;

    private LocalDate dateOfSending;

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

    public boolean getIsFirm() {
        return isFirm;
    }

    public void setIsFirm(boolean firm) {
        isFirm = firm;
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public boolean getFromOffice() {
        return fromOffice;
    }

    public void setIsFromOffice(boolean fromOffice) {
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

    public boolean getToOffice() {
        return toOffice;
    }

    public void setIsToOffice(boolean toOffice) {
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

    public boolean getIsFragile() {
        return isFragile;
    }

    public void setIsFragile(boolean fragile) {
        isFragile = fragile;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean getReturnToOffice() {
        return returnToOffice;
    }

    public void setReturnToOffice(boolean returnToOffice) {
        this.returnToOffice = returnToOffice;
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
