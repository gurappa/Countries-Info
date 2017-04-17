/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.scenes.countries.events;

import java.util.List;

import se.rebtel.countriesinfo.data.models.Country;

/**
 * Event class that is posted on receiving list of Countries data from remote
 */
public class CountriesReceivedEvent {
    private List<Country> mCountries;

    public CountriesReceivedEvent(List<Country> mCountries) {
        this.mCountries = mCountries;
    }

    public List<Country> getCountries() {
        return mCountries;
    }
}