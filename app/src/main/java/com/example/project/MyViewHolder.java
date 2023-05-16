package com.example.project;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder  {

    TextView nameView;
    TextView datumView;
    ImageView imageView;
    Button buttonView;

    public MyViewHolder(@NonNull View itemView, final RecyclerViewInterface recyclerViewInterface) {
        super(itemView);
        datumView = itemView.findViewById(R.id.datum);
        nameView = itemView.findViewById(R.id.name);
        imageView = itemView.findViewById(R.id.image);
        buttonView = itemView.findViewById(R.id.button);

        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  if(recyclerViewInterface != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                  }
            }
        });


    }

}