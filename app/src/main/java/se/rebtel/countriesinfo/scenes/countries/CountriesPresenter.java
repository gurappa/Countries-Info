/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.scenes.countries;

import android.support.annotation.NonNull;
import android.util.Log;

import com.squareup.otto.Subscribe;

import se.rebtel.countriesinfo.data.source.Repository;
import se.rebtel.countriesinfo.scenes.countries.events.CountriesReceivedEvent;
import se.rebtel.countriesinfo.eventbus.Eventbus;

/**
 * Countries presenter
 */
public class CountriesPresenter implements CountriesContract.Presenter {
    private static final String TAG = CountriesPresenter.class.getSimpleName();

    @NonNull
    private CountriesContract.View mCountriesView;

    @NonNull
    private Repository mRepository;

    public CountriesPresenter(@NonNull Repository repository, @NonNull CountriesContract.View view) {
        this.mRepository = repository;
        this.mCountriesView = view;

        Log.d(TAG, "DI successful: Presenter got Repository and View objects : " + mRepository + " " + mCountriesView);
    }

    @Override
    public void onCreate() {
        Eventbus.getInstance().register(this);
    }

    /**
     * Called by Event Bus on receiving list of countries data
     *
     * @param event
     */
    @Subscribe
    public void onCountriesReceived(CountriesReceivedEvent event) {
        if (mCountriesView.isActive()) {
            mCountriesView.updateCountries(event.getCountries());
        }
    }

    @Override
    public void onDestroy() {
        Eventbus.getInstance().unregister(this);
    }

    @Override
    public void getCountries() {
        mRepository.getCountries();
    }
}