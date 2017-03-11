package com.example.xeus_labmacbook.growup.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by DuckWalkZ on 9/3/2560.
 */

public class ServerResponse {

        @SerializedName("uid")
        @Expose
        private String uid;

        @SerializedName("error")
        @Expose
        private boolean error;

        @SerializedName("user")
        @Expose
        private User user;

        public void setUid(String uid){
            this.uid = uid;
        }

        public String getUid(){
            return uid;
        }

        public void setError(boolean error){
            this.error = error;
        }

        public boolean isError(){
            return error;
        }

        public void setUser(User user){
            this.user = user;
        }

        public User getUser(){
            return user;
        }

        @Override
        public String toString(){
            return
                    "Response{" +
                            "uid = '" + uid + '\'' +
                            ",error = '" + error + '\'' +
                            ",user = '" + user + '\'' +
                            "}";
        }
}
