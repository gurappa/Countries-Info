/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.data.source.remote.net.injection;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * * Annotation to identify Retrofit country details class.
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface RemoteDetailsRetrofit {

}