package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    private LayoutInflater layoutInflater;
    public ArrayList<RecyclerViewItem> items;

    public RecyclerViewAdapter(Context context, ArrayList<RecyclerViewItem> items) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.items = items;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nameView.setText(items.get(position).getName());
        holder.datumView.setText(items.get(position).getDatum());
        holder.imageView.setText(items.get(position).getImage());

    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public interface OnClickListener {
        void onClick(RecyclerViewItem item);
    }
}