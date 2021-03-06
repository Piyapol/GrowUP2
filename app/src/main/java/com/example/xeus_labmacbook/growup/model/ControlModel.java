package com.example.xeus_labmacbook.growup.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by DuckWalkZ on 10/3/2560.
 */

public class ControlModel {
    @SerializedName("ctrl")
    @Expose
    private Ctrl ctrl;

    @SerializedName("error")
    @Expose
    private boolean error;

    public void setCtrl(Ctrl ctrl){
        this.ctrl = ctrl;
    }

    public Ctrl getCtrl(){
        return ctrl;
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
                "Response{" +
                        "ctrl = '" + ctrl + '\'' +
                        ",error = '" + error + '\'' +
                        "}";
    }
}
