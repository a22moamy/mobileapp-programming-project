package com.example.project;

import com.google.gson.annotations.SerializedName;
    public class Mountain {

        @SerializedName("ID")
        private String id;
        private String name;
        private String type;
        private String company;
        private String location;
        private String category;

        @SerializedName("size")
        private int meters;

        @SerializedName("cost")
        private int feet;

        public String getName(){ return name; }

        @Override
        public String toString() { return name; }

    }