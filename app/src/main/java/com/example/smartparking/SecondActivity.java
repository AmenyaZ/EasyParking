package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.smartparking.Breakdwn.BreakDown;
import com.example.smartparking.BusPrk.BusParking;
import com.example.smartparking.Clamping.ClampActivity;
import com.example.smartparking.Cont.ContactActivity;
import com.example.smartparking.DailyPrk.DailyParking;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class SecondActivity extends AppCompatActivity {

    private TextView LogOut;
    private Button BusPark;
    private Button Dailypark;
    private Button Breakdown;
    private Button Clumping;
    private  Button Contact;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        BusPark =(Button)findViewById(R.id.btBusPark);
        Dailypark =(Button)findViewById(R.id.btDailyPark);
        Breakdown = (Button)findViewById(R.id.btBreakDown);
        Clumping = (Button)findViewById(R.id.btClamping);
        Contact = (Button)findViewById(R.id.btContact);
        LogOut =(TextView)findViewById(R.id.tvLogOut);
        mFirebaseAuth = FirebaseAuth.getInstance();

        Contact.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, ContactActivity.class);
            startActivity(intent);
        });

        Clumping.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, ClampActivity.class);
            startActivity(intent);
        });

        Breakdown.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, BreakDown.class);
            startActivity(intent);
        });

        Dailypark.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, DailyParking.class);
            startActivity(intent);
        });
        BusPark.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, BusParking.class);
            startActivity(intent);
        });

        LogOut.setOnClickListener(v -> {

            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(intent);
            return;
        });
    }
}
