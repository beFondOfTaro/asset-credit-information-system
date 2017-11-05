package com.iot.assetcreditinformationsystem.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 外勤勘察
 */
@Entity
public class OutsideSurvey {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private Integer preAssessmentReportId;

    private String houseLocation;//房屋地理位置（从houses获取）

    private String parcel_east;//房屋东临

    private String parcel_west;//房屋西临

    private String parcel_south;//房屋南临

    private String parcel_north;//房屋北临

    private String hou_pro_cer;//房屋产权证

    private String state_owned_land_cer;//国有土地使用证

    private String cell_name;//小区名称

    private Integer built_year;//建成年代

    private String floorAndTotalFloor;//所在楼层/总楼层

    private String registered_use;//登记用途

    private String actual_use;//实际用途

    private BigDecimal built_area;//建筑面积（m^2）

    private BigDecimal floor_height;//层高（m）

    private String utilization_status;//利用现状

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "terrain_id",referencedColumnName = "id",insertable = false,updatable = false)
    private Terrain terrain;//地势

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "noise_source_id",referencedColumnName = "id",insertable = false,updatable = false)
    private NoiseSource noiseSource;//噪音源

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "parking_condition_id",referencedColumnName = "id",insertable = false,updatable = false)
    private ParkingCondition parkingCondition;//停车状况

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "parking_lot_condition_id",referencedColumnName = "id",insertable = false,updatable = false)
    private ParkingLotCondition parkingLotCondition;//车位状况

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "housing_nature_id",referencedColumnName = "id",insertable = false,updatable = false)
    private HousingNature housingNature;//房屋性质

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "building_structure_id",referencedColumnName = "id",insertable = false,updatable = false)
    private BuildingStructure buildingStructure;//建筑结构

    public OutsideSurvey() {
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

    public String getHouseLocation() {
        return houseLocation;
    }

    public void setHouseLocation(String houseLocation) {
        this.houseLocation = houseLocation;
    }

    public String getParcel_east() {
        return parcel_east;
    }

    public void setParcel_east(String parcel_east) {
        this.parcel_east = parcel_east;
    }

    public String getParcel_west() {
        return parcel_west;
    }

    public void setParcel_west(String parcel_west) {
        this.parcel_west = parcel_west;
    }

    public String getParcel_south() {
        return parcel_south;
    }

    public void setParcel_south(String parcel_south) {
        this.parcel_south = parcel_south;
    }

    public String getParcel_north() {
        return parcel_north;
    }

    public void setParcel_north(String parcel_north) {
        this.parcel_north = parcel_north;
    }

    public String getHou_pro_cer() {
        return hou_pro_cer;
    }

    public void setHou_pro_cer(String hou_pro_cer) {
        this.hou_pro_cer = hou_pro_cer;
    }

    public String getState_owned_land_cer() {
        return state_owned_land_cer;
    }

    public void setState_owned_land_cer(String state_owned_land_cer) {
        this.state_owned_land_cer = state_owned_land_cer;
    }

    public String getCell_name() {
        return cell_name;
    }

    public void setCell_name(String cell_name) {
        this.cell_name = cell_name;
    }

    public Integer getBuilt_year() {
        return built_year;
    }

    public void setBuilt_year(Integer built_year) {
        this.built_year = built_year;
    }

    public String getFloorAndTotalFloor() {
        return floorAndTotalFloor;
    }

    public void setFloorAndTotalFloor(String floorAndTotalFloor) {
        this.floorAndTotalFloor = floorAndTotalFloor;
    }

    public String getRegistered_use() {
        return registered_use;
    }

    public void setRegistered_use(String registered_use) {
        this.registered_use = registered_use;
    }

    public String getActual_use() {
        return actual_use;
    }

    public void setActual_use(String actual_use) {
        this.actual_use = actual_use;
    }

    public BigDecimal getBuilt_area() {
        return built_area;
    }

    public void setBuilt_area(BigDecimal built_area) {
        this.built_area = built_area;
    }

    public BigDecimal getFloor_height() {
        return floor_height;
    }

    public void setFloor_height(BigDecimal floor_height) {
        this.floor_height = floor_height;
    }

    public String getUtilization_status() {
        return utilization_status;
    }

    public void setUtilization_status(String utilization_status) {
        this.utilization_status = utilization_status;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public NoiseSource getNoiseSource() {
        return noiseSource;
    }

    public void setNoiseSource(NoiseSource noiseSource) {
        this.noiseSource = noiseSource;
    }

    public ParkingCondition getParkingCondition() {
        return parkingCondition;
    }

    public void setParkingCondition(ParkingCondition parkingCondition) {
        this.parkingCondition = parkingCondition;
    }

    public ParkingLotCondition getParkingLotCondition() {
        return parkingLotCondition;
    }

    public void setParkingLotCondition(ParkingLotCondition parkingLotCondition) {
        this.parkingLotCondition = parkingLotCondition;
    }

    public HousingNature getHousingNature() {
        return housingNature;
    }

    public void setHousingNature(HousingNature housingNature) {
        this.housingNature = housingNature;
    }

    public BuildingStructure getBuildingStructure() {
        return buildingStructure;
    }

    public void setBuildingStructure(BuildingStructure buildingStructure) {
        this.buildingStructure = buildingStructure;
    }
}
