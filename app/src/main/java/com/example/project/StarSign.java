package com.example.project;

import com.google.gson.annotations.SerializedName;
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

        public String getName(){ return name; }

        public String getDatum(){ return datum; }

        public String getImage(){ return "https://cdn.pixabay.com/photo/" + image; }

        @Override
        public String toString() { return name; }

    }