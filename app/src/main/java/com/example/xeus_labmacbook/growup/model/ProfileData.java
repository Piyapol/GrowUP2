package com.example.xeus_labmacbook.growup.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 29/5/2560.
 */

public class ProfileData {
    @SerializedName("plant_image")
    private String plantImage;

    @SerializedName("user_id")
    private String userId;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("id")
    private String id;

    @SerializedName("plant_type")
    private String plantType;

    @SerializedName("plant_name")
    private String plantName;

    public void setPlantImage(String plantImage){
        this.plantImage = plantImage;
    }

    public String getPlantImage(){
        return plantImage;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getUserId(){
        return userId;
    }

    public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setPlantType(String plantType){
        this.plantType = plantType;
    }

    public String getPlantType(){
        return plantType;
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
                        "plant_image = '" + plantImage + '\'' +
                        ",user_id = '" + userId + '\'' +
                        ",created_at = '" + createdAt + '\'' +
                        ",id = '" + id + '\'' +
                        ",plant_type = '" + plantType + '\'' +
                        ",plant_name = '" + plantName + '\'' +
                        "}";
    }
}
