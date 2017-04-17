/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.data.source;

/**
 * Interface to local and remote data source classes.
 */
public interface DataSource {

    void getCountries();
    
    void getCountryDetails(String countryName);
}