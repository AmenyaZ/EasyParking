package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BusParking extends AppCompatActivity {

    private Button Matatu;
    private Button MBus;
    private Button Bus;
    private  Button Taxi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_parking);

        Matatu = (Button)findViewById(R.id.btMatt);
        MBus =(Button)findViewById(R.id.btMiniBus);
        Bus =(Button)findViewById(R.id.btBus);
        Taxi =(Button)findViewById(R.id.btTaxi);

        Matatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BusParking.this, MatatuPay.class);
                startActivity(intent);
            }
        });
        MBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BusParking.this, MBusPay.class);
                startActivity(intent);

            }
        });
        Bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BusParking.this, BusPay.class);
                startActivity(intent);
            }
        });
        Taxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BusParking.this, TaxiPay.class);
                startActivity(intent);
            }
        });
    }
}
