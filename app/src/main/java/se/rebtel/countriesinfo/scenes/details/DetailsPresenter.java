/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.scenes.details;

import android.support.annotation.NonNull;
import android.util.Log;

import com.squareup.otto.Subscribe;

import se.rebtel.countriesinfo.data.source.Repository;
import se.rebtel.countriesinfo.scenes.details.events.DetailsReceivedEvent;
import se.rebtel.countriesinfo.eventbus.Eventbus;

/**
 * Created by gurappachenchugari on 2017-04-12.
 */

public class DetailsPresenter implements DetailsContract.Presenter {
    private static final String TAG = DetailsPresenter.class.getSimpleName();

    //Target injection for view.
    @NonNull
    private DetailsContract.View mDetailsView;

    @NonNull
    private Repository mRepository;

    public DetailsPresenter(@NonNull Repository repository, @NonNull DetailsContract.View view) {
        this.mRepository = repository;
        this.mDetailsView = view;

        Log.d(TAG, "DI successful: Presenter got Repository and View objects : " + mRepository + " " + mDetailsView);
    }

    @Override
    public void onCreate() {
        Eventbus.getInstance().register(this);
    }

    @Override
    public void getCountryDetails(String countryName) {
        mRepository.getCountryDetails(countryName);
    }

    /**
     * Called by Event Bus on receiving details of a country
     *
     * @param event country details event
     */
    @Subscribe
    public void onCountryDetailsReceived(DetailsReceivedEvent event) {
        if (mDetailsView.isActive()) {
            mDetailsView.updateCountryDetails(event.getCountryDetails());
        }
    }

    @Override
    public void onDestroy() {
        Eventbus.getInstance().unregister(this);
    }
}