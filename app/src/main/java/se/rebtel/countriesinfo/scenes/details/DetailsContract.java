/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.scenes.details;

import se.rebtel.countriesinfo.data.models.CountryDetails;

/**
 * Details MVP Contract
 */
public interface DetailsContract {
    interface View {

        boolean isActive();

        void updateCountryDetails(CountryDetails countryDetails);
    }

    interface Presenter {
        void onCreate();

        void onDestroy();

        void getCountryDetails(String countryName);
    }
}