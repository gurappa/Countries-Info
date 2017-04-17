/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */
package se.rebtel.countriesinfo.data.source;

import android.support.annotation.NonNull;
import android.util.Log;

import javax.inject.Inject;

/**
 * Represents Model in MVP architecture.
 * This class probably holds the logic to decide whether to
 * fetch the data from locally or remotely.
 */
public class CountriesInfoRepository implements Repository {
    private static final String TAG = CountriesInfoRepository.class.getSimpleName();

    @NonNull
    private DataSource mLocalDataSource;

    @NonNull
    private DataSource mRemoteCountriesDataSource;

    @Inject
    public CountriesInfoRepository(@Local @NonNull DataSource localDataSource,
                                   @Remote @NonNull DataSource remoteDataSource) {
        mLocalDataSource = localDataSource;
        mRemoteCountriesDataSource = remoteDataSource;

        Log.d(TAG, "DI successful: CountriesInfoRepository got Local and Remote data sources: " + mLocalDataSource + " " + mRemoteCountriesDataSource);
    }

    /**
     * Decide whether to get countries from local db or from remote server.
     * Data is not stored locally so for now it always gets from remote.
     */
    @Override
    public void getCountries() {
        mRemoteCountriesDataSource.getCountries();
    }

    /**
     * Decide whether to get country details from local db or from remote server.
     * Data is not stored locally so for now it always gets from remote.
     */
    @Override
    public void getCountryDetails(String countryName) {
        mRemoteCountriesDataSource.getCountryDetails(countryName);
    }
}