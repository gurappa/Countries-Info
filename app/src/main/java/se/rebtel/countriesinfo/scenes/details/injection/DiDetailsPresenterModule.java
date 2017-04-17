/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.scenes.details.injection;

import android.util.Log;

import dagger.Module;
import dagger.Provides;
import se.rebtel.countriesinfo.data.source.Repository;
import se.rebtel.countriesinfo.scenes.details.DetailsContract;
import se.rebtel.countriesinfo.scenes.details.DetailsFragment;
import se.rebtel.countriesinfo.scenes.details.DetailsPresenter;

/**
 * Dagger module that provides Details Presenter
 */
@Module
public class DiDetailsPresenterModule {
    private static final String TAG = DiDetailsPresenterModule.class.getSimpleName();

    private final DetailsContract.View mView;

    public DiDetailsPresenterModule(DetailsFragment mView) {
        this.mView = mView;
    }

    @Provides
    DetailsContract.Presenter providesDetailsPresenter(Repository repository) {
        Log.d(TAG, "providesDetailsPresenter.");
        return new DetailsPresenter(repository, mView);
    }
}