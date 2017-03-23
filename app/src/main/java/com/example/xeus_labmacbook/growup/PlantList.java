package com.example.xeus_labmacbook.growup;

/**
 * Created by DuckWalkZ on 21/3/2560.
 */

public class PlantList {
    private int mImgResource;
    private String mTextLine1;
    private String mTextLine2;



    public PlantList(int imgResource, String textLine1, String textLine2) {
        mImgResource = imgResource;
        mTextLine1 = textLine1;
        mTextLine2 = textLine2;

    }

    public void setImgResource(int imgResource) {
        mImgResource = imgResource;
    }
    public int getImgResource() {
        return mImgResource;
    }

    public void setTextLine1(String textLine1) {
        mTextLine1 = textLine1;
    }
    public String getTextLine1() {
        return mTextLine1;
    }

    public void setTextLine2(String textLine2) {
        mTextLine2 = textLine2;
    }
    public String getTextLine2() {
        return mTextLine2;
    }


}
