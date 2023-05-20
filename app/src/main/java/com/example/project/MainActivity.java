package com.example.project;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;

import java.util.ArrayList;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener, RecyclerViewInterface {

    private StarSign[] mountains;
    private String[] qualities;
    private  RecyclerViewAdapter adapter;
    ArrayList<RecyclerViewItem> items = new ArrayList<>();
    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=a22moamy";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new RecyclerViewAdapter(this, items, this);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        new JsonTask(this, this).execute(JSON_URL);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.home) {
            showHome();
            return true;
        }

        if (id == R.id.about) {
            showAbout();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showHome(){ }

    public void showAbout(){
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }

    @Override
    public void onPostExecute(String json) {

        Gson gson = new Gson();
        StarSign[] signs = gson.fromJson(json, StarSign[].class);



        for (int i=0; i<signs.length; i++) {
            items.add(new RecyclerViewItem(signs[i].getName() , signs[i].getDatum(), signs[i].getImage(), signs[i].getProcent(), signs[i].getAuxdata()));
        }

        adapter.notifyDataSetChanged();

    }

    @Override
    public void onItemClick(int position) {
        RecyclerViewItem sign = items.get(position);
        String datum = sign.getDatum();
        String image = sign.getImage();
        String procent = sign.getProcent();
        String name = sign.getName();
        String[] auxdata = sign.getAuxdata();
        Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
        intent.putExtra("datum", datum);
        intent.putExtra("image", image);
        intent.putExtra("procent", procent);
        intent.putExtra("name", name);
        intent.putExtra("auxdata", auxdata);

        startActivity(intent);
    }
}