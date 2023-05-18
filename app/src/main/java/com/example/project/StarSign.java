package com.example.project;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class StarSign {

        @SerializedName("ID")
        private String id;
        private String name;

        @SerializedName("company")
        private String image;

        @SerializedName("location")
        private String datum;



        @SerializedName("category")
        private String procent;

        private int size;

        private int cost;

        @SerializedName("auxdata")
        private String[] auxdata;

        public String getName(){ return name; }
        public String getDatum(){ return datum; }
        public String getImage(){ return image; }

        public String getProcent() { return procent; }

        public String[] getAuxdata() { return auxdata; }
}