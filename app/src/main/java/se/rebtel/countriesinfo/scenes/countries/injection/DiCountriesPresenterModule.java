/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.scenes.countries.injection;

import android.util.Log;

import dagger.Module;
import dagger.Provides;
import se.rebtel.countriesinfo.data.source.Repository;
import se.rebtel.countriesinfo.scenes.countries.CountriesContract;
import se.rebtel.countriesinfo.scenes.countries.CountriesFragment;
import se.rebtel.countriesinfo.scenes.countries.CountriesPresenter;

/**
 * Dagger module that provides CountriesPresenter
 */
@Module
public class DiCountriesPresenterModule {
    private static final String TAG = DiCountriesPresenterModule.class.getSimpleName();

    private final CountriesContract.View mView;

    public DiCountriesPresenterModule(CountriesFragment mView) {
        this.mView = mView;
    }

    @Provides
    CountriesContract.Presenter providesCountriesPresenter(Repository repository) {
        Log.d(TAG, "providesCountriesPresenter.");
        return new CountriesPresenter(repository, mView);
    }
}
