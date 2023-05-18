package com.example.project;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("WeakerAccess")
public class RecyclerViewItem {
    private String name;
    private String datum;
    private String image;
    private String button;

    private String procent;

    private String[] auxdata;

    public RecyclerViewItem(String name, String datum, String image, String procent, String[] auxdata) {
        this.name = name;
        this.datum = datum;
        this.image = image;
        this.button = button;
        this.procent = procent;
        this.auxdata = auxdata;


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

    public String getProcent() {
        return procent;
    }

    public String[] getAuxdata() {
        return auxdata;
    }



}

