package com.example.amigoonboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    ImageView Splashimg;
    Animation fadein;
    ConstraintLayout SplashScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen2);
        getWindow().setAllowEnterTransitionOverlap(false);
        getWindow().setAllowReturnTransitionOverlap(false);


        //Animation
        fadein = AnimationUtils.loadAnimation(this, R.anim.fadein);
        Splashimg = findViewById(R.id.splashimage);
        SplashScreen = findViewById(R.id.splashscreen);


        Splashimg.setAnimation(fadein);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(restorePrefData()){
//                    Pair[] pairs = new Pair[2];
//                    pairs[0] = new Pair<View, String>(Splashimg, "LogoSignInUp");
//                    pairs[1] = new Pair<View, String>(SplashScreen, "screentransit");
//                    getWindow().setExitTransition(null);
                    Intent intent = new Intent(getApplicationContext(),SignIn.class);
//                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashScreen.this, pairs);
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                }
                else{

                    Intent intent = new Intent(getApplicationContext(),Onboarding.class);
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();}
            }
        }, 2500);

    }

    private boolean restorePrefData(){
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
        Boolean isuserintroed = pref.getBoolean("isIntroed", false);
        return isuserintroed;
    }
}