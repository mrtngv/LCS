package com.logistics.Package;

public enum EPackageType {
    DOCUMENTS(1.00),
    ELECTRONICS(1.50),
    BAG(1.80),
    BOX(1.80),
    PALLET(0.50);

    private Double price;

    EPackageType(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }
}
