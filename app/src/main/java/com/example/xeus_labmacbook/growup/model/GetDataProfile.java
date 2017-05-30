package com.example.xeus_labmacbook.growup.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class GetDataProfile{

	@SerializedName("data")
	private List<ProfileData> data;

	public void setData(List<ProfileData> data){
		this.data = data;
	}

	public List<ProfileData> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"GetDataProfile{" + 
			"data = '" + data + '\'' + 
			"}";
		}
}