/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */
package se.rebtel.countriesinfo.scenes.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import se.rebtel.countriesinfo.scenes.common.BaseActivity;
import se.rebtel.countriesinfo.scenes.countries.CountriesActivity;

/**
 * Splash activity
 */
public class SplashActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), CountriesActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1000);
    }
}