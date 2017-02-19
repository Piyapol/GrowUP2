package com.example.xeus_labmacbook.growup;

/**
 * Created by DuckWalkZ on 20/2/2560.
 */

public class Item {
    private int mImgResource;
    private String mTextLine1;
    private String mTextLine2;
    private  boolean mIsChecked;

    public Item(int imgResource, String textLine1, String textLine2, boolean isChecked) {
        mImgResource = imgResource;
        mTextLine1 = textLine1;
        mTextLine2 = textLine2;
        mIsChecked = isChecked;
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

    public void setChecked(boolean isChecked) {
        mIsChecked = isChecked;
    }
    public boolean getChecked() {
        return mIsChecked;
    }


}