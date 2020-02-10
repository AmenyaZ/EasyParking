package com.example.smartparking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText UserMail;
    private EditText Password;
    private Button LogIn;
    private TextView Register;
    private TextView About;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStatelistener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        UserMail = (EditText)findViewById(R.id.etEmail);
        Password = (EditText)findViewById(R.id.etPassword);
        LogIn = (Button)findViewById(R.id.btnLogIn);
        Register =(TextView)findViewById(R.id.tvRegister);
        About = (TextView)findViewById(R.id.tvAbout);
        mFirebaseAuth = FirebaseAuth.getInstance();

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
                finish();
            }
        });

        mAuthStatelistener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser != null){
                    Toast.makeText(MainActivity.this, "You are Logged In", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                }else {

                    Toast.makeText(MainActivity.this, "Please LogIn", Toast.LENGTH_SHORT).show();
                }
            }
        };

        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = UserMail.getText().toString();
                String pass = Password.getText().toString();

                if (email.isEmpty()) {
                    UserMail.setError("Please Enter Email Address");
                } else if (pass.isEmpty()) {
                    Password.setError("Please enter the password");
                } else if (email.isEmpty() && pass.isEmpty()) {
                    Toast.makeText(MainActivity.this, "All Fields are Empty", Toast.LENGTH_LONG).show();
                } else if (!(email.isEmpty() && pass.isEmpty())) {
                    mFirebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "LogIn Error, Please Check Your Credentials", Toast.LENGTH_LONG).show();
                            } else {
                                Intent intHome = new Intent(MainActivity.this, SecondActivity.class);
                                startActivity(intHome);
                            }
                        }


                    });
                }
//                Register.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent = new Intent(MainActivity.this, Register.class);
//                        startActivity(intent);
//                    }
//                });

//
//                String Text = "Register here";
//                SpannableString spannableString = new SpannableString(Text);
//                final ClickableSpan clickableSpan1 = new ClickableSpan() {
//                    @Override
//                    public void onClick(@NonNull View widget) {
//                        Toast.makeText(MainActivity.this, "Registration", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(MainActivity.this, Register.class);
//                        startActivity(intent);
//                    }
//
//                };
//                spannableString.setSpan(clickableSpan1, 9, 13, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//                TxtView.setText(spannableString);
//                TxtView.setMovementMethod(LinkMovementMethod.getInstance());

            }


        }


        );}


}


