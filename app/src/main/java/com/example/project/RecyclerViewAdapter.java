package com.example.project;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    private LayoutInflater layoutInflater;
    public ArrayList<RecyclerViewItem> items;

    public RecyclerViewAdapter(Context context, ArrayList<RecyclerViewItem> items, RecyclerViewInterface recyclerViewInterface) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.items = items;
        this.recyclerViewInterface = recyclerViewInterface;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nameView.setText(items.get(position).getName());
        holder.datumView.setText(items.get(position).getDatum());

        String hey = (items.get(position).getImage());

        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier(hey, "drawable", context.getPackageName());
        holder.imageView.setImageResource(resourceId);


    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public interface OnClickListener {
        void onClick(RecyclerViewItem item);
    }
}