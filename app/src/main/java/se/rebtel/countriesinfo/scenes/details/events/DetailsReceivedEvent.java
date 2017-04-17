/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.scenes.details.events;

import se.rebtel.countriesinfo.data.models.CountryDetails;

/**
 * Event class that is posted on receiving list of Country details data from remote
 */
public class DetailsReceivedEvent {
    protected CountryDetails countryDetails;

    public DetailsReceivedEvent(CountryDetails countryDetails) {
        this.countryDetails = countryDetails;
    }

    public CountryDetails getCountryDetails() {
        return countryDetails;
    }
}