package com.ss_technology.mushinprojectandroidapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.ss_technology.mushinprojectandroidapp.R;

public class main__home extends AppCompatActivity {

    LottieAnimationView lottie1, lottie2, lottie3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lottie1 = findViewById(R.id.lottieques);
        lottie2 = findViewById(R.id.lottieadd);
        lottie3 = findViewById(R.id.lottielist);


        lottie1.animate().translationX(2000).setDuration(2000).setStartDelay(2900);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(getApplicationContext(),MainActivity.class);
            }
        }, 5000);

        lottie2.animate().translationX(2000).setDuration(2000).setStartDelay(2900);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(getApplicationContext(),MainActivity.class);

            }
        }, 5000);

        lottie3.animate().translationX(2000).setDuration(2000).setStartDelay(2900);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(getApplicationContext(),MainActivity.class);

            }
        }, 5000);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return true;
    }

    public void Amination(View view) {
        startActivity(new Intent(getApplicationContext(), Animation.class));
    }
    public void Add_YOur_Pets(View view) {
        startActivity(new Intent(getApplicationContext(),Add_Your_Pet.class));
    }
    public void YOur_Pets_List(View view) {
        startActivity(new Intent(getApplicationContext(),Your_Pets_List.class));
    }

    public void Buy_Pets(View view) {
        startActivity(new Intent(getApplicationContext(),Buy_Pets.class));
    }

    public void Sell_Pets(View view) {
        startActivity(new Intent(getApplicationContext(),Sell_Pets.class));
    }

    public void Sell_Pets_List(View view) {
        startActivity(new Intent(getApplicationContext(), Your_Sell_Lists.class));
    }

    public void Chat_Now(View view) {
        startActivity(new Intent(getApplicationContext(),Chats.class));
    }

    public void Diet_Plan(View view) {
        startActivity(new Intent(getApplicationContext(),Diet_chart.class));
    }

    public void Profile(View view) {
        startActivity(new Intent(getApplicationContext(),Profile.class));
    }

    public void Contact_Us(View view) {
        startActivity(new Intent(getApplicationContext(),Contact_Us.class));
    }

    public void Question(View view) {
        startActivity(new Intent(getApplicationContext(),Website.class));
    }

    public void Vaccination(View view) {
        startActivity(new Intent(getApplicationContext(),Vaccination.class));
    }

}