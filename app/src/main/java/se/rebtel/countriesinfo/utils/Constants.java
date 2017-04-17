/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.utils;

/**
 * App's Constants
 */
public class Constants {
    //End point to fetch flag images
    public static final String BASE_COUNTRIES_URL = "https://raw.githubusercontent.com/hjnilsson/country-flags/master/";
    public static final String IMAGE_COUNTRY_ENDPOINT = "png250px/%s.png";
    public static final String COUNTRIES_ENDPOINT = "countries.json";

    //End point to fetch details of a country
    public static final String BASE_COUNTRY_DETAILS_URL = "https://restcountries.eu/rest/v2/";
    public static final String COUNTRY_DETAILS_ENDPOINT = "name";

}