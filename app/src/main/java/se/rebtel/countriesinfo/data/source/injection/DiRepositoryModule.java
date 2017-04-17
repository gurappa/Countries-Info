/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.data.source.injection;

import android.util.Log;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import se.rebtel.countriesinfo.data.source.CountriesInfoRepository;
import se.rebtel.countriesinfo.data.source.DataSource;
import se.rebtel.countriesinfo.data.source.Local;
import se.rebtel.countriesinfo.data.source.Remote;
import se.rebtel.countriesinfo.data.source.Repository;
import se.rebtel.countriesinfo.data.source.local.LocalDataSource;
import se.rebtel.countriesinfo.data.source.remote.net.injection.DiRetrofitCountriesModule;
import se.rebtel.countriesinfo.data.source.remote.net.RemoteDataSource;
import se.rebtel.countriesinfo.data.source.remote.net.RetrofitService;
import se.rebtel.countriesinfo.data.source.remote.net.injection.DiRetrofitDetailsModule;
import se.rebtel.countriesinfo.data.source.remote.net.injection.RemoteCountriesRetrofit;
import se.rebtel.countriesinfo.data.source.remote.net.injection.RemoteDetailsRetrofit;

/**
 * Dagger module that provides instances of
 * 1) Repository (Singleton)
 * 2) Local Data Source (Singleton)
 * 3) Remote Data Source (Singleton)
 */
@Module(includes = {DiRetrofitCountriesModule.class, DiRetrofitDetailsModule.class})
public class DiRepositoryModule {
    private static final String TAG = DiRetrofitCountriesModule.class.getSimpleName();

    @Provides
    @Singleton
    public Repository providesRepository(@Local DataSource localDataSource,
                                         @Remote DataSource remoteDataSource) {
        Log.d(TAG, "providesRepository.");
        return new CountriesInfoRepository(localDataSource, remoteDataSource);
    }

    @Provides
    @Singleton
    @Local
    DataSource providesLocalDataSource() {
        Log.d(TAG, "providesLocalDataSource.");
        return new LocalDataSource();
    }

    @Provides
    @Singleton
    @Remote
    DataSource providesRemoteDataSource(@RemoteCountriesRetrofit RetrofitService retrofitCountries,
                                        @RemoteDetailsRetrofit RetrofitService retrofitDetails) {
        Log.d(TAG, "providesRemoteDataSource.");
        return new RemoteDataSource(retrofitCountries, retrofitDetails);
    }
}