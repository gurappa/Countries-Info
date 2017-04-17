/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.data.source.remote.net.injection;

import android.content.Context;
import android.util.Log;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import se.rebtel.countriesinfo.app.DiAppContextModule;
import se.rebtel.countriesinfo.data.source.remote.net.LoggingInterceptor;
import se.rebtel.countriesinfo.data.source.remote.net.RetrofitService;
import se.rebtel.countriesinfo.utils.Constants;

/**
 * Dagger module that provides Retrofit instance that fetches list of countries.
 */
@Module(includes = DiAppContextModule.class)
public class DiRetrofitCountriesModule {
    private static final String TAG = DiRetrofitCountriesModule.class.getSimpleName();

    @Provides
    OkHttpClient provideOkHttpClient(Context context) {
        Log.d(TAG, "provideOkHttpClient");
        LoggingInterceptor interceptor = new LoggingInterceptor(context);
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    @Provides
    Retrofit provideRetrofit(String url, OkHttpClient okHttpClient) {
        Log.d(TAG, "provideRetrofit");
        return new Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    @RemoteCountriesRetrofit
    RetrofitService providesRetrofitService(Context context) {
        Log.d(TAG, "providesRetrofitService");
        return provideRetrofit(Constants.BASE_COUNTRIES_URL, provideOkHttpClient(context)).create(RetrofitService.class);
    }
}