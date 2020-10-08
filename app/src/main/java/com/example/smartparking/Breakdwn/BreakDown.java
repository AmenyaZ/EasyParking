package com.example.smartparking.Breakdwn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.smartparking.R;

public class BreakDown extends AppCompatActivity {

    private Button Vb1;
    private Button Vb2;
    private Button Vb3;
    private Button Accident;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_break_down);

        Vb1 = (Button)findViewById(R.id.btV1);
        Vb2 = (Button)findViewById(R.id.btV2);
        Vb3 = (Button)findViewById(R.id.btV3);
        Accident = (Button)findViewById(R.id.btAccident);

        Vb1.setOnClickListener(v -> {
            Intent intent = new Intent(BreakDown.this, Vb1Pay.class );
            startActivity(intent);
        });
        Vb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BreakDown.this, Vb2Pay.class );
                startActivity(intent);
            }
        });
        Vb3.setOnClickListener(v -> {
            Intent intent = new Intent(BreakDown.this, Vb3Pay.class );
            startActivity(intent);
        });
        Accident.setOnClickListener(v -> {
            Intent intent = new Intent(BreakDown.this, AccReport.class );
            startActivity(intent);
        });
    }
}
