package com.iot.assetcreditinformationsystem.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class LocationInfo {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private Integer preAssessmentReportId;

    @NotNull
    private BigDecimal longitude;

    @NotNull
    private BigDecimal latitude;

    @NotNull
    private String placeName;

    public LocationInfo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public Integer getPreAssessmentReportId() {
        return preAssessmentReportId;
    }

    public void setPreAssessmentReportId(Integer preAssessmentReportId) {
        this.preAssessmentReportId = preAssessmentReportId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
}
