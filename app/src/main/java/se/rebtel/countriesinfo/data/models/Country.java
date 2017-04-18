/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.data.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Model that holds country name and code.
 */
public class Country implements Serializable, Parcelable, Comparable<Country> {
    private String countryName;
    private String countryCode;

    public Country(String countryCode, String countryName) {
        this.countryName = countryName;
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "Country{" +
                ", countryName='" + countryName + '\'' +
                "countryCode='" + countryCode + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.countryCode);
        dest.writeString(this.countryName);
    }

    protected Country(Parcel in) {
        this.countryCode = in.readString();
        this.countryName = in.readString();
    }

    public static final Parcelable.Creator<Country> CREATOR = new Parcelable.Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel source) {
            return new Country(source);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };

    @Override
    public int compareTo(Country o) {
        return this.getCountryName().compareToIgnoreCase(o.getCountryName());
    }

}