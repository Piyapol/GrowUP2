package com.example.xeus_labmacbook.growup.model;


import com.google.gson.annotations.SerializedName;


public class AddProfile{

	@SerializedName("uid")
	private int uid;

	@SerializedName("pot")
	private Pot pot;

	@SerializedName("error")
	private boolean error;

	public void setUid(int uid){
		this.uid = uid;
	}

	public int getUid(){
		return uid;
	}

	public void setPot(Pot pot){
		this.pot = pot;
	}

	public Pot getPot(){
		return pot;
	}

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}

	@Override
 	public String toString(){
		return 
			"AddProfile{" + 
			"uid = '" + uid + '\'' + 
			",pot = '" + pot + '\'' + 
			",error = '" + error + '\'' + 
			"}";
		}
}