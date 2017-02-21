package com.example.xeus_labmacbook.growup;

/**
 * Created by DuckWalkZ on 20/2/2560.
 */

public class Item {
    private int mImgResource;
    private String mTextLine1;
    private String mTextLine2;
    private String mTextLine3;
    //    private  boolean mIsChecked;

    public Item(int imgResource, String textLine1, String textLine2, String textLine3) {
        mImgResource = imgResource;
        mTextLine1 = textLine1;
        mTextLine2 = textLine2;
        mTextLine3 = textLine3;
//        mIsChecked = isChecked;
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

    public void setTextLine3(String textLine2) {
        mTextLine3 = textLine2;
    }
    public String getTextLine3() {
        return mTextLine3;
    }
//    public void setChecked(boolean isChecked) {
//        mIsChecked = isChecked;
//    }
//    public boolean getChecked() {
//        return mIsChecked;
//    }


}
