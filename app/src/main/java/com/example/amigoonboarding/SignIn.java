package com.example.amigoonboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignIn extends AppCompatActivity {

    Button signinbutton;
    TextView donthaveaccount, welcomesignin, signininstru;
    TextInputLayout emailsignin, passwordsignin;
    ImageView Logoimage;
    LinearLayout signinscreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        //initialize UI elements
        signinbutton = findViewById(R.id.signinconfirmbutton);
        donthaveaccount = findViewById(R.id.donthaveaccount);
        emailsignin = findViewById(R.id.Emailsignin);
        passwordsignin = findViewById(R.id.Passwordsignin);
        Logoimage = findViewById(R.id.logoimagesignin);
        welcomesignin = findViewById(R.id.welcomesignin);
        signininstru = findViewById(R.id.instrusignin);
        signinscreen = findViewById(R.id.signinscreen);



        //dont have account go to signup page
        donthaveaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pair[] pairs = new Pair[8];
                pairs[0] = new Pair<View, String>(Logoimage, "LogoSignInUp");
                pairs[1] = new Pair<View, String>(welcomesignin, "WelcomeSignInUp");
                pairs[2] = new Pair<View, String>(signininstru, "InstruSignInUp");
                pairs[3] = new Pair<View, String>(emailsignin, "emailtrans");
                pairs[4] = new Pair<View, String>(passwordsignin, "passwordtrans");
                pairs[5] = new Pair<View, String>(signinbutton, "signupsigninbutton");
                pairs[6] = new Pair<View, String>(donthaveaccount, "LoginLogouttoggle");
                pairs[7] = new Pair<View, String>(signinscreen, "screentransit");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignIn.this, pairs);
                startActivity((new Intent(getApplicationContext(), SignUp.class)),options.toBundle());
            }
        });




    }
}