package com.example.project;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("WeakerAccess")
public class RecyclerViewItem {
    private String name;
    private String datum;
    public RecyclerViewItem(String name, String datum) {
        this.name = name;
        this.datum = datum;
    }


    public String getName() {
        return name;
    }

    public String getDatum() {
        return datum;
    }

}

