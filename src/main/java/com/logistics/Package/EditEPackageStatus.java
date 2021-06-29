package com.logistics.Package;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

public class EditEPackageStatus {
    @NotBlank
    private Long id;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private EPackageStatus ePackageStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EPackageStatus getePackageStatus() {
        return ePackageStatus;
    }

    public void setePackageStatus(EPackageStatus ePackageStatus) {
        this.ePackageStatus = ePackageStatus;
    }
}
