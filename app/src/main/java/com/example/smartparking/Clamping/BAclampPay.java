package com.example.smartparking.Clamping;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.androidstudy.daraja.Daraja;
import com.androidstudy.daraja.DarajaListener;
import com.androidstudy.daraja.model.AccessToken;
import com.androidstudy.daraja.model.LNMExpress;
import com.androidstudy.daraja.model.LNMResult;
import com.androidstudy.daraja.util.TransactionType;
import com.example.smartparking.GenericLoader;
import com.example.smartparking.R;

public class BAclampPay extends AppCompatActivity {

    private Button PayBtn;
    // private TextView AmountInfo;
    private Daraja Daraja1;
    private String mPesaResult;
    private GenericLoader genericLoader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matatu_pay);
        //setSupportActionBar(toolbar);
        PayBtn = findViewById(R.id.btnPay);
        //  AmountInfo = findViewById(R.id.tvInfoAmount);

        Daraja1 = Daraja.with("waoFzKgJGq0ZTfS0LLm7yIloiXqBnqoh", "EFUU9AtK4rjBn9nb", new DarajaListener<AccessToken>() {
            @Override
            public void onResult(@NonNull AccessToken accessToken) {

                //Log.i(MainActivity.this.getClass().getSimpleName(), accessToken.getAccess_token());
                //Toast.makeText(MainActivity.this, "TOKEN : " + accessToken.getAccess_token(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onError(String error) {

                Toast.makeText(BAclampPay.this, "Error " + error, Toast.LENGTH_SHORT).show();
            }
        });
        genericLoader = new GenericLoader();
    }
    @Override
    protected void onStart() {
        super.onStart();

        PayBtn.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("StaticFieldLeak")
            @Override
            public void onClick(View view) {

//                if (TextUtils.isEmpty(amount.getText().toString()) || TextUtils.isEmpty(account.getText().toString())) {
//                    Toast.makeText(getApplicationContext(), "All  Fields are required ", Toast.LENGTH_SHORT).show();
//                }


                new AsyncTask<Void, Void, String>() {

                    @Override
                    protected void onPreExecute() {
                        super.onPreExecute();

                        genericLoader.show(getSupportFragmentManager(), "tag");
                        // Toast.makeText(getApplicationContext(),"started call to mpesa ...",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    protected String doInBackground(Void... voids) {
                        return initiateStkPush();
                    }

                    @Override
                    protected void onPostExecute(String aMessage) {
                        super.onPostExecute(aMessage);
                        Toast.makeText(getApplicationContext(), aMessage, Toast.LENGTH_SHORT).show();
                    }
                }.execute();
            }


        });


    }

    private String initiateStkPush() {

        //Get Phone Number from User Input

        int amount = 100 ;
        //  String amountSent = amount.toString().trim();
        // String user_account_name = account.getText().toString();


        //TODO :: REPLACE WITH YOUR OWN CREDENTIALS  :: THIS IS SANDBOX DEMO
        LNMExpress lnmExpress = new LNMExpress(
                "174379",
                "bfb279f9aa9bdbcf158e97dd71a467cd2e0c893059b10f78e6b72ada1ed2c919",  //https://developer.safaricom.co.ke/test_credentials
                TransactionType.CustomerPayBillOnline,
                "10000",
                "254700322829",
                "174379",
                "254700322829",
                "http://mpesa-requestbin.herokuapp.com/w3lmpsw3",
                "Easy Parking Kakamega",
                "API TESTING"
        );


        Daraja1.requestMPESAExpress(lnmExpress,
                new DarajaListener<LNMResult>() {
                    @Override
                    public void onResult(@NonNull LNMResult lnmResult) {
                        Log.i(BAclampPay.this.getClass().getSimpleName(), lnmResult.ResponseDescription);
                        mPesaResult = "Success " + lnmResult.ResponseDescription;
                        genericLoader.dismiss();
                    }

                    @Override
                    public void onError(String error) {
                        Log.i(BAclampPay.this.getClass().getSimpleName(), error);
                        genericLoader.dismiss();
                    }
                }
        );



        return mPesaResult;

    }


}


