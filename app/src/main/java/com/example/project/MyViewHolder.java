package com.example.project;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder  {

    TextView nameView;
    TextView datumView;
    TextView imageView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        datumView = itemView.findViewById(R.id.datum);
        nameView = itemView.findViewById(R.id.name);
        imageView = itemView.findViewById(R.id.image);

    }

}