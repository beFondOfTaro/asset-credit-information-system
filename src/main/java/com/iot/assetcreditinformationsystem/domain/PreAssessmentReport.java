package com.iot.assetcreditinformationsystem.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 预评报单实体类
 */
@Entity
public class PreAssessmentReport {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer userId;//所属用户id

    private boolean isAssessed;//是否已评估

    @NotNull
    private String houseName;//房屋名称

    @NotNull
    private String businessSource;//业务来源

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "guarantee_corporation_id",referencedColumnName = "id",insertable = false,updatable = false)
    private GuaranteeCorporation guaranteeCorporation;//担保公司（可选）

    private String gua_man;//担保经理

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "project_type_id",referencedColumnName = "id",insertable = false,updatable = false)
    private ProjectType projectType;//项目类型

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "bank_id",referencedColumnName = "id",insertable = false,updatable = false)
    private Bank bank;//银行

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "bank_branch_id",referencedColumnName = "id",insertable = false,updatable = false)
    private BankBranch bankBranch;//支行

    @NotNull
    private Date date;//接单日期

    private Date watchTime;//看房时间 （可选）

    @NotNull
    private String client;//委托人

    @NotNull
    private String contactPhone;//看房联系人电话

    @NotNull
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "province_id",referencedColumnName = "id",insertable = false,updatable = false)
    private Province province;//省

    @NotNull
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "city_id",referencedColumnName = "id",insertable = false,updatable = false)
    private City city;//市

    @NotNull
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "region_id",referencedColumnName = "id",insertable = false,updatable = false)
    private Region region;//区

    @NotNull
    private String street;//街道

    @NotNull
    private String bui_uni_flo_num;//项目栋-单元-层-房号

    @NotNull
    private boolean hasData;//是否有资料

    @NotNull
    private BigDecimal area;//评估面积

    @NotNull
    private String housingNature;//房屋性质

    @NotNull
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "house_type_id",referencedColumnName = "id",insertable = false,updatable = false)
    private HouseType houseType;//房屋类型

    private String fie_sur_per;//现场查勘人员(可选)

    private BigDecimal loanAmount;//贷款金额，单位万,10位（可选）

    private int loanRatio;//贷款成数，1-10(可选)

    private BigDecimal watchFee;//看房费（可选）

    private String priceRemarks;//价格备注（可选）

    private String remarks;//备注（可选，写评估需求）

    @NotNull
    private String assessmentPurpose;//评估目的


    //构造方法
    public PreAssessmentReport() {
    }

    public PreAssessmentReport(String houseName, Bank bank, BankBranch bankBranch, City city, Region region, String street, BigDecimal loanAmount) {
        this.houseName = houseName;
        this.bank = bank;
        this.bankBranch = bankBranch;
        this.city = city;
        this.region = region;
        this.street = street;
        this.loanAmount = loanAmount;
    }

    //setter和getter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public boolean isAssessed() {
        return isAssessed;
    }

    public void setAssessed(boolean assessed) {
        isAssessed = assessed;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getBusinessSource() {
        return businessSource;
    }

    public void setBusinessSource(String businessSource) {
        this.businessSource = businessSource;
    }

    public GuaranteeCorporation getGuaranteeCorporation() {
        return guaranteeCorporation;
    }

    public void setGuaranteeCorporation(GuaranteeCorporation guaranteeCorporation) {
        this.guaranteeCorporation = guaranteeCorporation;
    }

    public String getGua_man() {
        return gua_man;
    }

    public void setGua_man(String gua_man) {
        this.gua_man = gua_man;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public BankBranch getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(BankBranch bankBranch) {
        this.bankBranch = bankBranch;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getWatchTime() {
        return watchTime;
    }

    public void setWatchTime(Date watchTime) {
        this.watchTime = watchTime;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBui_uni_flo_num() {
        return bui_uni_flo_num;
    }

    public void setBui_uni_flo_num(String bui_uni_flo_num) {
        this.bui_uni_flo_num = bui_uni_flo_num;
    }

    public boolean isHasData() {
        return hasData;
    }

    public void setHasData(boolean hasData) {
        this.hasData = hasData;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public String getHousingNature() {
        return housingNature;
    }

    public void setHousingNature(String housingNature) {
        this.housingNature = housingNature;
    }

    public HouseType getHouseType() {
        return houseType;
    }

    public void setHouseType(HouseType houseType) {
        this.houseType = houseType;
    }

    public String getFie_sur_per() {
        return fie_sur_per;
    }

    public void setFie_sur_per(String fie_sur_per) {
        this.fie_sur_per = fie_sur_per;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getLoanRatio() {
        return loanRatio;
    }

    public void setLoanRatio(int loanRatio) {
        this.loanRatio = loanRatio;
    }

    public BigDecimal getWatchFee() {
        return watchFee;
    }

    public void setWatchFee(BigDecimal watchFee) {
        this.watchFee = watchFee;
    }

    public String getPriceRemarks() {
        return priceRemarks;
    }

    public void setPriceRemarks(String priceRemarks) {
        this.priceRemarks = priceRemarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAssessmentPurpose() {
        return assessmentPurpose;
    }

    public void setAssessmentPurpose(String assessmentPurpose) {
        this.assessmentPurpose = assessmentPurpose;
    }
}
