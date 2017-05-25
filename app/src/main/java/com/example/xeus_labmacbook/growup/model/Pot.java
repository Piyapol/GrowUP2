package com.example.xeus_labmacbook.growup.model;


import com.google.gson.annotations.SerializedName;


public class Pot{

	@SerializedName("image")
	private String image;

	@SerializedName("name")
	private String name;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("type")
	private String type;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"Pot{" + 
			"image = '" + image + '\'' + 
			",name = '" + name + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}