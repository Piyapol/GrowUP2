package com.example.xeus_labmacbook.growup.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class User{

	@SerializedName("updated_at")
	@Expose
	private Object updatedAt;

	@SerializedName("name")
	@Expose
	private String name;

	@SerializedName("created_at")
	@Expose
	private String createdAt;

	@SerializedName("email")
	@Expose
	private String email;

	public void setUpdatedAt(Object updatedAt){
		this.updatedAt = updatedAt;
	}

	public Object getUpdatedAt(){
		return updatedAt;
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

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"User{" + 
			"updated_at = '" + updatedAt + '\'' + 
			",name = '" + name + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}