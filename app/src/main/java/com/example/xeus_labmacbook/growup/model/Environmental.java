package com.example.xeus_labmacbook.growup.model;

/**
 * Created by DuckWalkZ on 28/2/2560.
 */

public class Environmental {

    private String potId;
    private String cusId;
    private String plantName;
    private String soilValue;
    private String soilTimestamp;
    private String tempValue;
    private String tempTimestamp;
    private String waterlvlValue;
    private String waterlvlTimestamp;
    private String lightValue;
    private String lightTimestamp;
    private String airhumidValue;
    private String airhumidTimestamp;

    /**
     * No args constructor for use in serialization
     *
     */
    public Environmental() {
    }

    /**
     *
     * @param plantName
     * @param waterlvlTimestamp
     * @param lightValue
     * @param soilValue
     * @param airhumidTimestamp
     * @param tempValue
     * @param cusId
     * @param lightTimestamp
     * @param potId
     * @param soilTimestamp
     * @param waterlvlValue
     * @param airhumidValue
     * @param tempTimestamp
     */
    public Environmental(String potId, String cusId, String plantName, String soilValue, String soilTimestamp, String tempValue, String tempTimestamp, String waterlvlValue, String waterlvlTimestamp, String lightValue, String lightTimestamp, String airhumidValue, String airhumidTimestamp) {
        super();
        this.potId = potId;
        this.cusId = cusId;
        this.plantName = plantName;
        this.soilValue = soilValue;
        this.soilTimestamp = soilTimestamp;
        this.tempValue = tempValue;
        this.tempTimestamp = tempTimestamp;
        this.waterlvlValue = waterlvlValue;
        this.waterlvlTimestamp = waterlvlTimestamp;
        this.lightValue = lightValue;
        this.lightTimestamp = lightTimestamp;
        this.airhumidValue = airhumidValue;
        this.airhumidTimestamp = airhumidTimestamp;
    }

    public String getPotId() {
        return potId;
    }

    public void setPotId(String potId) {
        this.potId = potId;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getSoilValue() {
        return soilValue;
    }

    public void setSoilValue(String soilValue) {
        this.soilValue = soilValue;
    }

    public String getSoilTimestamp() {
        return soilTimestamp;
    }

    public void setSoilTimestamp(String soilTimestamp) {
        this.soilTimestamp = soilTimestamp;
    }

    public String getTempValue() {
        return tempValue;
    }

    public void setTempValue(String tempValue) {
        this.tempValue = tempValue;
    }

    public String getTempTimestamp() {
        return tempTimestamp;
    }

    public void setTempTimestamp(String tempTimestamp) {
        this.tempTimestamp = tempTimestamp;
    }

    public String getWaterlvlValue() {
        return waterlvlValue;
    }

    public void setWaterlvlValue(String waterlvlValue) {
        this.waterlvlValue = waterlvlValue;
    }

    public String getWaterlvlTimestamp() {
        return waterlvlTimestamp;
    }

    public void setWaterlvlTimestamp(String waterlvlTimestamp) {
        this.waterlvlTimestamp = waterlvlTimestamp;
    }

    public String getLightValue() {
        return lightValue;
    }

    public void setLightValue(String lightValue) {
        this.lightValue = lightValue;
    }

    public String getLightTimestamp() {
        return lightTimestamp;
    }

    public void setLightTimestamp(String lightTimestamp) {
        this.lightTimestamp = lightTimestamp;
    }

    public String getAirhumidValue() {
        return airhumidValue;
    }

    public void setAirhumidValue(String airhumidValue) {
        this.airhumidValue = airhumidValue;
    }

    public String getAirhumidTimestamp() {
        return airhumidTimestamp;
    }

    public void setAirhumidTimestamp(String airhumidTimestamp) {
        this.airhumidTimestamp = airhumidTimestamp;
    }

}
