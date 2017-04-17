/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.data.source.remote.net;

import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import se.rebtel.countriesinfo.data.models.CountryDetails;
import se.rebtel.countriesinfo.utils.Constants;

/**
 * Retrofit service API to end points.
 */
public interface RetrofitService {

    @GET(Constants.COUNTRIES_ENDPOINT)
    Call<JsonObject> getCountries();

    @GET(Constants.COUNTRY_DETAILS_ENDPOINT + "/{name}")
    Call<List<CountryDetails>> getCountryDetails(
            @Path("name") String name
    );
}