package com.iot.assetcreditinformationsystem.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class OutsidePicture {

    @Id
    @GeneratedValue
    private Integer id;

    private String pic;//图片路径

    @NotNull
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "pic_classify_id",referencedColumnName = "id",insertable = true,updatable = true)
    private PicClassify picClassify;//图片类别

    private Integer preAssessmentReportId;//预评报单

    public OutsidePicture() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public PicClassify getPicClassify() {
        return picClassify;
    }

    public void setPicClassify(PicClassify picClassify) {
        this.picClassify = picClassify;
    }

    public Integer getPreAssessmentReportId() {
        return preAssessmentReportId;
    }

    public void setPreAssessmentReportId(Integer preAssessmentReportId) {
        this.preAssessmentReportId = preAssessmentReportId;
    }
}
