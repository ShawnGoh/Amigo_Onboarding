package com.example.amigoonboarding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class Onboarding extends AppCompatActivity {

    private ViewPager2 onboardingscroller;
    Button SignupBtn, SigninBtn, SkipBtn;
    OnboardingViewPagerAdapter onboardingViewPagerAdapter;
    TabLayout tabindicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        //Initialize other screen UI elements
        SigninBtn = findViewById(R.id.OnboardingSigninButton);
        SignupBtn = findViewById(R.id.OnboardingSignupButton);
        SkipBtn = findViewById(R.id.OnboardingSkipButton);
        tabindicator = findViewById(R.id.OnboardingPageIndicator);





        try //to remove top title bar
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}


        //fill onboardingList items
        ArrayList<OnboardingItem> onboardingList = new ArrayList<>();
        onboardingList.add(new OnboardingItem("DISCOVER", "Discover other projects that can help you improve on your skills and interests!\n", R.drawable.onboarding_discover));
        onboardingList.add(new OnboardingItem("CREATE", "Create projects that you are looking to initiate", R.drawable.onboarding_create));
        onboardingList.add(new OnboardingItem("CONNECT", "Meet new people to connect with and collaborate!", R.drawable.onboarding_connect));
        onboardingList.add(new OnboardingItem("What are you waiting for?", "Sign up and start creating now!", R.drawable.onboarding_wait));


        //Initialize onboarding scroller
        onboardingscroller =  findViewById(R.id.OnboardingScroller);
        onboardingViewPagerAdapter = new OnboardingViewPagerAdapter(this, onboardingList);
        onboardingscroller.setAdapter(onboardingViewPagerAdapter);

        new TabLayoutMediator(tabindicator, onboardingscroller,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText("");
                    }
                }
        ).attach();
        }






    }
