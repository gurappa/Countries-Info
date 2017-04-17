/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.data.source;

/**
 * Repository interface
 */
public interface Repository {
    void getCountries();

    void getCountryDetails(String countryName);
}