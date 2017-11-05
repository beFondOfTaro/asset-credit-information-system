package com.iot.assetcreditinformationsystem.domain;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 银行表实体类
 */
@Entity
public class Bank {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private String name;//银行名称

    //@OneToMany(fetch = FetchType.LAZY,mappedBy = "bank",cascade = CascadeType.ALL)
    //private List<PreAssessmentReport> preAssessmentReports;

    public Bank() {
    }

//    public List<PreAssessmentReport> getPreAssessmentReports() {
//        return preAssessmentReports;
//    }
//
//    public void setPreAssessmentReports(List<PreAssessmentReport> preAssessmentReports) {
//        this.preAssessmentReports = preAssessmentReports;
//    }

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
