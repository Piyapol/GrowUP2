package com.example.xeus_labmacbook.growup.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ctrl{

	@SerializedName("sw_light")
	@Expose
	private String swLight;

	@SerializedName("repeat")
	@Expose
	private String repeat;

	@SerializedName("sw_auto")
	@Expose
	private String swAuto;

	@SerializedName("sw_water")
	@Expose
	private String swWater;

	public void setSwLight(String swLight){
		this.swLight = swLight;
	}

	public String getSwLight(){
		return swLight;
	}

	public void setRepeat(String repeat){
		this.repeat = repeat;
	}

	public String getRepeat(){
		return repeat;
	}

	public void setSwAuto(String swAuto){
		this.swAuto = swAuto;
	}

	public String getSwAuto(){
		return swAuto;
	}

	public void setSwWater(String swWater){
		this.swWater = swWater;
	}

	public String getSwWater(){
		return swWater;
	}

	@Override
 	public String toString(){
		return 
			"Ctrl{" + 
			"sw_light = '" + swLight + '\'' + 
			",repeat = '" + repeat + '\'' + 
			",sw_auto = '" + swAuto + '\'' + 
			",sw_water = '" + swWater + '\'' + 
			"}";
		}
}