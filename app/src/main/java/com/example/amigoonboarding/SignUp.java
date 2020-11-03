package com.example.amigoonboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignUp extends AppCompatActivity {

    Button signupbutton;
    TextView haveaccount, signupinstru, welcomesignup;
    TextInputLayout emailsignup, passwordsignup, firstname, lastname;
    CheckBox termscheckbox;
    LinearLayout signuptextinputs, signupscreen;
    ImageView Logo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        //initialize UI elements
        signupbutton = findViewById(R.id.signupconfirmbutton);
        haveaccount = findViewById(R.id.alreadyhaveaccount);
        emailsignup = findViewById(R.id.Emailsignup);
        passwordsignup = findViewById(R.id.Passwordsignup);
        termscheckbox = findViewById(R.id.termscheckbox);
        signuptextinputs = findViewById(R.id.signuptextinputs);
        firstname = findViewById(R.id.FirstName);
        lastname = findViewById(R.id.LastName);
        Logo = findViewById(R.id.logoimagesignup);
        welcomesignup = findViewById(R.id.welcomesignup);
        signupinstru = findViewById(R.id.instrusignup);
        signupscreen = findViewById(R.id.signupscreen);


        //dont have account go to signup page
        haveaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Pair[] pairs = new Pair[8];
                pairs[0] = new Pair<View, String>(Logo, "LogoSignInUp");
                pairs[1] = new Pair<View, String>(welcomesignup, "WelcomeSignInUp");
                pairs[2] = new Pair<View, String>(signupinstru, "InstruSignInUp");
                pairs[3] = new Pair<View, String>(emailsignup, "emailtrans");
                pairs[4] = new Pair<View, String>(passwordsignup, "passwordtrans");
                pairs[5] = new Pair<View, String>(signupbutton, "signupsigninbutton");
                pairs[6] = new Pair<View, String>(haveaccount, "LoginLogouttoggle");
                pairs[7] = new Pair<View, String>(signupscreen, "screentransit");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this, pairs);
                startActivity((new Intent(getApplicationContext(), SignIn.class)),options.toBundle());
            }
        });
    }



}