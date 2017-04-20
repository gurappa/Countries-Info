/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.utils;

/**
 * App's Constants
 */
public class Constants {
    //End point to fetch countries and flag images
    public static final String BASE_COUNTRIES_URL = "https://raw.githubusercontent.com/hjnilsson/country-flags/master/";
    public static final String FLAG_IMAGE_250PX_ENDPOINT = "png250px/%s.png";
    public static final String FLAG_IMAGE_1000PX_ENDPOINT = "png1000px/%s.png";
    public static final String COUNTRIES_ENDPOINT = "countries.json";

    //End point to fetch details of a country
    public static final String BASE_COUNTRY_DETAILS_URL = "https://restcountries.eu/rest/v2/";
    public static final String COUNTRY_DETAILS_ENDPOINT = "name";

    //App will receive timeout if it can not connect to server within this time..
    public static int HTTP_CONNECTION_TIMEOUT_MILLIS = 5; //5 seconds
    //App will receive timeout when connected to server but server does not respond within this time..
    public static int HTTP_READ_TIMEOUT_MILLIS = 5; //5 seconds
}