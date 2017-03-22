package com.example.xeus_labmacbook.growup.model;

import com.google.gson.annotations.Expose;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("waterlvl_value")
	@Expose
	private String waterlvlValue;

	@SerializedName("temp_value")
	@Expose
	private String tempValue;

	@SerializedName("light_stat")
	@Expose
	private String lightStat;

	@SerializedName("waterlvl_stat")
	@Expose
	private String waterlvlStat;

	@SerializedName("cus_id")
	@Expose
	private String cusId;

	@SerializedName("temp_stat")
	@Expose
	private String tempStat;

	@SerializedName("light_value")
	@Expose
	private String lightValue;

	@SerializedName("airhumid_value")
	@Expose
	private String airhumidValue;

	@SerializedName("pot_id")
	@Expose
	private String potId;

	@SerializedName("values_timestamp")
	@Expose
	private String valuesTimestamp;

	@SerializedName("airhumid_stat")
	@Expose
	private String airhumidStat;

	@SerializedName("soil_value")
	@Expose
	private String soilValue;

	@SerializedName("soil_stat")
	@Expose
	private String soilStat;

	@SerializedName("plant_name")
	@Expose
	private String plantName;

	public void setWaterlvlValue(String waterlvlValue){
		this.waterlvlValue = waterlvlValue;
	}

	public String getWaterlvlValue(){
		return waterlvlValue;
	}

	public void setTempValue(String tempValue){
		this.tempValue = tempValue;
	}

	public String getTempValue(){
		return tempValue;
	}

	public void setLightStat(String lightStat){
		this.lightStat = lightStat;
	}

	public String getLightStat(){
		return lightStat;
	}

	public void setWaterlvlStat(String waterlvlStat){
		this.waterlvlStat = waterlvlStat;
	}

	public String getWaterlvlStat(){
		return waterlvlStat;
	}

	public void setCusId(String cusId){
		this.cusId = cusId;
	}

	public String getCusId(){
		return cusId;
	}

	public void setTempStat(String tempStat){
		this.tempStat = tempStat;
	}

	public String getTempStat(){
		return tempStat;
	}

	public void setLightValue(String lightValue){
		this.lightValue = lightValue;
	}

	public String getLightValue(){
		return lightValue;
	}

	public void setAirhumidValue(String airhumidValue){
		this.airhumidValue = airhumidValue;
	}

	public String getAirhumidValue(){
		return airhumidValue;
	}

	public void setPotId(String potId){
		this.potId = potId;
	}

	public String getPotId(){
		return potId;
	}

	public void setValuesTimestamp(String valuesTimestamp){
		this.valuesTimestamp = valuesTimestamp;
	}

	public String getValuesTimestamp(){
		return valuesTimestamp;
	}

	public void setAirhumidStat(String airhumidStat){
		this.airhumidStat = airhumidStat;
	}

	public String getAirhumidStat(){
		return airhumidStat;
	}

	public void setSoilValue(String soilValue){
		this.soilValue = soilValue;
	}

	public String getSoilValue(){
		return soilValue;
	}

	public void setSoilStat(String soilStat){
		this.soilStat = soilStat;
	}

	public String getSoilStat(){
		return soilStat;
	}

	public void setPlantName(String plantName){
		this.plantName = plantName;
	}

	public String getPlantName(){
		return plantName;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"waterlvl_value = '" + waterlvlValue + '\'' + 
			",temp_value = '" + tempValue + '\'' + 
			",light_stat = '" + lightStat + '\'' + 
			",waterlvl_stat = '" + waterlvlStat + '\'' + 
			",cus_id = '" + cusId + '\'' + 
			",temp_stat = '" + tempStat + '\'' + 
			",light_value = '" + lightValue + '\'' + 
			",airhumid_value = '" + airhumidValue + '\'' + 
			",pot_id = '" + potId + '\'' + 
			",values_timestamp = '" + valuesTimestamp + '\'' + 
			",airhumid_stat = '" + airhumidStat + '\'' + 
			",soil_value = '" + soilValue + '\'' + 
			",soil_stat = '" + soilStat + '\'' + 
			",plant_name = '" + plantName + '\'' + 
			"}";
		}
}