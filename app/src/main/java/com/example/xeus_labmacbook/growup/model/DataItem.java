package com.example.xeus_labmacbook.growup.model;


import com.google.gson.annotations.SerializedName;


public class DataItem{

	@SerializedName("temp_stat")
	private String tempStat;

	@SerializedName("airhumid_value")
	private String airhumidValue;

	@SerializedName("waterlvl_value")
	private String waterlvlValue;

	@SerializedName("pot_id")
	private String potId;

	@SerializedName("user_id")
	private String userId;

	@SerializedName("values_timestamp")
	private String valuesTimestamp;

	@SerializedName("airhumid_stat")
	private String airhumidStat;

	@SerializedName("temp_value")
	private String tempValue;

	@SerializedName("soil_value")
	private String soilValue;

	@SerializedName("soil_stat")
	private String soilStat;

	@SerializedName("waterlvl_stat")
	private String waterlvlStat;

	public void setTempStat(String tempStat){
		this.tempStat = tempStat;
	}

	public String getTempStat(){
		return tempStat;
	}

	public void setAirhumidValue(String airhumidValue){
		this.airhumidValue = airhumidValue;
	}

	public String getAirhumidValue(){
		return airhumidValue;
	}

	public void setWaterlvlValue(String waterlvlValue){
		this.waterlvlValue = waterlvlValue;
	}

	public String getWaterlvlValue(){
		return waterlvlValue;
	}

	public void setPotId(String potId){
		this.potId = potId;
	}

	public String getPotId(){
		return potId;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
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

	public void setTempValue(String tempValue){
		this.tempValue = tempValue;
	}

	public String getTempValue(){
		return tempValue;
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

	public void setWaterlvlStat(String waterlvlStat){
		this.waterlvlStat = waterlvlStat;
	}

	public String getWaterlvlStat(){
		return waterlvlStat;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"temp_stat = '" + tempStat + '\'' + 
			",airhumid_value = '" + airhumidValue + '\'' + 
			",waterlvl_value = '" + waterlvlValue + '\'' + 
			",pot_id = '" + potId + '\'' + 
			",user_id = '" + userId + '\'' + 
			",values_timestamp = '" + valuesTimestamp + '\'' + 
			",airhumid_stat = '" + airhumidStat + '\'' + 
			",temp_value = '" + tempValue + '\'' + 
			",soil_value = '" + soilValue + '\'' + 
			",soil_stat = '" + soilStat + '\'' + 
			",waterlvl_stat = '" + waterlvlStat + '\'' + 
			"}";
		}
}