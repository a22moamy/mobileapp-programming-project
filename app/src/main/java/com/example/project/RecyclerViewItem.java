package com.example.project;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("WeakerAccess")
public class RecyclerViewItem {
    private String name;
    private String datum;
    private String image;
    private String button;

    public RecyclerViewItem(String name, String datum, String image) {
        this.name = name;
        this.datum = datum;
        this.image = image;
        this.button = button;


    }


    public String getName() {
        return name;
    }

    public String getDatum() {
        return datum;
    }

    public String getImage() {
        return image;
    }

    public String getButton() {
        return button;
    }

}

