/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.data.source.remote.net;

import android.support.annotation.NonNull;
import android.util.Log;

import se.rebtel.countriesinfo.data.source.DataSource;
import se.rebtel.countriesinfo.data.source.remote.net.injection.RemoteCountriesRetrofit;
import se.rebtel.countriesinfo.data.source.remote.net.injection.RemoteDetailsRetrofit;

/**
 * Class that makes calls to network layer.
 */
public class RemoteDataSource implements DataSource {

    public static final String TAG = RemoteDataSource.class.getSimpleName();

    @NonNull
    private RetrofitService mRetrofitCountriesService;

    @NonNull
    private RetrofitService mRetrofitDetailsService;

    public RemoteDataSource(@RemoteCountriesRetrofit @NonNull RetrofitService retrofitCountries,
                            @RemoteDetailsRetrofit @NonNull RetrofitService retrofitDetails) {
        mRetrofitCountriesService = retrofitCountries;
        mRetrofitDetailsService = retrofitDetails;
        Log.d(TAG, "DI successful: RemoteDataSource got Retrofit Service : " + mRetrofitCountriesService + " AND " + mRetrofitDetailsService);
    }

    /**
     * Get countries from remote.
     */
    @Override
    public void getCountries() {
        ServerRequests.getCountries(mRetrofitCountriesService);
    }

    /**
     * Get country details from remote.
     *
     * @param countryName country name
     */
    @Override
    public void getCountryDetails(String countryName) {
        ServerRequests.getCountryDetails(mRetrofitDetailsService, countryName);
    }
}