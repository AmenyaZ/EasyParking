package com.example.smartparking.DailyPrk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.smartparking.R;

public class DailyParking extends AppCompatActivity {

    private Button V1;
    private Button V2;
    private Button V3;
    private Button V4;
    private Button V5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_parking);

        V1 = (Button)findViewById(R.id.btV1);
        V2 = (Button)findViewById(R.id.btV2);
        V3 = (Button)findViewById(R.id.btV3);
        V4 = (Button)findViewById(R.id.btV4);
        V5 = (Button)findViewById(R.id.btV5);

        V1.setOnClickListener(v -> {
            Intent intent = new Intent(DailyParking.this, V1Pay.class);
            startActivity(intent);
        });

        V2.setOnClickListener(v -> {
            Intent intent = new Intent(DailyParking.this, V2Pay.class);
            startActivity(intent);
        });

        V3.setOnClickListener(v -> {
            Intent intent = new Intent(DailyParking.this, V3Pay.class);
            startActivity(intent);
        });

        V4.setOnClickListener(v -> {
            Intent intent = new Intent(DailyParking.this, V4Pay.class);
            startActivity(intent);
        });

        V5.setOnClickListener(v -> {
            Intent intent = new Intent(DailyParking.this, V5Pay.class);
            startActivity(intent);
        });
    }
}
