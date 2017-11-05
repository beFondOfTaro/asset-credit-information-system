package com.iot.assetcreditinformationsystem.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * 担保公司
 */
@Entity
public class GuaranteeCorporation {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private String name;//担保公司名

    public GuaranteeCorporation() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
