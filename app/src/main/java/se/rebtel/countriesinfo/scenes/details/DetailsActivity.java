/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.scenes.details;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import se.rebtel.countriesinfo.R;
import se.rebtel.countriesinfo.data.models.Country;
import se.rebtel.countriesinfo.scenes.common.BaseActivity;

/**
 * Mostly it is just a container
 */
public class DetailsActivity extends BaseActivity {
    private static final String TAG = DetailsActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        mToolbar = (Toolbar) findViewById(R.id.toolbar_details);
        mAppBar = (AppBarLayout) findViewById(R.id.appBarLayout);

        setSupportActionBar(mToolbar);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Country country = bundle.getParcelable(DetailsFragment.ARGUMENT_COUNTRY);
            getSupportActionBar().setTitle(country.getCountryName());
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public void onAttachFragment(android.support.v4.app.Fragment fragment) {
        super.onAttachFragment(fragment);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}