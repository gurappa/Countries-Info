/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.data.source.remote.net;

import android.util.Log;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import se.rebtel.countriesinfo.data.models.Country;
import se.rebtel.countriesinfo.data.models.CountryDetails;
import se.rebtel.countriesinfo.eventbus.Eventbus;
import se.rebtel.countriesinfo.scenes.countries.events.CountriesReceivedEvent;
import se.rebtel.countriesinfo.scenes.details.events.DetailsReceivedEvent;

/**
 * Single place to all remote API requests.
 * This is where you can migrate to other network library, if you want to.
 */
public class ServerRequests {
    public static final String TAG = ServerRequests.class.getSimpleName();

    /**
     * Gets countries from remote
     *
     * @param retrofitService retrofit
     */
    @SuppressWarnings("unchecked")
    public static void getCountries(RetrofitService retrofitService) {
        Log.d(TAG, "getCountries.");
        if (retrofitService != null) {
            retrofitService
                    .getCountries()
                    .enqueue(new Callback<JsonObject>() {
                        @Override
                        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                            Log.d(TAG, "Successful Response");
                            List<Country> countries = getCountriesResponse(response);
                            CountriesReceivedEvent event = new CountriesReceivedEvent(countries);

                            Eventbus.getInstance().post(event);
                        }

                        @Override
                        public void onFailure(Call<JsonObject> call, Throwable t) {

                        }
                    });
            return;
        } else {
            // TODO No network case

            return;
        }
    }

    /**
     * Gets country details from remote
     *
     * @param retrofitService retrofit
     * @param countryName     country name
     */
    @SuppressWarnings("unchecked")
    public static void getCountryDetails(RetrofitService retrofitService, String countryName) {
        Log.d(TAG, "getCountryDetails.");
        if (retrofitService != null) {
            retrofitService
                    .getCountryDetails(countryName)
                    .enqueue(new Callback<List<CountryDetails>>() {
                        @Override
                        public void onResponse(Call<List<CountryDetails>> call, Response<List<CountryDetails>> response) {
                            DetailsReceivedEvent event;
                            if (response.body() != null) {
                                event = new DetailsReceivedEvent(response.body().get(0));
                            } else {
                                event = new DetailsReceivedEvent(null);
                            }
                            Eventbus.getInstance().post(event);
                        }

                        @Override
                        public void onFailure(Call<List<CountryDetails>> call, Throwable t) {

                        }
                    });
            return;
        } else {
            // TODO No network case

            return;
        }
    }

    /**
     * Processes the countries response
     *
     * @param response
     * @return
     */
    private static List<Country> getCountriesResponse(Response response) {
        List<Country> countries = new ArrayList<>();

        JsonObject object = (JsonObject) response.body();

        Set set = object.entrySet();
        Iterator keys = set.iterator();

        while (keys.hasNext()) {
            // loop to get the dynamic key
            Map.Entry entry = (Map.Entry) keys.next();

            String key = String.valueOf(entry.getKey());
            String value = String.valueOf(entry.getValue()).replace("\"", "");

            countries.add(new Country(key, value));
        }

        return countries;
    }
}