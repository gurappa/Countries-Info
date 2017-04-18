/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.scenes.countries;

import java.util.List;

import se.rebtel.countriesinfo.data.models.Country;

/**
 * Countries MVP contract
 */
public interface CountriesContract {
    interface View {

        boolean isActive();

        void updateCountries(List<Country> countries);
    }

    interface Presenter {

        void onCreate();

        void onDestroy();

        void getCountries();
    }
}