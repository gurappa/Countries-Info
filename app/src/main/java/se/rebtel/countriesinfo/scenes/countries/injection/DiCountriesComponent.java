/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.scenes.countries.injection;

import dagger.Component;
import se.rebtel.countriesinfo.data.source.injection.DiRepositoryComponent;
import se.rebtel.countriesinfo.scenes.countries.CountriesFragment;

/**
 * Dagger Countries component that builds CountriesPresenter and triggers RepositoryComponent too.
 */
@CountriesScope
@Component(dependencies = DiRepositoryComponent.class, modules = DiCountriesPresenterModule.class)
public interface DiCountriesComponent {
    void injectCountriesActivity(CountriesFragment countriesFragment);
}