package com.iot.assetcreditinformationsystem.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 区
 */
@Entity
public class Region extends BaseEntity {

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "city_id",referencedColumnName = "id",insertable = false,updatable = false)
    private City city;//城市

    public Region() {
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
