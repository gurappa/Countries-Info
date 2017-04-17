/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.data.source.injection;

import javax.inject.Singleton;

import dagger.Component;
import se.rebtel.countriesinfo.app.DiAppContextModule;
import se.rebtel.countriesinfo.data.source.Repository;

/**
 * Dagger component that provides objects of DiAppContextModule and DiRepositoryModule.
 */
@Singleton
@Component(modules = {DiAppContextModule.class, DiRepositoryModule.class})
public interface DiRepositoryComponent {

    //Repository is a model in MVP architecture.
    Repository repository();
}