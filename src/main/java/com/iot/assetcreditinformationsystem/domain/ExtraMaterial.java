package com.iot.assetcreditinformationsystem.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class ExtraMaterial {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private Integer preAssessmentReportId;

    private Integer propertyOwnershipCertificateId;

    private Integer landCertificateId;

    private Integer leaseContractId;

    private Integer archivesAbstractId;

    private Integer houseImformationProofId;

    public ExtraMaterial() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPreAssessmentReportId() {
        return preAssessmentReportId;
    }

    public void setPreAssessmentReportId(Integer preAssessmentReportId) {
        this.preAssessmentReportId = preAssessmentReportId;
    }

    public Integer getPropertyOwnershipCertificateId() {
        return propertyOwnershipCertificateId;
    }

    public void setPropertyOwnershipCertificateId(Integer propertyOwnershipCertificateId) {
        this.propertyOwnershipCertificateId = propertyOwnershipCertificateId;
    }

    public Integer getLandCertificateId() {
        return landCertificateId;
    }

    public void setLandCertificateId(Integer landCertificateId) {
        this.landCertificateId = landCertificateId;
    }

    public Integer getLeaseContractId() {
        return leaseContractId;
    }

    public void setLeaseContractId(Integer leaseContractId) {
        this.leaseContractId = leaseContractId;
    }

    public Integer getArchivesAbstractId() {
        return archivesAbstractId;
    }

    public void setArchivesAbstractId(Integer archivesAbstractId) {
        this.archivesAbstractId = archivesAbstractId;
    }

    public Integer getHouseImformationProofId() {
        return houseImformationProofId;
    }

    public void setHouseImformationProofId(Integer houseImformationProofId) {
        this.houseImformationProofId = houseImformationProofId;
    }
}
