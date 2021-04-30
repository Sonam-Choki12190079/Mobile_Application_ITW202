package com.gcit.todo_11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView TxtHelloWorld;
    private String[] DiffColorArray = {"red", "pink", "purple", "deep_purple",
            "indigo", "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "black" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TxtHelloWorld = findViewById(R.id.textView1);
        if (savedInstanceState != null) {
            TxtHelloWorld.setTextColor(savedInstanceState.getInt("color"));
        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // save the current text color
        outState.putInt("color", TxtHelloWorld.getCurrentTextColor());
    }

    public void ChangeColor(View view) {
        Random random = new Random();
        String colorName = DiffColorArray[random.nextInt(20)];

        int colorResourceName = getResources().getIdentifier(colorName,"color", getApplicationContext().getPackageName());
        int colorResource = ContextCompat.getColor(this, colorResourceName);

        TxtHelloWorld.setTextColor(colorResource);



    }
}