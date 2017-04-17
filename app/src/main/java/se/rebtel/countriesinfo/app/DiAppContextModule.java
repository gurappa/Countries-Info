/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.app;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides Application Context.
 */
@Module
public class DiAppContextModule {
    private static final String TAG = DiAppContextModule.class.getSimpleName();

    private Application mApplication;

    public DiAppContextModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        Log.d(TAG, "provideContext.");
        return mApplication;
    }
}