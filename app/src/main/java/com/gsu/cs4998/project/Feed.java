package com.gsu.cs4998.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Feed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed);
    }

    public void solidFood(View view)
    {
        Intent intent = new Intent(this, SolidFood.class);
        startActivity(intent);
    }

    public void liquidFood(View view)
    {
        Intent intent = new Intent(this, LiquidFood.class);
        startActivity(intent);
    }
}