package com.example.asp.roomly_one;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StoreActivity extends AppCompatActivity {
    private Button livingroom, bedroom, office, bd, bsl, ml, den;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Things To Know");

        livingroom = (Button)findViewById(R.id.livingroom);
        livingroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLivingroomActivity();
            }
        });

        bedroom = (Button)findViewById(R.id.bedroom);
        bedroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBedroomActivity();
            }
        });

        office = (Button)findViewById(R.id.office);
        office.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOfficeActivity();
            }
        });

    }
    public void openLivingroomActivity(){
        Intent intent = new Intent(this, LivingroomActivity.class);
        startActivity(intent);
    }

    public void openBedroomActivity(){
        Intent intent = new Intent(this, BedroomActivity.class);
        startActivity(intent);
    }

    public void openOfficeActivity(){
        Intent intent = new Intent(this, OfficeActivity.class);
        startActivity(intent);
    }

}
