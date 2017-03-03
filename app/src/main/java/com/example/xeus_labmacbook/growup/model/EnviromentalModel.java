package com.example.xeus_labmacbook.growup.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EnviromentalModel {

	@SerializedName("data")
	@Expose
	private List<DataItem> data;

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"EnviromentalModel{" +
			"data = '" + data + '\'' + 
			"}";
		}
}