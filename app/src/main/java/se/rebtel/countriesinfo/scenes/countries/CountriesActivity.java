/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.scenes.countries;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;

import se.rebtel.countriesinfo.R;
import se.rebtel.countriesinfo.scenes.common.BaseActivity;

/**
 * Act as a container for countries fragment.
 */
public class CountriesActivity extends BaseActivity {
    private static final String TAG = CountriesActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        mToolbar = (Toolbar) findViewById(R.id.toolbar_details);
        mAppBar = (AppBarLayout) findViewById(R.id.appBarLayout);

        mToolbar.setTitle(R.string.app_name);
    }

}