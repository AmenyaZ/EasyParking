package com.example.smartparking.Clamping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.smartparking.R;

public class ClampActivity extends AppCompatActivity {

    private Button Vc1;
    private Button Vc2;
    private Button Vc3;
    private Button Trailers;
    private Button BAclamp;
    private Button ImpoundStore;
    private Button Impound;
    private Button Obstruction;
    private Button Others;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clamp);

        Vc1 =(Button)findViewById(R.id.btVc1);
        Vc2 =(Button)findViewById(R.id.btVc2);
        Vc3 =(Button)findViewById(R.id.btVc3);
        Trailers =(Button)findViewById(R.id.btTrailers);
        BAclamp =(Button)findViewById(R.id.btBAclamp);
        ImpoundStore =(Button)findViewById(R.id.btImpoundStore);
        Impound =(Button)findViewById(R.id.btImpound);
        Obstruction =(Button)findViewById(R.id.btObstruction);
        Others =(Button)findViewById(R.id.btOthers);


        Vc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClampActivity.this, Vc1Pay.class);
                startActivity(intent);
            }
        });
        Vc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClampActivity.this, Vc2Pay.class);
                startActivity(intent);
            }
        });
        Vc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClampActivity.this, Vc2Pay.class);
                startActivity(intent);
            }
        });
        Trailers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClampActivity.this, TrailersPay.class);
                startActivity(intent);
            }
        });
        BAclamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClampActivity.this, BAclampPay.class);
                startActivity(intent);
            }
        });
        ImpoundStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClampActivity.this, ImpoundStorePay.class);
                startActivity(intent);
            }
        });
        Impound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClampActivity.this, ImpoundPay.class);
                startActivity(intent);
            }
        });
        Obstruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClampActivity.this, ObstructionPay.class);
                startActivity(intent);
            }
        });
        Others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClampActivity.this, OthersPay.class);
                startActivity(intent);
            }
        });

    }
}
