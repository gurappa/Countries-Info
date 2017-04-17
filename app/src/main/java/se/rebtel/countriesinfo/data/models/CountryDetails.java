/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.data.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * * Model that holds details about a country details.
 */
public class CountryDetails implements Serializable, Parcelable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("topLevelDomain")
    @Expose
    private List<String> topLevelDomain = null;
    @SerializedName("alpha2Code")
    @Expose
    private String alpha2Code;
    @SerializedName("alpha3Code")
    @Expose
    private String alpha3Code;
    @SerializedName("callingCodes")
    @Expose
    private List<String> callingCodes = null;
    @SerializedName("capital")
    @Expose
    private String capital;
    @SerializedName("altSpellings")
    @Expose
    private List<String> altSpellings = null;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("population")
    @Expose
    private Integer population;
    @SerializedName("latlng")
    @Expose
    private List<Double> latlng = null;
    @SerializedName("demonym")
    @Expose
    private String demonym;
    @SerializedName("area")
    @Expose
    private Double area;
    @SerializedName("gini")
    @Expose
    private Object gini;
    @SerializedName("timezones")
    @Expose
    private List<String> timezones = null;
    @SerializedName("borders")
    @Expose
    private List<String> borders = null;
    @SerializedName("nativeName")
    @Expose
    private String nativeName;
    @SerializedName("numericCode")
    @Expose
    private String numericCode;
    @SerializedName("currencies")
    @Expose
    private List<Currency> currencies = null;
    @SerializedName("languages")
    @Expose
    private List<Language> languages = null;
    @SerializedName("translations")
    @Expose
    private Translations translations;
    @SerializedName("flag")
    @Expose
    private String flag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTopLevelDomain() {
        return topLevelDomain;
    }

    public void setTopLevelDomain(List<String> topLevelDomain) {
        this.topLevelDomain = topLevelDomain;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public List<String> getCallingCodes() {
        return callingCodes;
    }

    public void setCallingCodes(List<String> callingCodes) {
        this.callingCodes = callingCodes;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public List<String> getAltSpellings() {
        return altSpellings;
    }

    public void setAltSpellings(List<String> altSpellings) {
        this.altSpellings = altSpellings;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public List<Double> getLatlng() {
        return latlng;
    }

    public void setLatlng(List<Double> latlng) {
        this.latlng = latlng;
    }

    public String getDemonym() {
        return demonym;
    }

    public void setDemonym(String demonym) {
        this.demonym = demonym;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Object getGini() {
        return gini;
    }

    public void setGini(Object gini) {
        this.gini = gini;
    }

    public List<String> getTimezones() {
        return timezones;
    }

    public void setTimezones(List<String> timezones) {
        this.timezones = timezones;
    }

    public List<String> getBorders() {
        return borders;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public Translations getTranslations() {
        return translations;
    }

    public void setTranslations(Translations translations) {
        this.translations = translations;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }


    public static class Currency implements Serializable, Parcelable {

        @SerializedName("code")
        @Expose
        private String code;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("symbol")
        @Expose
        private String symbol;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.code);
            dest.writeString(this.name);
            dest.writeString(this.symbol);
        }

        public Currency() {
        }

        protected Currency(Parcel in) {
            this.code = in.readString();
            this.name = in.readString();
            this.symbol = in.readString();
        }

        public static final Creator<Currency> CREATOR = new Creator<Currency>() {
            @Override
            public Currency createFromParcel(Parcel source) {
                return new Currency(source);
            }

            @Override
            public Currency[] newArray(int size) {
                return new Currency[size];
            }
        };
    }

    public static class Language implements Serializable, Parcelable {

        @SerializedName("iso639_1")
        @Expose
        private String iso6391;
        @SerializedName("iso639_2")
        @Expose
        private String iso6392;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("nativeName")
        @Expose
        private String nativeName;

        public String getIso6391() {
            return iso6391;
        }

        public void setIso6391(String iso6391) {
            this.iso6391 = iso6391;
        }

        public String getIso6392() {
            return iso6392;
        }

        public void setIso6392(String iso6392) {
            this.iso6392 = iso6392;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNativeName() {
            return nativeName;
        }

        public void setNativeName(String nativeName) {
            this.nativeName = nativeName;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.iso6391);
            dest.writeString(this.iso6392);
            dest.writeString(this.name);
            dest.writeString(this.nativeName);
        }

        public Language() {
        }

        protected Language(Parcel in) {
            this.iso6391 = in.readString();
            this.iso6392 = in.readString();
            this.name = in.readString();
            this.nativeName = in.readString();
        }

        public static final Creator<Language> CREATOR = new Creator<Language>() {
            @Override
            public Language createFromParcel(Parcel source) {
                return new Language(source);
            }

            @Override
            public Language[] newArray(int size) {
                return new Language[size];
            }
        };
    }

    public static class Translations implements Serializable, Parcelable {

        @SerializedName("de")
        @Expose
        private String de;
        @SerializedName("es")
        @Expose
        private String es;
        @SerializedName("fr")
        @Expose
        private String fr;
        @SerializedName("ja")
        @Expose
        private String ja;
        @SerializedName("it")
        @Expose
        private String it;
        @SerializedName("br")
        @Expose
        private String br;
        @SerializedName("pt")
        @Expose
        private String pt;

        public String getDe() {
            return de;
        }

        public void setDe(String de) {
            this.de = de;
        }

        public String getEs() {
            return es;
        }

        public void setEs(String es) {
            this.es = es;
        }

        public String getFr() {
            return fr;
        }

        public void setFr(String fr) {
            this.fr = fr;
        }

        public String getJa() {
            return ja;
        }

        public void setJa(String ja) {
            this.ja = ja;
        }

        public String getIt() {
            return it;
        }

        public void setIt(String it) {
            this.it = it;
        }

        public String getBr() {
            return br;
        }

        public void setBr(String br) {
            this.br = br;
        }

        public String getPt() {
            return pt;
        }

        public void setPt(String pt) {
            this.pt = pt;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.de);
            dest.writeString(this.es);
            dest.writeString(this.fr);
            dest.writeString(this.ja);
            dest.writeString(this.it);
            dest.writeString(this.br);
            dest.writeString(this.pt);
        }

        public Translations() {
        }

        protected Translations(Parcel in) {
            this.de = in.readString();
            this.es = in.readString();
            this.fr = in.readString();
            this.ja = in.readString();
            this.it = in.readString();
            this.br = in.readString();
            this.pt = in.readString();
        }

        public static final Creator<Translations> CREATOR = new Creator<Translations>() {
            @Override
            public Translations createFromParcel(Parcel source) {
                return new Translations(source);
            }

            @Override
            public Translations[] newArray(int size) {
                return new Translations[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeStringList(this.topLevelDomain);
        dest.writeString(this.alpha2Code);
        dest.writeString(this.alpha3Code);
        dest.writeStringList(this.callingCodes);
        dest.writeString(this.capital);
        dest.writeStringList(this.altSpellings);
        dest.writeString(this.region);
        dest.writeValue(this.population);
        dest.writeList(this.latlng);
        dest.writeString(this.demonym);
        dest.writeValue(this.area);
        dest.writeString(String.valueOf(this.gini));
        dest.writeStringList(this.timezones);
        dest.writeStringList(this.borders);
        dest.writeString(this.nativeName);
        dest.writeString(this.numericCode);
        dest.writeList(this.currencies);
        dest.writeList(this.languages);
        dest.writeParcelable(this.translations, flags);
        dest.writeString(this.flag);
    }

    public CountryDetails() {
    }

    protected CountryDetails(Parcel in) {
        this.name = in.readString();
        this.topLevelDomain = in.createStringArrayList();
        this.alpha2Code = in.readString();
        this.alpha3Code = in.readString();
        this.callingCodes = in.createStringArrayList();
        this.capital = in.readString();
        this.altSpellings = in.createStringArrayList();
        this.region = in.readString();
        this.population = (Integer) in.readValue(Integer.class.getClassLoader());
        this.latlng = new ArrayList<Double>();
        in.readList(this.latlng, Double.class.getClassLoader());
        this.demonym = in.readString();
        this.area = (Double) in.readValue(Double.class.getClassLoader());
        this.gini = in.readParcelable(Object.class.getClassLoader());
        this.timezones = in.createStringArrayList();
        this.borders = in.createStringArrayList();
        this.nativeName = in.readString();
        this.numericCode = in.readString();
        this.currencies = new ArrayList<Currency>();
        in.readList(this.currencies, Currency.class.getClassLoader());
        this.languages = new ArrayList<Language>();
        in.readList(this.languages, Language.class.getClassLoader());
        this.translations = in.readParcelable(Translations.class.getClassLoader());
        this.flag = in.readString();
    }

    public static final Creator<CountryDetails> CREATOR = new Creator<CountryDetails>() {
        @Override
        public CountryDetails createFromParcel(Parcel source) {
            return new CountryDetails(source);
        }

        @Override
        public CountryDetails[] newArray(int size) {
            return new CountryDetails[size];
        }
    };

    @Override
    public String toString() {
        return "CountryDetails{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", altSpellings=" + altSpellings +
                ", region='" + region + '\'' +
                ", translations=" + translations +
                ", population=" + population +
                ", latlng=" + latlng +
                ", demonym='" + demonym + '\'' +
                ", area=" + area +
                ", gini=" + gini +
                ", timezones=" + timezones +
                ", borders=" + borders +
                ", nativeName='" + nativeName + '\'' +
                ", callingCodes=" + callingCodes +
                ", topLevelDomain=" + topLevelDomain +
                ", alpha2Code='" + alpha2Code + '\'' +
                ", alpha3Code='" + alpha3Code + '\'' +
                ", currencies=" + currencies +
                ", languages=" + languages +
                '}';
    }
}