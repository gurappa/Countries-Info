/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.data.source.local;

import android.util.Log;

import se.rebtel.countriesinfo.data.source.DataSource;

/**
 * Local data source that gets the data from the device's file system.
 */
public class LocalDataSource implements DataSource {
    private static final String TAG = LocalDataSource.class.getSimpleName();

    public LocalDataSource() {

    }

    /**
     * Gets countries from local file system.
     */
    @Override
    public void getCountries() {
        Log.d(TAG, "getCountries.");
    }

    /**
     * Gets country details from local file system.
     *
     * @param countryName country name.
     */
    @Override
    public void getCountryDetails(String countryName) {

    }
}
