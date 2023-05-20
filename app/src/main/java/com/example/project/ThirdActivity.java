package com.example.project;

import static java.lang.String.valueOf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Locale;

public class ThirdActivity extends MainActivity {

    /* Note to self: try and fetch data in thirdactivity and evaluate conditions with the help of
    sent intentions? Maybe? Ex. find index for object where attribute "name" == sent intent value?
    If that doesn't work, find another way.

    + Add an array of advice  for zodiacs AND/OR add an array of egenskaper for every sign in
    JSON data.
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


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

    public void showHome(){
        Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void showAbout(){
        Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
        startActivity(intent);
    }

    @Override
    public void onPostExecute(String json) {

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            TextView zodiacTitle = findViewById(R.id.zodiacTitle);
            ImageView zodiacImg = findViewById(R.id.imageView);
            TextView zodiacDatum = findViewById(R.id.zodiacDatum);
            TextView zodiacProcent = findViewById(R.id.zodiacProcent);
            TextView zodiacQual = findViewById(R.id.zodiacQual);

            String datum = extras.getString("datum");
            String name = extras.getString("name");
            String image = extras.getString("image");
            String procent = extras.getString("procent");
            String[] auxdata = extras.getStringArray("auxdata");

            zodiacDatum.setText(datum);
            zodiacTitle.setText(name);
            zodiacProcent.setText(procent + " av befolkningen i världen är " + (name.toLowerCase(Locale.ROOT)) + ".");
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < auxdata.length; i++) {
                stringBuilder.append(auxdata[i]);
                if (i < auxdata.length - 1) { stringBuilder.append(", "); }
            }
            String egenskaper = stringBuilder.toString();
            zodiacQual.setText("Ni är " + egenskaper + ".");

            Resources resources = getResources();
            int resourceId = resources.getIdentifier(image, "drawable", getPackageName());
            zodiacImg.setImageResource(resourceId);

        }

    }

}

